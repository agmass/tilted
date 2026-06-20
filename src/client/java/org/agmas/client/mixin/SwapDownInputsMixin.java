

package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import org.agmas.Tilted;
import org.agmas.client.TiltedClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = KeyMapping.class)
public abstract class SwapDownInputsMixin {

	@Shadow
	protected InputConstants.Key key;

	@Shadow
	private int clickCount;

	@WrapMethod(method = "consumeClick")
	public boolean dontRunIfSameAsLeanKey(Operation<Boolean> original) {
		if (TiltedClient.crossbowFocusMode) {
			if (Minecraft.getInstance().player != null) {
				if (Minecraft.getInstance().player.isHolding(Items.CROSSBOW)) {
					if (!((KeyMapping) (Object) this).equals(TiltedClient.leanLeft) && !((KeyMapping) (Object) this).equals(TiltedClient.leanRight)) {
						if (TiltedClient.leanRight.same(((KeyMapping) (Object) this)) || TiltedClient.leanLeft.same(((KeyMapping) (Object) this))) {
							clickCount = 0;
							return false;
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
			if (Minecraft.getInstance().player.isHolding(Items.CROSSBOW)) {
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
			if (Minecraft.getInstance().player.isHolding(Items.CROSSBOW)) {
				TiltedClient.itsNotJoeverUntilItsJoever = true;
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyUse)) return Minecraft.getInstance().options.keyAttack.isDown();
				if (((KeyMapping)(Object)this).equals(Minecraft.getInstance().options.keyAttack)) return Minecraft.getInstance().options.keyUse.isDown();
			}
		}
		TiltedClient.itsNotJoeverUntilItsJoever = false;
		return orig;
	}
}