package org.agmas.mixin;

//? if >=26.3 {
/*import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.agmas.ModComponents;

import java.awt.*;
import java.util.function.Consumer;
*///? }
import java.util.Random;
import org.agmas.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;
import java.util.function.Function;

@Mixin(LootTable.class)
public abstract class TemporaryLootTableMixin {

    //? if >=26.3 {
    /*@Inject(method = "getRandomItemsRaw(Lnet/minecraft/world/level/storage/loot/LootContext;Ljava/polyfill/function/Consumer;)V", at = @At("HEAD"))
    public void addText(LootContext tableBuilder, Consumer<ItemStack> source, CallbackInfo ci) {
        if (new Random().nextInt(0, 500) <= 1) {
            source.accept(ModBlocks.CRATE.asItem().getDefaultInstance());
        }
    }
    *///? }


}
