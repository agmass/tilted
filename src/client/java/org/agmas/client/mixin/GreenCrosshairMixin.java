package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
//? if <26.3 {
import com.mojang.blaze3d.pipeline.RenderPipeline;
//? } else {
/*import com.mojang.renderpearl.api.pipeline.RenderPipeline;
*///? }
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
//? if <26.1 {
import net.minecraft.client.gui.GuiGraphics;
//? } else {
/*import net.minecraft.client.gui.GuiGraphicsExtractor;
*///? }
//? if <1.21.11 {
/*import net.minecraft.resources.ResourceLocation;
 *///? }
//? if >26.1 {
/*import net.minecraft.client.gui.Hud;
*///? }
//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
import net.minecraft.util.EasingType;
//? }
//? if >= 1.21.6 {
import net.minecraft.client.renderer.RenderPipelines;
//? }
import net.minecraft.util.Mth;
import org.agmas.Tilted;
import org.agmas.client.TiltedClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//? if <1.21.2 {
/*import org.agmas.client.polyfill.PF_Mth;
*///? }
import java.awt.*;

//? if <=26.1 {
@Mixin(value = Gui.class, priority = 20)
//? } else {
/*@Mixin(value = Hud.class, priority = 20)
*///? }
public class GreenCrosshairMixin {
	//? if <1.21.2 {
	/*@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"), method = "renderCrosshair")
	private void init(GuiGraphics instance, ResourceLocation location, int x, int y, int width, int height, Operation<Void> original) {
		if (TiltedClient.scope && TiltedClient.adsTicks > 3) {
			return;
		}

		if (TiltedClient.crossbowFocusMode) {
			if (TiltedClient.transCrosshair) {
				if (!TiltedClient.pressingADS) {
					instance.setColor(1.0f, 0.0f, 0.0f, (float) 25 / (float) 255);
					original.call(instance, location, x, y, width, height);
					instance.setColor(1.0f, 1.0f, 1.0f, 1.0f);
				}
			} else {
				instance.setColor(0.0f, 1.0f, 0.0f, 1.0f);
				original.call(instance, location, x, y, width, height);
				instance.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			}
		} else {
			original.call(instance, location, x, y, width, height);
		}
	}
	*///? } else if <26.1 {
	//? if >=1.21.11 {
	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V", ordinal = 0), method = "renderCrosshair")
	private void init(GuiGraphics instance, RenderPipeline renderPipeline, Identifier location, int x, int y, int width, int height, Operation<Void> original) {
	//? } else {
	/*@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/ResourceLocation;IIII)V"), method = "renderCrosshair")
	private void init(GuiGraphics instance, RenderPipeline renderPipeline, ResourceLocation location, int x, int y, int width, int height, Operation<Void> original) {
	*///? }
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
	//? } else if <26.3 {
	/*@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V", ordinal = 0), method = "extractCrosshair")
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
	*///? } else {
	/*@WrapOperation(method = "extractCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blitSprite(Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V", ordinal = 0))
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
	*///? }

	//? if >=26.1 {
	/*@Inject(at = @At("HEAD"), method = "extractCameraOverlays")
	private void scope(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
	*///? } else {
	@Inject(at = @At("HEAD"), method = "renderCameraOverlays")
	private void scope(GuiGraphics graphics, DeltaTracker deltaTracker, CallbackInfo ci) {
	//? }
		if (TiltedClient.scope && TiltedClient.adsTicks > 3) {
			float srcWidth = (float)Math.min(graphics.guiWidth(), graphics.guiHeight());
			float ticks = TiltedClient.adsTicks;
			ticks += deltaTracker.getGameTimeDeltaPartialTick(true) * (TiltedClient.pressingADS ? 1 : -1);
			//? if >=1.21.11 {
			float ratio = Math.min((float)graphics.guiWidth() / srcWidth, (float)graphics.guiHeight() / srcWidth) * EasingType.IN_OUT_SINE.apply(Math.clamp((ticks)/TiltedClient.timeToADS,0,1));
			//? } else if <1.21.2 {
			/*float ratio = Math.min((float)graphics.guiWidth() / srcWidth, (float)graphics.guiHeight() / srcWidth) * PF_Mth.easeInOutSine(Math.clamp((ticks)/TiltedClient.timeToADS,0,1));
			*///? } else {
			/*float ratio = Math.min((float)graphics.guiWidth() / srcWidth, (float)graphics.guiHeight() / srcWidth) * Mth.easeInOutSine(Math.clamp((ticks)/TiltedClient.timeToADS,0,1));
			*///? }
			int width = Mth.floor(srcWidth * ratio);
			int height = Mth.floor(srcWidth * ratio);
			int left = (graphics.guiWidth() - width) / 2;
			int top = (graphics.guiHeight() - height) / 2;
			int right = left + width;
			int bottom = top + height;

			//? if >= 1.21.6 {
			graphics.blit(RenderPipelines.GUI_TEXTURED, Tilted.of("textures/misc/telescopic_scope.png"), left, top, 0.0F, 0.0F, width, height, width, height);
			graphics.fill(RenderPipelines.GUI, 0, bottom, graphics.guiWidth(), graphics.guiHeight(), Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, 0, 0, graphics.guiWidth(), top, Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, 0, top, left, bottom, Color.BLACK.getRGB());
			graphics.fill(RenderPipelines.GUI, right, top, graphics.guiWidth(), bottom, Color.BLACK.getRGB());
			//? } else {
			/*RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			graphics.blit(Tilted.of("textures/misc/telescopic_scope.png"), left, top, 0.0f, 0.0f, width, height, width, height);

			RenderSystem.disableBlend();

			graphics.fill(0, bottom, graphics.guiWidth(), graphics.guiHeight(), Color.BLACK.getRGB());
			graphics.fill(0, 0, graphics.guiWidth(), top, Color.BLACK.getRGB());
			graphics.fill(0, top, left, bottom, Color.BLACK.getRGB());
			graphics.fill(right, top, graphics.guiWidth(), bottom, Color.BLACK.getRGB());
			*///? }
		}
	}
}