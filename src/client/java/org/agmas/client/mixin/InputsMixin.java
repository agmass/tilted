

package org.agmas.client.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Items;
import org.agmas.Tilted;
import org.agmas.client.TiltedClient;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Minecraft.class)
public abstract class InputsMixin {

	@Shadow
	@Nullable
	public LocalPlayer player;

	@Shadow
	@Final
	public Options options;

	@Shadow
	protected abstract void startUseItem();

	@Shadow
	protected abstract void continueAttack(boolean down);

	@Shadow
	@Nullable
	public Screen screen;

	@WrapMethod(method = "startAttack")
	public boolean noAttack2(Operation<Boolean> original) {
		if (TiltedClient.pressingADS) return false;
		return original.call();
	}
	@WrapMethod(method = "continueAttack")
	public void noAttack(boolean down, Operation<Void> original) {
		if (TiltedClient.pressingADS) {
			original.call(false);
			return;
		}
		original.call(down);
	}
	@WrapMethod(method = "handleKeybinds")
	public void runLeansFirst(Operation<Void> original) {
		if (TiltedClient.crossbowFocusMode) {
			if (player == null) return;
			if (player.isHolding(Items.CROSSBOW)) {
				while (TiltedClient.leanLeft.consumeClick()) {
					TiltedClient.leaning = (TiltedClient.leaning == -1) ? 0 : -1;
				}
				while (TiltedClient.leanRight.consumeClick()) {
					TiltedClient.leaning = (TiltedClient.leaning == 1) ? 0 : 1;
				}

				TiltedClient.pressingADS = options.keyAttack.isDown(); // left and right is swapped

				while (options.keyAttack.consumeClick()) {
				}

				while (options.keyUse.consumeClick()) {
					if (TiltedClient.adsTicks == 0 || TiltedClient.adsTicks == TiltedClient.timeToADS) {
						startUseItem();
					}
				}

			} else {
				TiltedClient.leaning = 0;
				TiltedClient.pressingADS = false;
			}
		} else {
			TiltedClient.leaning = 0;
			TiltedClient.pressingADS = false;
		}
		original.call();

	}
}