package org.agmas.client.datagen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.concurrent.CompletableFuture;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;

//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.minecraft.data.recipes.RecipeOutput;

//? if >=1.21.2 {
import net.minecraft.data.recipes.RecipeProvider;
//? }

//? if >=26.1 {
/*import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
*///? } else {
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
//? }

import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import org.agmas.Tilted;
import org.agmas.ModItems;

import org.agmas.attachments.SkinsComponent;

public class TiltedRecipeProvider extends FabricRecipeProvider {
    private final static String PATH_DIR_RECIPES = "../../src/main/resources/data/tilted/recipe";

    //? if >=26.1 {
    /*public TiltedRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    *///? } else {
    public TiltedRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    //? }
        super(output, registriesFuture);
    }

    //? if >=1.21.2 {

     @Override

    //? if >=26.3 {

    /*public RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {

    *///? } else {

    public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {

    //? }

    //? }

    //? if >=1.21.2 {
    @Override
    public void buildRecipes() {
    //? } else {
    /*@Override
    public void buildRecipes(RecipeOutput exporter) {
    *///? }
        boolean mkdirRecipesSuccessful = new File(PATH_DIR_RECIPES).mkdirs();

        if (mkdirRecipesSuccessful) Tilted.LOGGER.info("successfully created recipe folder at <" + PATH_DIR_RECIPES + ">");
        else Tilted.LOGGER.error("cannot create recipe folder at <" + PATH_DIR_RECIPES + ">");

        writeCrossbowSmithingRecipes(SkinsComponent.                   ANCIENT, ModItems.                   ANCIENT_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 ANTIVIRUS, ModItems.                 ANTIVIRUS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  AQUARIUS, ModItems.                  AQUARIUS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  ARMOURED, ModItems.                  ARMOURED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  AWAKENED, ModItems.                  AWAKENED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  BUSINESS, ModItems.                  BUSINESS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 CARNIVORA, ModItems.                 CARNIVORA_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   CARRION, ModItems.                   CARRION_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 CELESTIAL, ModItems.                 CELESTIAL_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    CHERRY, ModItems.                    CHERRY_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                      CHUD, ModItems.                      CHUD_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 CLOCKWORK, ModItems.                 CLOCKWORK_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.               COTTONCANDY, ModItems.               COTTONCANDY_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   DARKSUN, ModItems.                   DARKSUN_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    FLAMBE, ModItems.                    FLAMBE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    FLOWER, ModItems.                    FLOWER_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    FRIEND, ModItems.                    FRIEND_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  GODHOLMS, ModItems.                  GODHOLMS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 GOLDENEYE, ModItems.                 GOLDENEYE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                       GUI, ModItems.                       GUI_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    HAMMER, ModItems.                    HAMMER_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.               HEARTSTRING, ModItems.               HEARTSTRING_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   HISTORY, ModItems.                   HISTORY_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   HOLIDAY, ModItems.                   HOLIDAY_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                HYPERDEATH, ModItems.                HYPERDEATH_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  INVERTED, ModItems.                  INVERTED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  JUNKYARD, ModItems.                  JUNKYARD_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                     KEBAB, ModItems.                     KEBAB_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.LEGALLY_DISTINCT_BRIMSTONE, ModItems.LEGALLY_DISTINCT_BRIMSTONE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   MALWARE, ModItems.                   MALWARE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                     MINED, ModItems.                     MINED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.           MISSING_TEXTURE, ModItems.           MISSING_TEXTURE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                MONEYTALKS, ModItems.                MONEYTALKS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  NAUTICAL, ModItems.                  NAUTICAL_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 NOSTALGIA, ModItems.                 NOSTALGIA_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    NROSES, ModItems.                    NROSES_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                      PALE, ModItems.                      PALE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                       PVP, ModItems.                       PVP_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  REVENANT, ModItems.                  REVENANT_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    RIPPER, ModItems.                    RIPPER_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                      ROAR, ModItems.                      ROAR_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 RUNESCAPE, ModItems.                 RUNESCAPE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  SENTINAL, ModItems.                  SENTINAL_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   SHIPPED, ModItems.                   SHIPPED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    SHRIMP, ModItems.                    SHRIMP_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   SOLARIS, ModItems.                   SOLARIS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                SPECIALOPS, ModItems.                SPECIALOPS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                     SPLIT, ModItems.                     SPLIT_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 STOPWATCH, ModItems.                 STOPWATCH_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 SULFUROUS, ModItems.                 SULFUROUS_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    SUNSET, ModItems.                    SUNSET_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  TEMPERED, ModItems.                  TEMPERED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   THORNED, ModItems.                   THORNED_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                      TIDE, ModItems.                      TIDE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   TOTEMIC, ModItems.                   TOTEMIC_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                  TRAINING, ModItems.                  TRAINING_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    VIRTUE, ModItems.                    VIRTUE_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                   WARLOCK, ModItems.                   WARLOCK_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                WILDFLOWER, ModItems.                WILDFLOWER_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                 WILLPOWER, ModItems.                 WILLPOWER_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                     WRATH, ModItems.                     WRATH_SMITHING_TEMPLATE, Items.        STRING);
        writeCrossbowSmithingRecipes(SkinsComponent.                    WRITER, ModItems.                    WRITER_SMITHING_TEMPLATE, Items.        STRING);

        //? if >= 26.3 {

        /*writeCrossbowSmithingRecipes(SkinsComponent.                  BLACKICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.    black());
        writeCrossbowSmithingRecipes(SkinsComponent.                   BLUEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.     blue());
        writeCrossbowSmithingRecipes(SkinsComponent.                   CYANICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.     cyan());
        writeCrossbowSmithingRecipes(SkinsComponent.                  GREENICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.    green());
        writeCrossbowSmithingRecipes(SkinsComponent.              LIGHTBLUEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.lightBlue());
        writeCrossbowSmithingRecipes(SkinsComponent.                   LIMEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.     lime());
        writeCrossbowSmithingRecipes(SkinsComponent.                MAGENTAICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.  magenta());
        writeCrossbowSmithingRecipes(SkinsComponent.                 ORANGEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.   orange());
        writeCrossbowSmithingRecipes(SkinsComponent.                   PINKICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.     pink());
        writeCrossbowSmithingRecipes(SkinsComponent.                 PURPLEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.   purple());
        writeCrossbowSmithingRecipes(SkinsComponent.                    REDICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.      red());
        writeCrossbowSmithingRecipes(SkinsComponent.                       ICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.    white());
        writeCrossbowSmithingRecipes(SkinsComponent.                 YELLOWICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.DYE.   yellow());

        *///? } else {

        writeCrossbowSmithingRecipes(SkinsComponent.                  BLACKICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.     BLACK_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                   BLUEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.      BLUE_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                   CYANICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.      CYAN_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                  GREENICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.     GREEN_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.              LIGHTBLUEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.LIGHT_BLUE_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                   LIMEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.      LIME_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                MAGENTAICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.   MAGENTA_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                 ORANGEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.    ORANGE_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                   PINKICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.      PINK_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                 PURPLEICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.    PURPLE_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                    REDICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.       RED_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                       ICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.     WHITE_DYE);
        writeCrossbowSmithingRecipes(SkinsComponent.                 YELLOWICE, ModItems.                       ICE_SMITHING_TEMPLATE, Items.    YELLOW_DYE);

        //? }
    }

    private void writeCrossbowSmithingRecipes(SkinsComponent skin, Item template, Item addition) {
        //? if >=1.21.11 {
        Identifier templateLoc = BuiltInRegistries.ITEM.getKey(template);
        Identifier additionLoc = BuiltInRegistries.ITEM.getKey(addition);
        //? } else {
        /*ResourceLocation templateLoc = BuiltInRegistries.ITEM.getKey(template);
        ResourceLocation additionLoc = BuiltInRegistries.ITEM.getKey(addition);
        *///? }

        int skinEnum = skin.ordinal();
        String skinName = skin.name();

        String templatePath = templateLoc.toString();
        String additionPath = additionLoc.toString();

        try (FileWriter writer = new FileWriter(PATH_DIR_RECIPES + "/" + skinName.toLowerCase() + "_smithing_recipe.json")) {
            writer.write(
                //? if >= 1.21.4 {
                """
                {
                    "type": "minecraft:smithing_transform",
            
                    "template": "%s",
                    "base": "minecraft:crossbow",
                    "addition": "%s",
            
                    "result": { "id": "minecraft:crossbow", "components": { "tilted:skin": %d } }
                }
                """
                //? } else {
                /*"""
                {
                    "type": "minecraft:smithing_transform",
            
                    "template": { "item": "%s" },
                    "base": { "item": "minecraft:crossbow" },
                    "addition": { "item": "%s" },
            
                    "result": { "id": "minecraft:crossbow", "components": { "tilted:skin": %d } }
                }
                """
                *///? }
            .formatted(templatePath, additionPath, skinEnum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

            //? if >=1.21.2 {
        };
    }
    //? }

    @Override
    public @NotNull String getName() {
        return "TiltedRecipeProvider";
    }
}
