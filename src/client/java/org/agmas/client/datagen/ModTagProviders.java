package org.agmas.client.datagen;

//? if >=26.1 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
//? } else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
*///? }
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
    public static final class ItemTags extends FabricTagsProvider.ItemTagsProvider {
    //?} else {
    /*public static final class ItemTags extends FabricTagProvider.ItemTagProvider {
    *///? }


        //? if >=26.1 {
        public ItemTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        //?} else {
        /*public ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        *///? }
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            add(Items.CROSSBOW, ModTags.CROSSBOWS);
            add(ModTags.CROSSBOWS, ModTags.AIMABLE);
            add(Items.TRIDENT, ModTags.AIMABLE);
            add(Items.BOW, ModTags.AIMABLE);
            add(Items.EGG, ModTags.AIMABLE);
            add(Items.ENDER_PEARL, ModTags.AIMABLE);
            add(Items.SNOWBALL, ModTags.AIMABLE);
            //? if >=26.4 {
            add(Items.ICE_BALL, ModTags.AIMABLE);
            //? }
        }

        public void add(TagKey<Item> item,TagKey<Item> tag) {
            //? if >=26.2 {
            tag(tag)
                    .addTag(item);
            //? } else if <1.21.2 {
            /*tag(tag).addTag(item);
             *///? } else {
            /*valueLookupBuilder(tag)
                    .addTag(item);
             *///? }
        }
        public void add(Item item,TagKey<Item> tag) {
            //? if >=26.2 {
            tag(tag)
                    .add(ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item)));
            //? } else if <1.21.2 {
            /*tag(tag).add(ResourceKey.create(Registries.ITEM, BuiltInRegistries.ITEM.getKey(item)));
            *///? } else {
            /*valueLookupBuilder(tag)
                    .add(item);
             *///? }
        }

    }
}
