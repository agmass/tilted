package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.agmas.ModAttachments;
import org.agmas.ModComponents;
import org.agmas.Tilted;
import org.agmas.attachments.BarrelAttachment;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = CrossbowItem.class, priority = 3000)
public abstract class LeaningArrowsMixin extends Item {

    public LeaningArrowsMixin(Properties properties) {
        super(properties);
    }

    @WrapOperation(method = "shootProjectile", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/Entity;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    public void silencedCrossbow(Level instance, Entity except, double x, double y, double z, SoundEvent sound, SoundSource source, float volume, float pitch, Operation<Void> original, @Local(ordinal = 0, argsOnly = true) LivingEntity shooter) {
        ItemStack stack = null;
        if (shooter.getOffhandItem().is(Items.CROSSBOW)) {
            stack = shooter.getOffhandItem();
        }
        if (shooter.getMainHandItem().is(Items.CROSSBOW)) {
            stack = shooter.getMainHandItem();
        }
        if (stack != null) {
            if (stack.has(ModComponents.BARREL_COMPONENT)) {
                if (stack.get(ModComponents.BARREL_COMPONENT).equals(BarrelAttachment.SUPPRESSOR.ordinal())) {
                    original.call(instance,except,x,y,z,sound,source,volume*0.1f,pitch*1.5f);
                    return;
                }
            }
        }
        original.call(instance,except,x,y,z,sound,source,volume,pitch);
    }
    @WrapMethod(method = "shootProjectile")
    public void change(LivingEntity source, Projectile projectileEntity, int index, float power, float uncertainty, float angle, LivingEntity targetOverride, Operation<Void> original) {
        // Base ADS stats
        float uncertaintyMulti =1;
        float powerMulti = 1;
        ItemStack stack = null;
        if (source.getOffhandItem().is(Items.CROSSBOW)) {
            stack = source.getOffhandItem();
        }
        if (source.getMainHandItem().is(Items.CROSSBOW)) {
            stack = source.getMainHandItem();
        }
        if (stack == null) {
            original.call(source,projectileEntity,index,power,uncertainty,angle,targetOverride);
            return;
        }

        if (source.hasAttached(ModAttachments.IS_AIMING) && source.getAttached(ModAttachments.IS_AIMING).booleanValue()) {
            powerMulti *= 1.1f;
        }

        if (stack.has(ModComponents.BARREL_COMPONENT)) {
            uncertaintyMulti *= ModComponents.barrel(stack.get(ModComponents.BARREL_COMPONENT)).uncertaintyMultiplier;
            Log.info(LogCategory.GENERAL, uncertaintyMulti+"");
            if (stack.get(ModComponents.BARREL_COMPONENT).equals(BarrelAttachment.EXTENDED_BARREL.ordinal())) {
                powerMulti *= 2f;
            }
            if (stack.get(ModComponents.BARREL_COMPONENT).equals(BarrelAttachment.SUPPRESSOR.ordinal())) {
                projectileEntity.setSilent(true);
            }
        }

        original.call(source, projectileEntity,index,power*powerMulti,uncertainty*uncertaintyMulti,angle,targetOverride);
        if (source.hasAttached(ModAttachments.LEANING_DIRECTION)) {
            Vector3f shf = new Quaternionf().rotationYXZ((float) (Math.PI - source.getYHeadRot() * (Math.PI / 180F)), (float) (-source.getXRot() * (Math.PI / 180F)), 0.0F)
                    .transform(new Vector3f((float) (-0.3 * source.getAttached(ModAttachments.LEANING_DIRECTION).intValue()), (float) 0,0));
            projectileEntity.setPos(projectileEntity.position().x+shf.x,projectileEntity.position().y,projectileEntity.position().z+shf.z);
        }
    }
}
