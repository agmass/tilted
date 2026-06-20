

package org.agmas.client.mixin;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.agmas.ModAttachments;
import org.agmas.client.TiltedClient;
import org.agmas.client.duck.AvatarAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Avatar.class)
public abstract class AvatarMixin implements AvatarAccessor {
	@Unique
	public float startedLeaningAge = 0;
	@Unique
	public int previousLeaning = 0;

	@Unique
	public void setStartedLeaningAge(float age) {
		this.startedLeaningAge = age;
	}
	@Unique
	public float getStartedLeaningAge() {
		return startedLeaningAge;
	}

	@Unique
	public void setPreviousLeaning(int previousLeaning) {
		this.previousLeaning = previousLeaning;
	}
	@Unique
	public int getPreviousLeaning() {
		return previousLeaning;
	}
}