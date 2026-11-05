

package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.Tilt;
import org.agmas.ModTags;
import org.agmas.client.TiltedClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeyMapping.class)
public abstract class SwapDownInputsMixin {

	@Shadow
	protected InputConstants.Key key;

	@Shadow
	private int clickCount;

	//? if <1.21.9 {

	@Shadow
	public abstract void setDown(boolean down);

	@Inject(method = "click", at = @At("TAIL"))
	private static void allowDuplicateLeanKeys(InputConstants.Key key, CallbackInfo ci, @Local KeyMapping keyMapping) {
		if (keyMapping == null) return;
		for (KeyMapping keyBinding2 : Minecraft.getInstance().options.keyMappings) {
			if (keyBinding2 == TiltedClient.leanLeft || keyBinding2 == TiltedClient.leanRight) {
				if (keyMapping != keyBinding2 && keyMapping.same(keyBinding2)) {
					((SwapDownInputsMixin) (Object) keyBinding2).clickCount++;
				}
			}
		}
	}

	@Inject(method = "set", at = @At("TAIL"))
	private static void allowDuplicateLeanKeys(InputConstants.Key key, boolean pressed, CallbackInfo ci, @Local KeyMapping keyMapping) {
		if (keyMapping == null) return;
		for (KeyMapping keyBinding2 : Minecraft.getInstance().options.keyMappings) {
			if (keyBinding2 == TiltedClient.leanLeft || keyBinding2 == TiltedClient.leanRight) {
				if (keyMapping != keyBinding2 && keyMapping.same(keyBinding2)) {
					((SwapDownInputsMixin) (Object) keyBinding2).setDown(true);
				}
			}
		}
	}
	//? }
	@WrapMethod(method = "consumeClick")
	public boolean dontRunIfSameAsLeanKey(Operation<Boolean> original) {
		if (TiltedClient.crossbowFocusMode) {
			if (!TiltedClient.itsNotJoeverUntilItsJoever) {
				if (Minecraft.getInstance().player != null) {
					if (Minecraft.getInstance().player.isHolding((i)->i.is(ModTags.CROSSBOWS))) {
						if (((KeyMapping) (Object) this) != TiltedClient.leanLeft && ((KeyMapping) (Object) this) != TiltedClient.leanRight) {
							if (TiltedClient.leanRight.same(((KeyMapping) (Object) this)) || TiltedClient.leanLeft.same(((KeyMapping) (Object) this))) {
								clickCount = 0;
								return false;
							}
						}
					}
				}
			}
		}
		boolean orig = original.call();
		if (TiltedClient.itsNotJoeverUntilItsJoever) {
			TiltedClient.itsNotJoeverUntilItsJoever = false;
			return orig;
		}
		if (TiltedClient.crossbowFocusMode) {
			if (Minecraft.getInstance().player == null) return orig;
			if (Minecraft.getInstance().player.isHolding((i)->i.is(ModTags.CROSSBOWS))) {
				TiltedClient.itsNotJoeverUntilItsJoever = true;
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyUse)) return Minecraft.getInstance().options.keyAttack.consumeClick();
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyAttack)) return Minecraft.getInstance().options.keyUse.consumeClick();
			}
		}
		TiltedClient.itsNotJoeverUntilItsJoever = false;
		return orig;
	}
	@WrapMethod(method = "isDown")
	public boolean runLeansFirst(Operation<Boolean> original) {
		boolean orig = original.call();
		if (TiltedClient.itsNotJoeverUntilItsJoever) {
			TiltedClient.itsNotJoeverUntilItsJoever = false;
			return orig;
		}
		if (TiltedClient.crossbowFocusMode) {
			if (Minecraft.getInstance().player == null) return orig;
			if (Minecraft.getInstance().player.isHolding((i)->i.is(ModTags.CROSSBOWS))) {
				TiltedClient.itsNotJoeverUntilItsJoever = true;
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyUse)) return Minecraft.getInstance().options.keyAttack.isDown();
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyAttack)) return Minecraft.getInstance().options.keyUse.isDown();
			}
		}
		TiltedClient.itsNotJoeverUntilItsJoever = false;
		return orig;
	}
}