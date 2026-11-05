package org.agmas.client.mixin;

//? if >= 1.21.6 {



/*//? if >=1.21.11 {

/^import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
^///? } else {
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
 //? }
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.entity.LivingEntity;
import org.agmas.ModAttachments;
import org.agmas.client.TiltedClient;
import org.agmas.client.duck.AvatarAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? if >=1.21.11 {
/^@Mixin(value = AvatarRenderer.class)
^///? } else {
@Mixin(value = HumanoidMobRenderer.class)
 //? }
public abstract class ExtractRenderStateMixin {

	//? if >=1.21.11 {
	/^@Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V", at = @At("HEAD"))
	public void tiltedAnimations(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
		^///? } else {
	@Inject(method = "extractHumanoidRenderState", at = @At("TAIL"))
	private static void a(LivingEntity entity, HumanoidRenderState state, float f, ItemModelResolver itemModelResolver, CallbackInfo ci) {
	//? }
		if (entity.hasAttached(ModAttachments.LEANING_DIRECTION)) {
			state.setData(TiltedClient.leaningStateDataKey, entity.getAttached(ModAttachments.LEANING_DIRECTION).intValue());
			if (((AvatarAccessor) entity).getPreviousLeaning() != entity.getAttached(ModAttachments.LEANING_DIRECTION).intValue()) {
				((AvatarAccessor) entity).setPreviousLeaning(entity.getAttached(ModAttachments.LEANING_DIRECTION).intValue());
				((AvatarAccessor) entity).setStartedLeaningAge(state.ageInTicks);
			}
			state.setData(TiltedClient.leaningAgeStateDataKey, ((AvatarAccessor) entity).getStartedLeaningAge());
		} else {
			state.setData(TiltedClient.leaningStateDataKey, 0);
			state.setData(TiltedClient.leaningAgeStateDataKey, 0f);
		}
	}
}

*///? } else {

import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = HumanoidMobRenderer.class)
public abstract class ExtractRenderStateMixin {}

//? }
