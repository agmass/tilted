package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.EasingType;
import net.minecraft.util.Mth;
import org.agmas.Tilted;
import org.agmas.client.TiltedClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(value = Gui.class, priority = 20)
public class GreenCrosshairMixin {
	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V", ordinal = 0), method = "extractCrosshair")
	private void init(GuiGraphicsExtractor instance, RenderPipeline renderPipeline, Identifier location, int x, int y, int width, int height, Operation<Void> original) {
		if (TiltedClient.scope && TiltedClient.adsTicks > 3) {
			return;
		}
		if (TiltedClient.crossbowFocusMode) {
			if (TiltedClient.transCrosshair) {
				if (!TiltedClient.pressingADS)
					instance.blitSprite(renderPipeline, location, x, y, width, height, new Color(255,0,0,25).getRGB());
			} else {
				instance.blitSprite(renderPipeline, location, x, y, width, height, Color.GREEN.getRGB());
			}
		} else {
			original.call(instance,renderPipeline,location,x,y,width,height);
		}

	}
	@Inject(at = @At("HEAD"), method = "extractCameraOverlays")
	private void scope(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
		if (TiltedClient.scope && TiltedClient.adsTicks > 3) {
			float srcWidth = (float)Math.min(graphics.guiWidth(), graphics.guiHeight());
			float ticks = TiltedClient.adsTicks;
			ticks += deltaTracker.getGameTimeDeltaPartialTick(true) * (TiltedClient.pressingADS ? 1 : -1);
			float ratio = Math.min((float)graphics.guiWidth() / srcWidth, (float)graphics.guiHeight() / srcWidth) * EasingType.IN_OUT_SINE.apply(Math.clamp((ticks)/TiltedClient.timeToADS,0,1));
			int width = Mth.floor(srcWidth * ratio);
			int height = Mth.floor(srcWidth * ratio);
			int left = (graphics.guiWidth() - width) / 2;
			int top = (graphics.guiHeight() - height) / 2;
			int right = left + width;
			int bottom = top + height;
			graphics.blit(RenderPipelines.GUI_TEXTURED, Tilted.of("textures/misc/telescopic_scope.png"), left, top, 0.0F, 0.0F, width, height, width, height);
			graphics.fill(RenderPipelines.GUI, 0, bottom, graphics.guiWidth(), graphics.guiHeight(), Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, 0, 0, graphics.guiWidth(), top, Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, 0, top, left, bottom, Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, right, top, graphics.guiWidth(), bottom, Color.BLACK.getRGB());

		}
	}
}