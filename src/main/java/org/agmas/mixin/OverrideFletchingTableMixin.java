package org.agmas.mixin;

//? if >26.1
//import net.minecraft.references.BlockItemId;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.agmas.block.FletchingTableBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Blocks.class)
public abstract class OverrideFletchingTableMixin {

    @Mixin(MappedRegistry.class)
    public static class OverrideIntrusiveHolderMixin {
        @WrapMethod(method = "createIntrusiveHolder")
        private <T> Holder.Reference<T> registerFletchingTable(T object, Operation<Holder.Reference<T>> original) {
            if (object instanceof net.minecraft.world.level.block.FletchingTableBlock) {
                return null;
            }
            return original.call(object);
        }
    }
    //? if <1.21.2 {

    @WrapMethod(method = "register(Ljava/lang/String;Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/world/level/block/Block;")
    private static <T> Block registerFletchingTable(String string, Block block, Operation<Block> original) {
        // jank jank jank sahur... But this time, it's extra sahur. Because the 1.21.1 porter used AI to do this originally, which
        // means I have to rewrite it. Shame. At least they were honest about it so I could rewrite it!
        // Technically the AI's implementation was """simpler""" but this is more aligned with the rest of the versions.
        if (string.equals("fletching_table")) {
            return original.call(string,new FletchingTableBlock(block.properties()));
        }
        return original.call(string,block);
    }

    //? } else if <1.21.11 {

    /*@WrapMethod(method = "register(Lnet/minecraft/resources/ResourceKey;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    private static Block registerFletchingTable(ResourceKey<Block> resourceKey, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties, Operation<Block> original) {
        // jank jank jank sahur
        if (resourceKey.location().getPath().equals("fletching_table")) {
            return original.call(resourceKey, (Function<BlockBehaviour.Properties, Block>) FletchingTableBlock::new, properties);
        }
        return original.call(resourceKey, function,properties);
    }
    *///? } else if <=26.1 {
    /*@Shadow
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
    *///? } else {
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
