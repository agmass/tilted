
package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.Camera;
import net.minecraft.util.EasingType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.agmas.client.TiltedClient;
import org.agmas.client.render.Leaning;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Camera.class)
public abstract class CameraMixin {
	@Shadow
	@Final
	private Quaternionf rotation;

	@Shadow
	private Vec3 position;

	@Shadow
	protected abstract void move(float forwards, float up, float right);

	@Inject(method = "calculateFov", at = @At("TAIL"), cancellable = true)
	private void changeFovWithADS(float partialTicks, CallbackInfoReturnable<Float> cir) {
		float value = cir.getReturnValue();
		if (TiltedClient.adsTicks > 0) {
			if (TiltedClient.pressingADS) {
				cir.setReturnValue(Mth.lerp(EasingType.IN_OUT_SINE.apply(Math.clamp((TiltedClient.adsTicks+partialTicks)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			} else {
				cir.setReturnValue(Mth.lerp(EasingType.IN_OUT_SINE.apply(Math.clamp((TiltedClient.adsTicks-partialTicks)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			}
		}
	}
	@WrapMethod(method = "alignWithEntity")
	private void init(float partialTicks, Operation<Void> original) {
		original.call(partialTicks);
		Vec3 pos = Leaning.lean(((Camera) (Object)this),partialTicks);
		TiltedClient.previousLeanCamPos = pos;
		move((float) Mth.lerp(partialTicks,TiltedClient.previousLeanCamPos.x,pos.x), (float) Mth.lerp(partialTicks,TiltedClient.previousLeanCamPos.y,pos.y), (float) Mth.lerp(partialTicks,TiltedClient.previousLeanCamPos.z,pos.z));
	}
}