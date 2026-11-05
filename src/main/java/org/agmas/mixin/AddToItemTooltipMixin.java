package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
//? if >=1.21.6 {
/*import net.minecraft.world.item.component.TooltipDisplay;
*///? }
import org.agmas.ModAttachments;
import org.agmas.ModComponents;
import org.agmas.ModTags;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

@Mixin(Item.class)
public abstract class AddToItemTooltipMixin {
    @Shadow
    @Final
    private static Logger LOGGER;

    //? if >=1.21.6 {
    /*@Inject(method = "appendHoverText", at = @At("HEAD"))
    public void addText(ItemStack itemStack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (itemStack.is(ModTags.CROSSBOWS)) {
            if (itemStack.has(ModComponents.BARREL_COMPONENT)) {
                builder.accept(Component.translatable("tilted.barrels." + ModComponents.barrel(itemStack.get(ModComponents.BARREL_COMPONENT)).name().toLowerCase()).withColor(Color.GRAY.getRGB()));
            } else {
                builder.accept(Component.translatable("tilted.barrels.none").withColor(Color.GRAY.getRGB()));
            }
            if (itemStack.has(ModComponents.SCOPE_COMPONENT)) {
                builder.accept(Component.translatable("tilted.scopes." + ModComponents.scope(itemStack.get(ModComponents.SCOPE_COMPONENT)).name().toLowerCase()).withColor(Color.GRAY.getRGB()));
            } else {
                builder.accept(Component.translatable("tilted.scopes.iron_sights").withColor(Color.GRAY.getRGB()));
            }
        }
    }
    *///? }

    // weird 1.21.1 mixin quirk doesn't like base class mixins, so its moved to LeaningArrowsMixin ;D
}
