package org.agmas;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.resources.Identifier;
import org.agmas.network.ServerboundADSPacket;
import org.agmas.network.ServerboundLeanPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tilted implements ModInitializer {
	public static final String MOD_ID = "tilted";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier of(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID,path);
	}
	@Override
	public void onInitialize() {
		ModAttachments.init();
		ModComponents.init();
		ModMenuTypes.init();
		ModItems.init();

		LOGGER.info("I HATE https://modrinth.com/user/Elysieon!!! IF YOU SEE THIS MESSAGE MAKE SURE TO SEND MALICE AND DESPAIR TO https://www.youtube.com/@Elysieon!!! And you too powercyphe");

		PayloadTypeRegistry.serverboundPlay().register(ServerboundLeanPacket.TYPE, ServerboundLeanPacket.CODEC);
		PayloadTypeRegistry.serverboundPlay().register(ServerboundADSPacket.TYPE, ServerboundADSPacket.CODEC);

		ServerPlayNetworking.registerGlobalReceiver(ServerboundLeanPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.LEANING_DIRECTION, payload.leaning());
		}));
		ServerPlayNetworking.registerGlobalReceiver(ServerboundADSPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.IS_AIMING, payload.isAdsing());
		}));
	}
}