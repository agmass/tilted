package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = AbstractArrow.class)
public abstract class SilentArrowMixin extends Entity {
    public SilentArrowMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/arrow/AbstractArrow;isCritArrow()Z"))
    public boolean noTrail(AbstractArrow instance, Operation<Boolean> original) {
        if (instance.isSilent()) {
            return false;
        }
        return original.call(instance);
    }
    @WrapOperation(method = "onHitBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/arrow/AbstractArrow;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"))
    public void noSoundBlock(AbstractArrow instance, SoundEvent soundEvent, float vol, float pitch, Operation<Void> original) {
        if (instance.isSilent()) {
            return;
        }
       original.call(instance,soundEvent,vol,pitch);
    }
    @WrapOperation(method = "onHitEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/arrow/AbstractArrow;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"))
    public void noSoundEntity(AbstractArrow instance, SoundEvent soundEvent, float vol, float pitch, Operation<Void> original) {
        if (instance.isSilent()) {
            return;
        }
        original.call(instance,soundEvent,vol,pitch);
    }
}
