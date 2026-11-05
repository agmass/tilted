package org.agmas.mixin;

import net.minecraft.world.inventory.SmithingMenu;
//import net.minecraft.world.item.crafting.RecipePropertySet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SmithingMenu.class)
public abstract class SmithingMenuMixin {

// not necessary?? <-_->

//    @Shadow
//    @Final
//    private RecipePropertySet baseItemTest;
//
//    @Shadow
//    @Final
//    private RecipePropertySet templateItemTest;
//
//    @Shadow
//    @Final
//    private RecipePropertySet additionItemTest;

    @Inject(method = "createResult", at = @At(value = "TAIL"))
    public void noSoundEntity(CallbackInfo ci) {

    }
}
