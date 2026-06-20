package org.agmas.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import org.agmas.ModComponents;
import org.agmas.ModMenuTypes;
import org.agmas.Tilted;
import org.agmas.client.screen.FletchingTableScreen;
import org.agmas.network.ServerboundADSPacket;
import org.agmas.network.ServerboundLeanPacket;
import org.lwjgl.glfw.GLFW;

public class TiltedClient implements ClientModInitializer {
	public static boolean crossbowFocusMode = false;
	public static boolean pressingADS = false;
	public static boolean wasPressingADS = false;
	public static boolean itsNotJoeverUntilItsJoever = false;
	public static int leaning = 0;
	public static int previousLeaning = 0;
	public static int adsTicks = 0;
	public static int timeToADS = 3;
	public static boolean scope = false;
	public static boolean transCrosshair = false;
	public static float adsZoom = 1;
	public static RenderStateDataKey<Integer> leaningStateDataKey = RenderStateDataKey.create(()->"leaning");
	public static RenderStateDataKey<Float> leaningAgeStateDataKey = RenderStateDataKey.create(()->"leaningAge");
	public static Vec3 previousLeanCamPos = null;
	public static KeyMapping leanLeft;
	public static KeyMapping leanRight;
	public static KeyMapping enableCrossbowFocusMode;

	@Override
	public void onInitializeClient() {
		bootstrapKeys();
		bootstrapEvents();

		MenuScreens.register(ModMenuTypes.FLETCHING_TABLE, FletchingTableScreen::new);
	}

	public static void bootstrapKeys() {
		KeyMapping.Category CATEGORY = KeyMapping.Category.register(
				Tilted.of("tilted")
		);
		enableCrossbowFocusMode = KeyMappingHelper.registerKeyMapping(
				new KeyMapping(
						"key.tilted.crossbowFocusMode", // The translation key for the key mapping.
						InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
						GLFW.GLFW_KEY_J, // The GLFW keycode of the key.
						CATEGORY // The category of the mapping.
				));
		leanLeft = KeyMappingHelper.registerKeyMapping(
				new KeyMapping(
						"key.tilted.leanLeft", // The translation key for the key mapping.
						InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
						GLFW.GLFW_KEY_E, // The GLFW keycode of the key.
						CATEGORY // The category of the mapping.
				));
		leanRight = KeyMappingHelper.registerKeyMapping(
				new KeyMapping(
						"key.tilted.leanRight", // The translation key for the key mapping.
						InputConstants.Type.KEYSYM, // // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
						GLFW.GLFW_KEY_Q, // The GLFW keycode of the key.
						CATEGORY // The category of the mapping.
				));
	}

	public static void bootstrapEvents() {
		ClientTickEvents.START_CLIENT_TICK.register((minecraft)->{
			if (previousLeaning != leaning) {
				ClientPlayNetworking.send(new ServerboundLeanPacket(leaning));
			}
			if (wasPressingADS != pressingADS) {
				ClientPlayNetworking.send(new ServerboundADSPacket(pressingADS));
			}
			if (pressingADS) {
				adsTicks++;
			} else {
				adsTicks--;
			}
			if (minecraft.player != null) {
				timeToADS = 5;
				adsZoom = 0.9f;
				changeADStime(minecraft.player, EquipmentSlot.OFFHAND);
				changeADStime(minecraft.player, EquipmentSlot.MAINHAND);
			}
			adsTicks = Math.clamp(adsTicks,0,timeToADS);
			previousLeaning = leaning;
			wasPressingADS = pressingADS;
		});
		ClientTickEvents.END_CLIENT_TICK.register((minecraft)->{
			while (enableCrossbowFocusMode.consumeClick()) {
				crossbowFocusMode = !crossbowFocusMode;
			}
		});
	}

	public static void changeADStime(Player player, EquipmentSlot hand) {
		if (player.getItemBySlot(hand).is(Items.CROSSBOW)) {
			if (!player.getItemBySlot(hand).has(ModComponents.SCOPE_COMPONENT)) {
				timeToADS = 5;
				adsZoom = 0.9f;
				scope = false;
				transCrosshair = false;
			} else {
				timeToADS = ModComponents.scope(player.getItemBySlot(hand).get(ModComponents.SCOPE_COMPONENT)).ticksToADS;
				adsZoom = ModComponents.scope(player.getItemBySlot(hand).get(ModComponents.SCOPE_COMPONENT)).zoom;
				scope = ModComponents.scope(player.getItemBySlot(hand).get(ModComponents.SCOPE_COMPONENT)).impairedVision;
				transCrosshair = ModComponents.scope(player.getItemBySlot(hand).get(ModComponents.SCOPE_COMPONENT)).enhancedCrosshair;
			}
		}
	}

}