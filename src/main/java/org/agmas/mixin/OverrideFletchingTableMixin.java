package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//? if >26.1 {
/*import net.minecraft.references.BlockItemId;
*///? }
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

//? if =1.21.1 {
/*import net.minecraft.world.level.block.FletchingTableBlock;
*///? } else {
import org.agmas.block.FletchingTableBlock;
//? }
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.agmas.Tilted;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Blocks.class)
public abstract class OverrideFletchingTableMixin {
    //? if >= 1.21.2 {

    @Shadow
    public static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    //? }

    //? if <1.21.2 {
    /*// thank gpt my lord and savior for this (it's 2 in the morning as im writing so cut me some slack dawh)
    @WrapOperation(method = "<clinit>", at = @At(value = "NEW", target = "Lnet/minecraft/world/level/block/FletchingTableBlock;"))
    private static FletchingTableBlock replaceFletchingTable(BlockBehaviour.Properties properties, Operation<FletchingTableBlock> original) {
        return new org.agmas.block.FletchingTableBlock(properties);
    }
    *///? } else if <1.21.11 {

    /*@WrapMethod(method = "register(Lnet/minecraft/resources/ResourceKey;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block registerFletchingTable(ResourceKey<Block> resourceKey, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties, Operation<Block> original) {
        // jank jank jank sahur
        if (resourceKey.location().getPath().equals("fletching_table")) {
            return original.call(resourceKey, (Function<BlockBehaviour.Properties, Block>) FletchingTableBlock::new, properties);
        }
        return original.call(resourceKey, function,properties);
    }
    *///? } else if <=26.1 {
    
    @Shadow
    private static Block register(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }
    @WrapMethod(method = "register(Ljava/lang/String;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block registerFletchingTable(String id, BlockBehaviour.Properties properties, Operation<Block> original) {
        // jank jank jank sahur
        if (id.equals("fletching_table")) {
            return register(id, FletchingTableBlock::new, properties);
        }
        return original.call(id, properties);
    }
    //? } else {
    /*@WrapMethod(method = "register(Lnet/minecraft/references/BlockItemId;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block registerFletchingTable(BlockItemId id, BlockBehaviour.Properties properties, Operation<Block> original) {
        // jank jank jank sahur
        if (id.block().identifier().getPath().equals("fletching_table")) {
            return register(id.block(), FletchingTableBlock::new, properties);
        }
        return original.call(id, properties);
    }
    *///? }
}
