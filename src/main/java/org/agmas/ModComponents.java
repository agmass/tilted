package org.agmas;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import org.agmas.attachments.BarrelAttachment;
import org.agmas.attachments.ScopeAttachment;
import org.agmas.attachments.SkinsComponent;

public class ModComponents {
    public static final DataComponentType<Integer> SCOPE_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Tilted.MOD_ID, "scope"),
            DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build()
    );
    public static final DataComponentType<Integer> BARREL_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Tilted.MOD_ID, "barrel"),
            DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build()
    );
    public static final DataComponentType<Integer> SKIN_COMPONENT = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Tilted.MOD_ID, "skin"),
            DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build()
    );

    public static void init() {}

    public static BarrelAttachment barrel(int ordinal) {
        return BarrelAttachment.values()[ordinal];
    }

    public static ScopeAttachment scope(int ordinal) {
        return ScopeAttachment.values()[ordinal];
    }

    public static SkinsComponent skin(int ordinal) {
        return SkinsComponent.values()[ordinal];
    }
}
