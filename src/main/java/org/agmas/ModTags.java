package org.agmas;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;

public class ModTags {

    public static final TagKey<Item> CROSSBOWS = TagKey.create(Registries.ITEM, Tilted.of("crossbows"));
    public static final TagKey<Item> AIMABLE = TagKey.create(Registries.ITEM, Tilted.of("aimable"));

    public static void init() {}
}
