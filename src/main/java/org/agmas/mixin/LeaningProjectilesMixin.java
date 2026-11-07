package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.agmas.ModAttachments;
import org.agmas.ModComponents;
import org.agmas.ModTags;
import org.agmas.attachments.BarrelAttachment;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;

//? if >=1.21.2 {

//? } else {
/*import net.minecraft.world.InteractionResultHolder;
*///? }

@Mixin(value = Projectile.class, priority = 3000)
public abstract class LeaningProjectilesMixin extends Entity {
    public LeaningProjectilesMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @WrapMethod(method = "shootFromRotation")
    public void change(Entity esource, float xRot, float yRot, float yOffset, float pow, float uncertainty, Operation<Void> original) {
        // Base ADS stats
        float powerMulti = 1;
        ItemStack stack = null;
        if (esource instanceof Player source) {
            if (source.getOffhandItem().is(ModTags.AIMABLE)) {
                stack = source.getOffhandItem();
            }
            if (source.getMainHandItem().is(ModTags.AIMABLE)) {
                stack = source.getMainHandItem();
            }
            if (stack == null) {
                original.call(esource,xRot,yRot,yOffset,pow,uncertainty);
                return;
            }

            if (source.hasAttached(ModAttachments.IS_AIMING) && source.getAttached(ModAttachments.IS_AIMING).booleanValue()) {
                powerMulti *= 1.1f;
            }
            original.call(esource,xRot,yRot,yOffset,pow*powerMulti,uncertainty);;
            if (source.hasAttached(ModAttachments.LEANING_DIRECTION)) {
                Vector3f shf = new Quaternionf().rotationYXZ((float) (Math.PI - source.getYHeadRot() * (Math.PI / 180F)), (float) (-source.getXRot() * (Math.PI / 180F)), 0.0F)
                        .transform(new Vector3f((float) (-0.3 * source.getAttached(ModAttachments.LEANING_DIRECTION).intValue()), (float) 0, 0));
                setPos(position().x + shf.x, position().y, position().z + shf.z);
            }
        } else {

            original.call(esource,xRot,yRot,yOffset,pow,uncertainty);
        }
    }
}
