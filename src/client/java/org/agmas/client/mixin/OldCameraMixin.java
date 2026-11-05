
package org.agmas.client.mixin;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
//? if >=1.21.11 {
/*import net.minecraft.util.EasingType;
*///?}
import net.minecraft.util.Mth;
import org.agmas.client.TiltedClient;
//? if < 1.21.2 {
import org.agmas.client.polyfill.PF_Mth;
//? }
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GameRenderer.class)
public abstract class OldCameraMixin {
	//? if <1.21.2 {
	@Inject(method = "getFov", at = @At("TAIL"), cancellable = true)
	private void changeFovWithADS(Camera camera, float partialTick, boolean useFovSetting, CallbackInfoReturnable<Double> cir) {
		double value = cir.getReturnValue();
		if (TiltedClient.adsTicks > 0) {
			if (TiltedClient.pressingADS) {
				cir.setReturnValue(Mth.lerp(PF_Mth.easeInOutSine(Math.clamp((TiltedClient.adsTicks+partialTick)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			} else {
				cir.setReturnValue(Mth.lerp(PF_Mth.easeInOutSine(Math.clamp((TiltedClient.adsTicks-partialTick)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			}
		}
	}
	//? } else if <1.21.11 {

	/*@Inject(method = "getFov", at = @At("TAIL"), cancellable = true)
	private void changeFovWithADS(Camera camera, float f, boolean bl, CallbackInfoReturnable<Float> cir) {
		float value = cir.getReturnValue();
		if (TiltedClient.adsTicks > 0) {
			if (TiltedClient.pressingADS) {
				cir.setReturnValue(Mth.lerp(Mth.easeInOutSine(Math.clamp((TiltedClient.adsTicks+f)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			} else {
				cir.setReturnValue(Mth.lerp(Mth.easeInOutSine(Math.clamp((TiltedClient.adsTicks-f)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
			}
		}
	}
	*///? } else if =1.21.11 {
    /*@Inject(method = "getFov", at = @At("TAIL"), cancellable = true)
    private void changeFovWithADS(Camera camera, float f, boolean bl, CallbackInfoReturnable<Float> cir) {
        float value = cir.getReturnValue();
        if (TiltedClient.adsTicks > 0) {
            if (TiltedClient.pressingADS) {
                cir.setReturnValue(Mth.lerp(EasingType.IN_OUT_SINE.apply(Math.clamp((TiltedClient.adsTicks+f)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
            } else {
                cir.setReturnValue(Mth.lerp(EasingType.IN_OUT_SINE.apply(Math.clamp((TiltedClient.adsTicks-f)/TiltedClient.timeToADS,0,1)), value, value*TiltedClient.adsZoom));
            }
        }
    }
    *///? }


}