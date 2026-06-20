package org.agmas.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;


public class NotFromBlockDropCondition
        implements LootItemCondition {
    private static final NotFromBlockDropCondition INSTANCE = new NotFromBlockDropCondition();
    public static final MapCodec<NotFromBlockDropCondition> MAP_CODEC = MapCodec.unit(INSTANCE);

    private NotFromBlockDropCondition() {
    }

    public MapCodec<NotFromBlockDropCondition> codec() {
        return MAP_CODEC;
    }

    @Override
    public Set<ContextKey<?>> getReferencedContextParams() {
        return Set.of(LootContextParams.BLOCK_ENTITY,LootContextParams.DAMAGE_SOURCE);
    }

    @Override
    public boolean test(LootContext context) {
        return context.hasParameter(LootContextParams.BLOCK_ENTITY) || context.hasParameter(LootContextParams.DAMAGE_SOURCE);
    }

    public static LootItemCondition.Builder notFromBlockDrop() {
        return () -> INSTANCE;
    }
}

