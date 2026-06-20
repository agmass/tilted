package org.agmas.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.agmas.ModBlocks;
import org.agmas.ModItems;

import java.util.concurrent.CompletableFuture;

public class TiltedLangProvider extends FabricLanguageProvider {
    public TiltedLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ICE_SMITHING_TEMPLATE, "Ice Crossbow Smithing Template");
        translationBuilder.add(ModItems.CARNIVORA_SMITHING_TEMPLATE, "Carnivora Crossbow Smithing Template");
        translationBuilder.add(ModItems.CARRION_SMITHING_TEMPLATE, "Carrion Crossbow Smithing Template");
        translationBuilder.add(ModItems.GOLDENEYE_SMITHING_TEMPLATE, "Golden-Eye Crossbow Smithing Template");
        translationBuilder.add(ModItems.GUI_SMITHING_TEMPLATE, "GUI Crossbow Smithing Template");
        translationBuilder.add(ModItems.HISTORY_SMITHING_TEMPLATE, "History Crossbow Smithing Template");
        translationBuilder.add(ModItems.HOLIDAY_SMITHING_TEMPLATE, "Holiday Crossbow Smithing Template");
        translationBuilder.add(ModItems.HYPERDEATH_SMITHING_TEMPLATE, "Hyperdeath Crossbow Smithing Template");
        translationBuilder.add(ModItems.JUNKYARD_SMITHING_TEMPLATE, "Junkyard Crossbow Smithing Template");
        translationBuilder.add(ModItems.MINED_SMITHING_TEMPLATE, "Mined Crossbow Smithing Template");
        translationBuilder.add(ModItems.MONEYTALKS_SMITHING_TEMPLATE, "Money Talks Crossbow Smithing Template");
        translationBuilder.add(ModItems.NOSTALGIA_SMITHING_TEMPLATE, "Nostalgia Crossbow Smithing Template");
        translationBuilder.add(ModItems.NROSES_SMITHING_TEMPLATE, "N'Roses Crossbow Smithing Template");
        translationBuilder.add(ModItems.REVENANT_SMITHING_TEMPLATE, "Revenant Crossbow Smithing Template");
        translationBuilder.add(ModItems.RIPPER_SMITHING_TEMPLATE, "Ripper Crossbow Smithing Template");
        translationBuilder.add(ModItems.RUNESCAPE_SMITHING_TEMPLATE, "Runescape Crossbow Smithing Template");
        translationBuilder.add(ModItems.SENTINAL_SMITHING_TEMPLATE, "Sentinal Crossbow Smithing Template");
        translationBuilder.add(ModItems.SHIPPED_SMITHING_TEMPLATE, "Shipped Crossbow Smithing Template");
        translationBuilder.add(ModItems.SHRIMP_SMITHING_TEMPLATE, "Shrimp Crossbow Smithing Template");
        translationBuilder.add(ModItems.SPECIALOPS_SMITHING_TEMPLATE, "Special Ops Crossbow Smithing Template");
        translationBuilder.add(ModItems.VIRTUE_SMITHING_TEMPLATE, "Virtue Crossbow Smithing Template");

        translationBuilder.add(ModItems.FLAMBE_SMITHING_TEMPLATE, "Flambe Crossbow Smithing Template");
        translationBuilder.add(ModItems.TEMPERED_SMITHING_TEMPLATE, "Tempered Ops Crossbow Smithing Template");
        translationBuilder.add(ModItems.TRAINING_SMITHING_TEMPLATE, "Training Crossbow Smithing Template");

        translationBuilder.add(ModBlocks.CRATE, "Skin Crate");
    }
}