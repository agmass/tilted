package org.agmas.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.agmas.block.FletchingTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Function;

@Mixin(Blocks.class)
public abstract class OverrideFletchingTableMixin {


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

}
