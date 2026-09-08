package org.agmas.client.mixin;

//? if >=1.21.4 {

import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;

//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }

import net.minecraft.world.item.ItemStack;
import org.agmas.ModComponents;
import org.agmas.Tilted;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ItemModelResolver.class, priority = 1005)
public class ChangeCrossbowSkinMixin {
    @ModifyVariable(method = "appendItemLayers", at = @At("STORE"), ordinal = 0)
    //? if >=1.21.11 {
    private Identifier changeSkinModel(Identifier modelId, ItemStackRenderState output, ItemStack item) {
     //? } else {
    /*private ResourceLocation changeSkinModel(ResourceLocation modelId, ItemStackRenderState output, ItemStack item) {
        *///? }
        if (item.has(ModComponents.SKIN_COMPONENT)) {
            Tilted.LOGGER.info(ModComponents.skin(item.get(ModComponents.SKIN_COMPONENT)).name().toLowerCase() +"/"+modelId.getPath());
            return Tilted.of(ModComponents.skin(item.get(ModComponents.SKIN_COMPONENT)).name().toLowerCase() +"/"+modelId.getPath());
        }
        return modelId;
    }
}

//? } else {

/*import org.jetbrains.annotations.Nullable;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemOverride;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;

import net.minecraft.client.multiplayer.ClientLevel;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import org.agmas.Tilted;
import org.agmas.ModComponents;

import org.agmas.client.duck.ItemOverridesAccessor;

@Mixin(value = ItemRenderer.class, priority = 1005)
public class ChangeCrossbowSkinMixin {
    @Shadow
    @Final
    private ItemModelShaper itemModelShaper;

    @Inject(method = "getModel", at = @At("RETURN"), cancellable = true)
    private void tilted$changeCrossbowSkin(ItemStack itemStack, Level level, LivingEntity livingEntity, int i, CallbackInfoReturnable<BakedModel> cir) {
        if (!itemStack.has(ModComponents.SKIN_COMPONENT)) return;
        ModelManager modelManager = this.itemModelShaper.getModelManager();

        BakedModel modelOrig = modelManager.getModel(new ModelResourceLocation(BuiltInRegistries.ITEM.getKey(itemStack.getItem()), "inventory"));

        @Nullable ItemOverride override = ((ItemOverridesAccessor)modelOrig.getOverrides()).getOverride(itemStack, (ClientLevel)level, livingEntity, i);
        String pathOverride = override == null ? "item/crossbow" : override.getModel().getPath();

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, pathOverride.substring(0, pathOverride.indexOf('/') + 1) + ModComponents.skin(itemStack.get(ModComponents.SKIN_COMPONENT)).name().toLowerCase() + pathOverride.substring(pathOverride.indexOf('/')));

        BakedModel model = modelManager.getModel(location);
        if (model != null && model != modelManager.getMissingModel()) cir.setReturnValue(model);
    }
}

*///? }
