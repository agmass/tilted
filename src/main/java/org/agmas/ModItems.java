package org.agmas;

//? if >=26.1 {
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
//? }
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import org.agmas.attachments.SkinsComponent;
import org.agmas.item.TiltedSmithingTemplateItem;

import java.util.List;
import java.util.function.Function;

public class ModItems {

    public static final Item ICE_SMITHING_TEMPLATE = register("ice_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item CARNIVORA_SMITHING_TEMPLATE = register("carnivora_smithing_template",Item::new, new Item.Properties());
    public static final Item JUNKYARD_SMITHING_TEMPLATE = register("junkyard_smithing_template",Item::new, new Item.Properties());
    public static final Item MINED_SMITHING_TEMPLATE = register("mined_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item HOLIDAY_SMITHING_TEMPLATE = register("holiday_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item GUI_SMITHING_TEMPLATE = register("gui_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item GOLDENEYE_SMITHING_TEMPLATE = register("goldeneye_smithing_template",Item::new, new Item.Properties());
    public static final Item CARRION_SMITHING_TEMPLATE = register("carrion_smithing_template",Item::new, new Item.Properties());
    public static final Item HYPERDEATH_SMITHING_TEMPLATE = register("hyperdeath_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item HISTORY_SMITHING_TEMPLATE = register("history_smithing_template",Item::new, new Item.Properties());
    public static final Item MONEYTALKS_SMITHING_TEMPLATE = register("moneytalks_smithing_template",Item::new, new Item.Properties());
    public static final Item NOSTALGIA_SMITHING_TEMPLATE = register("nostalgia_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item NROSES_SMITHING_TEMPLATE = register("nroses_smithing_template",Item::new, new Item.Properties());
    public static final Item REVENANT_SMITHING_TEMPLATE = register("revenant_smithing_template",Item::new, new Item.Properties());
    public static final Item RIPPER_SMITHING_TEMPLATE = register("ripper_smithing_template",Item::new, new Item.Properties());
    public static final Item RUNESCAPE_SMITHING_TEMPLATE = register("runescape_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item SENTINAL_SMITHING_TEMPLATE = register("sentinal_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item SHIPPED_SMITHING_TEMPLATE = register("shipped_smithing_template",Item::new, new Item.Properties());
    public static final Item SHRIMP_SMITHING_TEMPLATE = register("shrimp_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item SPECIALOPS_SMITHING_TEMPLATE = register("specialops_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item VIRTUE_SMITHING_TEMPLATE = register("virtue_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item FLAMBE_SMITHING_TEMPLATE = register("flambe_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item TEMPERED_SMITHING_TEMPLATE = register("tempered_smithing_template",Item::new, new Item.Properties());
    public static final Item TRAINING_SMITHING_TEMPLATE = register("training_smithing_template",Item::new, new Item.Properties());


    public static final Item AQUARIUS_SMITHING_TEMPLATE = register("aquarius_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item CHERRY_SMITHING_TEMPLATE = register("cherry_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item CLOCKWORK_SMITHING_TEMPLATE = register("clockwork_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item SUNSET_SMITHING_TEMPLATE = register("sunset_smithing_template",Item::new, new Item.Properties());
    public static final Item THORNED_SMITHING_TEMPLATE = register("thorned_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item TIDE_SMITHING_TEMPLATE = register("tide_smithing_template",Item::new, new Item.Properties());
    public static final Item WILLPOWER_SMITHING_TEMPLATE = register("willpower_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item WRATH_SMITHING_TEMPLATE = register("wrath_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));

    public static final Item MISSING_TEXTURE_SMITHING_TEMPLATE = register("missing_texture_smithing_template",Item::new, new Item.Properties().rarity(Rarity.RARE));
    public static final Item COTTONCANDY_SMITHING_TEMPLATE = register("cottoncandy_smithing_template",Item::new, new Item.Properties());
    public static final Item HAMMER_SMITHING_TEMPLATE = register("hammer_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final Item KEBAB_SMITHING_TEMPLATE = register("kebab_smithing_template",Item::new, new Item.Properties().rarity(Rarity.UNCOMMON));


    public static void init() {
        //? if >=26.1 {
        
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab) -> {
                    creativeTab.accept(ModItems.ICE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.CARNIVORA_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.JUNKYARD_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.MINED_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.HOLIDAY_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.GUI_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.GOLDENEYE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.CARRION_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.HYPERDEATH_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.HISTORY_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.MONEYTALKS_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.NOSTALGIA_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.NROSES_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.REVENANT_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.RIPPER_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.RUNESCAPE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.SENTINAL_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.SHIPPED_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.SHRIMP_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.SPECIALOPS_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.VIRTUE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.FLAMBE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.TEMPERED_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.TRAINING_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.AQUARIUS_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.CHERRY_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.CLOCKWORK_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.SUNSET_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.THORNED_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.TIDE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.WILLPOWER_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.WRATH_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.MISSING_TEXTURE_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.COTTONCANDY_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.HAMMER_SMITHING_TEMPLATE);
                    creativeTab.accept(ModItems.KEBAB_SMITHING_TEMPLATE);
                });
         //? }
    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Tilted.of(name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

}
