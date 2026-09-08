package org.agmas;

import net.fabricmc.api.ModInitializer;

//? if <1.21.6 {
/*import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
*///? }

//? if <26.3 {
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
//? }
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//? if >=1.21.11 {
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.agmas.network.ServerboundADSPacket;
import org.agmas.network.ServerboundLeanPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tilted implements ModInitializer {
	public static final String MOD_ID = "tilted";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//? if >=1.21.11 {
	public static Identifier of(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID,path);
	}
	public static Identifier ofVannila(String path) {
		return Identifier.fromNamespaceAndPath("minecraft",path);
	}
	//? } else {
	/*public static ResourceLocation of(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID,path);
	}
	public static ResourceLocation ofVannila(String path) {
		return ResourceLocation.fromNamespaceAndPath("minecraft",path);
	}
	*///? }

	public static List<ResourceKey<LootTable>> TRIAL_CHAMBER_TABLES = new ArrayList<>();

	@Override
	public void onInitialize() {
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_ENTRANCE);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR_DISPENSER);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_CORRIDOR_POT);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_COMMON);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE);
		TRIAL_CHAMBER_TABLES.add(BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_COMMON);

		ModAttachments.init();
		ModComponents.init();
		ModMenuTypes.init();
		ModItems.init();
		ModBlocks.init();
		ModTags.init();

		// damm why tho
		LOGGER.info("I HATE https://modrinth.com/user/Elysieon!!! IF YOU SEE THIS MESSAGE MAKE SURE TO SEND MALICE AND DESPAIR TO https://www.youtube.com/@Elysieon!!! And you too powercyphe");

		//? if >=26.1 {
		/*PayloadTypeRegistry.serverboundPlay().register(ServerboundLeanPacket.TYPE, ServerboundLeanPacket.CODEC);
		PayloadTypeRegistry.serverboundPlay().register(ServerboundADSPacket.TYPE, ServerboundADSPacket.CODEC);
		*///? } else {
		PayloadTypeRegistry.playC2S().register(ServerboundLeanPacket.TYPE, ServerboundLeanPacket.CODEC);
		PayloadTypeRegistry.playC2S().register(ServerboundADSPacket.TYPE, ServerboundADSPacket.CODEC);

		//? }

		ServerPlayNetworking.registerGlobalReceiver(ServerboundLeanPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.LEANING_DIRECTION, payload.leaning());
		}));
		ServerPlayNetworking.registerGlobalReceiver(ServerboundADSPacket.TYPE, ((payload, context) -> {
			context.player().setAttached(ModAttachments.IS_AIMING, payload.isAdsing());
		}));

		//? if <1.21.6 {
		/*LootTableEvents.MODIFY.register(((key, tableBuilder, source, provider) -> {
			if (provider.lookup(key.registryKey()).isPresent()) {
				tableBuilder.withPool(
					LootPool.lootPool()
						.add(LootItem.lootTableItem(ModBlocks.CRATE.asItem()))
						.when(LootItemRandomChanceCondition.randomChance(0.4f /^ (0-1) 2 out of 5 (0-4) ^/))
				);
			}
		}));
		*///? } else if <26.3 {
		LootTableEvents.MODIFY_DROPS.register(((key, tableBuilder, source) -> {
			if (key.unwrapKey().isPresent()) {
				if (TRIAL_CHAMBER_TABLES.contains(key.unwrapKey().get())) {
					if (new Random().nextInt(0, 5) <= 1) {
						source.add(ModBlocks.CRATE.asItem().getDefaultInstance());
					}
				}
			}
		}));
		//? }
	}
}