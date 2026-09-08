package org.agmas.client.datagen;

//? if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
*///? } else {
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
//? }
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.agmas.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModTagProviders {

    //? if >=26.1 {
    /*public static final class ItemTags extends FabricTagsProvider.ItemTagsProvider {
    *///?} else {
    public static final class ItemTags extends FabricTagProvider.ItemTagProvider {
    //? }


        //? if >=26.1 {
        /*public ItemTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        *///?} else {
        public ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        //? }
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            add(Items.CROSSBOW, ModTags.CROSSBOWS);
        }

        public void add(Item item,TagKey<Item> tag) {
            //? if >=26.2 {
            /*tag(tag)
                    .add(ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item)));
            *///? } else if <1.21.2 {
            /*tag(tag).add(ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item)));
            *///? } else {
            valueLookupBuilder(tag)
                    .add(item);
             //? }
        }

    }
}
