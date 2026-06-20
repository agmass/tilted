

package org.agmas.client.mixin;

import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.agmas.ModAttachments;
import org.agmas.client.TiltedClient;
import org.agmas.client.duck.AvatarAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AvatarRenderer.class)
public abstract class ExtractRenderStateMixin {
	@Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V", at = @At("TAIL"))
	public void a(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
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