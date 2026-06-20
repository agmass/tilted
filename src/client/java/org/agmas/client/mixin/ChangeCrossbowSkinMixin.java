package org.agmas.client.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;
import org.agmas.ModComponents;
import org.agmas.Tilted;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ItemModelResolver.class, priority = 1005)
public class ChangeCrossbowSkinMixin {

    @ModifyVariable(
            method = {"appendItemLayers"},
            at = @At("STORE"),
            name = {"modelId"}
    )
    private Identifier changeSkinModel(Identifier modelId, ItemStackRenderState output, ItemStack item) {
        if (item.has(ModComponents.SKIN_COMPONENT)) {
            return Tilted.of(ModComponents.skin(item.get(ModComponents.SKIN_COMPONENT)).name().toLowerCase() +"/"+modelId.getPath());
        }
        return modelId;
    }
}
