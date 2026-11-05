package org.agmas;

//? if >=26.1 {
/*import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
*///? } else {
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//? }

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.agmas.block.CrateBlock;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CRATE = register(
            "crate",
            CrateBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS),
            true
    );

    public static void init() {
        //? if >=26.1 {
        /*CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
         *///? } else {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
        //? }
            .register((tab) -> {
                tab.accept(CRATE.asItem());
            });
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);

        //? if >=1.21.2 {
        /*Block block = blockFactory.apply(properties.setId(blockKey));
        *///? } else {
        Block block = blockFactory.apply(properties);
        //? }

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            //? if >=1.21.2 {
            /*BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            *///? } else {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            //? }

            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Tilted.of(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Tilted.of(name));
    }
}
