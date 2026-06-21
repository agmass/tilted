package org.agmas;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> MAGAZINE = of("magazine");
    private static ResourceKey<Enchantment> of(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, Tilted.of("magazine"));
    }

    public static void init() {}
}
