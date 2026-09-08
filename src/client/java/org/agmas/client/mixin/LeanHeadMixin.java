

package org.agmas.client.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
//? if >= 1.21.11 {
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.EasingType;
import net.minecraft.world.entity.Avatar;
import org.agmas.client.TiltedClient;
//? } else if >= 1.21.6 {
/*import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.model.HumanoidModel;
import org.agmas.client.TiltedClient;
*///? } else {
/*import net.minecraft.world.entity.LivingEntity;
import org.agmas.Tilted;
import org.agmas.client.duck.AvatarAccessor;
import org.agmas.client.polyfill.PF_Mth;
*///? }
import net.minecraft.util.Mth;
import org.agmas.ModAttachments;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = HumanoidModel.class)
public abstract class LeanHeadMixin {
	@Shadow
	@Final
	public ModelPart head;

	//? if < 1.21.6 {

	/*@Unique
	private int tilted$leanPrev = 0;

	@Unique
	private float tilted$ageInTicksUnleanStart = 0;

	*///? }

	//? if >=1.21.11 {
	@Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",at = @At("TAIL"))
	public void leanHead(HumanoidRenderState state, CallbackInfo ci) {
		if (state instanceof AvatarRenderState) {
			var lean = state.getData(TiltedClient.leaningStateDataKey);
			if (lean != null) {
				lean = lean.intValue();
				if (lean != 0) {
					float delta = Mth.clamp((state.ageInTicks - state.getData(TiltedClient.leaningAgeStateDataKey).floatValue()) / 2.0f, 0f, 1f);

					float progress = EasingType.OUT_SINE.apply(delta);

					head.x += Mth.lerp(progress, 0, lean * 2.5f);
					head.zRot += Mth.lerp(progress, 0, lean * 0.25f);
				}
			}
		}
	}
	//? } else >=1.21.6 {
	/*@Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",at = @At("TAIL"))
	public void leanHead(HumanoidRenderState state, CallbackInfo ci) {
		if (state instanceof HumanoidRenderState) {
			var lean = state.getData(TiltedClient.leaningStateDataKey);
			if (lean != null) {
				lean = lean.intValue();
				if (lean != 0) {
					float delta = Mth.clamp((state.ageInTicks - state.getData(TiltedClient.leaningAgeStateDataKey).floatValue()) / 2.0f, 0f, 1f);

					float progress = Mth.easeInOutSine(delta);

					head.x += Mth.lerp(progress, 0, lean * 2.5f);
					head.zRot += Mth.lerp(progress, 0, lean * 0.25f);
				}
			}
		}
	}
	*///? } else {
	/*@Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
	public void leanHead(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
		if (!(entity instanceof AvatarAccessor)) return;

		var lean = entity.getAttached(ModAttachments.LEANING_DIRECTION);
		if (lean == null) lean = 0;

		if (lean == 0) {
			if (tilted$leanPrev == 0) return;

			if (tilted$ageInTicksUnleanStart == 0) tilted$ageInTicksUnleanStart = ageInTicks;

			float delta = Mth.clamp((ageInTicks - tilted$ageInTicksUnleanStart) / 2.0f, 0.0f, 1.0f);

			float progress = PF_Mth.easeInOutSine(delta);

			head.x = tilted$leanPrev * 2.5f * (1.0f - progress);
			head.zRot = tilted$leanPrev * 0.25f * (1.0f - progress);

			if (progress >= 1.0f) {
				tilted$leanPrev = 0;
				tilted$ageInTicksUnleanStart = 0;
			}
		} else {
			float delta = Mth.clamp((ageInTicks - ((AvatarAccessor)entity).getStartedLeaningAge()) / 2.0f, 0.0f, 1.0f);

			float progress = PF_Mth.easeInOutSine(delta);

			head.x    = Mth.lerp(progress, 0.0f, lean * 2.5f );
			head.zRot = Mth.lerp(progress, 0.0f, lean * 0.25f);

			tilted$leanPrev = lean;
		}
	}
	*///? }
}