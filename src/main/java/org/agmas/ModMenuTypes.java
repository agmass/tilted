package org.agmas;

import net.fabricmc.loader.impl.lib.mappingio.format.FeatureSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.agmas.screen.FletchingTableMenu;

public class ModMenuTypes {

    //? if >=26.1 {
    /*public static final MenuType<FletchingTableMenu> FLETCHING_TABLE = register("fletching_table", FletchingTableMenu::new);

    public static <T extends AbstractContainerMenu> MenuType<T> register(
            String name,
            MenuType.MenuSupplier<T> constructor
    ) {
        return Registry.register(BuiltInRegistries.MENU, name, new MenuType<>(constructor, FeatureFlagSet.of()));
    }
    *///? } else {
    public static final MenuType<FletchingTableMenu> FLETCHING_TABLE = Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(Tilted.MOD_ID, "fletching_table"), new MenuType<>(FletchingTableMenu::new, FeatureFlagSet.of()));

    //? }

    public static void init() {
    }
}
