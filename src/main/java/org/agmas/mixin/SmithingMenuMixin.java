package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.inventory.SmithingMenu;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.level.Level;
import org.agmas.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SmithingMenu.class)
public abstract class SmithingMenuMixin {

    @Shadow
    @Final
    private RecipePropertySet baseItemTest;

    @Shadow
    @Final
    private RecipePropertySet templateItemTest;

    @Shadow
    @Final
    private RecipePropertySet additionItemTest;

    @Inject(method = "createResult", at = @At(value = "TAIL"))
    public void noSoundEntity(CallbackInfo ci) {

    }
}
