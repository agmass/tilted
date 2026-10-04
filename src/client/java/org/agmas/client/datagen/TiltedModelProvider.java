package org.agmas.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
//? if >=26.1 {
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
//? } else {
/*import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
*///? }
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.agmas.ModBlocks;
import org.agmas.ModItems;
import org.agmas.attachments.SkinsComponent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TiltedModelProvider extends FabricModelProvider {
    //? if >=26.1 {
    public TiltedModelProvider(FabricPackOutput output) {
        super(output);
    }
    //? } else {
    /*public TiltedModelProvider(FabricDataOutput output) {
        super(output);
    }
    *///? }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.CRATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        File dir = new File("../../src/main/resources");
        dir.mkdir();
        dir = new File("../../src/main/resources/assets");
        dir.mkdir();
        dir = new File("../../src/main/resources/assets/tilted");
        dir.mkdir();
        dir = new File("../../src/main/resources/assets/tilted/models");
        dir.mkdir();
        dir = new File("../../src/main/resources/assets/tilted/models/item");
        dir.mkdir();
        dir = new File("../../src/main/resources/assets/tilted/items");
        dir.mkdir();

        itemModelGenerator.generateFlatItem(ModItems.CARNIVORA_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RUNESCAPE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CARRION_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ICE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GOLDENEYE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GUI_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HISTORY_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HOLIDAY_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HYPERDEATH_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SPECIALOPS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.JUNKYARD_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MINED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MONEYTALKS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.REVENANT_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RIPPER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHIPPED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIRTUE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SENTINAL_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHRIMP_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NOSTALGIA_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NROSES_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FLAMBE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TEMPERED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TRAINING_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.AQUARIUS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHERRY_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CLOCKWORK_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.THORNED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SUNSET_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TIDE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WILLPOWER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WRATH_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MISSING_TEXTURE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.COTTONCANDY_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HAMMER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KEBAB_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANCIENT_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ARMOURED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.AWAKENED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BUSINESS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHUD_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FLOWER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FRIEND_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GODHOLMS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NAUTICAL_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PALE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ROAR_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SPLIT_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STOPWATCH_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SULFUROUS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TOTEMIC_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WILDFLOWER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WRITER_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANTIVIRUS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CELESTIAL_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HEARTSTRING_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.LEGALLY_DISTINCT_BRIMSTONE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MALWARE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PVP_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SOLARIS_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WARLOCK_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.INVERTED_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DARKSUN_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        writeCrossbowSkin(SkinsComponent.BLACKICE);
        writeCrossbowSkin(SkinsComponent.BLUEICE);
        writeCrossbowSkin(SkinsComponent.GREENICE);
        writeCrossbowSkin(SkinsComponent.LIGHTBLUEICE);
        writeCrossbowSkin(SkinsComponent.CYANICE);
        writeCrossbowSkin(SkinsComponent.LIMEICE);
        writeCrossbowSkin(SkinsComponent.MAGENTAICE);
        writeCrossbowSkin(SkinsComponent.ORANGEICE);
        writeCrossbowSkin(SkinsComponent.PINKICE);
        writeCrossbowSkin(SkinsComponent.PURPLEICE);
        writeCrossbowSkin(SkinsComponent.YELLOWICE);
        writeCrossbowSkin(SkinsComponent.REDICE);
        writeCrossbowSkin(SkinsComponent.ICE);
        writeCrossbowSkin(SkinsComponent.CARNIVORA);
        writeCrossbowSkin(SkinsComponent.CARRION);
        writeCrossbowSkin(SkinsComponent.GOLDENEYE);
        writeCrossbowSkin(SkinsComponent.GUI);
        writeCrossbowSkin(SkinsComponent.HISTORY);
        writeCrossbowSkin(SkinsComponent.HOLIDAY);
        writeCrossbowSkin(SkinsComponent.HYPERDEATH);
        writeCrossbowSkin(SkinsComponent.JUNKYARD);
        writeCrossbowSkin(SkinsComponent.MINED);
        writeCrossbowSkin(SkinsComponent.MONEYTALKS);
        writeCrossbowSkin(SkinsComponent.NOSTALGIA);
        writeCrossbowSkin(SkinsComponent.NROSES);
        writeCrossbowSkin(SkinsComponent.REVENANT);
        writeCrossbowSkin(SkinsComponent.RIPPER);
        writeCrossbowSkin(SkinsComponent.RUNESCAPE);
        writeCrossbowSkin(SkinsComponent.SENTINAL);
        writeCrossbowSkin(SkinsComponent.SHIPPED);
        writeCrossbowSkin(SkinsComponent.SHRIMP);
        writeCrossbowSkin(SkinsComponent.SPECIALOPS);
        writeCrossbowSkin(SkinsComponent.VIRTUE);
        writeCrossbowSkin(SkinsComponent.FLAMBE);
        writeCrossbowSkin(SkinsComponent.TEMPERED);
        writeCrossbowSkin(SkinsComponent.TRAINING);
        writeCrossbowSkin(SkinsComponent.AQUARIUS);
        writeCrossbowSkin(SkinsComponent.CHERRY);
        writeCrossbowSkin(SkinsComponent.CLOCKWORK);
        writeCrossbowSkin(SkinsComponent.SUNSET);
        writeCrossbowSkin(SkinsComponent.THORNED);
        writeCrossbowSkin(SkinsComponent.TIDE);
        writeCrossbowSkin(SkinsComponent.WILLPOWER);
        writeCrossbowSkin(SkinsComponent.WRATH);
        writeCrossbowSkin(SkinsComponent.MISSING_TEXTURE);
        writeCrossbowSkin(SkinsComponent.COTTONCANDY);
        writeCrossbowSkin(SkinsComponent.HAMMER);
        writeCrossbowSkin(SkinsComponent.KEBAB);
        writeCrossbowSkin(SkinsComponent.ANCIENT);
        writeCrossbowSkin(SkinsComponent.ARMOURED);
        writeCrossbowSkin(SkinsComponent.AWAKENED);
        writeCrossbowSkin(SkinsComponent.BUSINESS);
        writeCrossbowSkin(SkinsComponent.CHUD);
        writeCrossbowSkin(SkinsComponent.FLOWER);
        writeCrossbowSkin(SkinsComponent.FRIEND);
        writeCrossbowSkin(SkinsComponent.GODHOLMS);
        writeCrossbowSkin(SkinsComponent.NAUTICAL);
        writeCrossbowSkin(SkinsComponent.PALE);
        writeCrossbowSkin(SkinsComponent.ROAR);
        writeCrossbowSkin(SkinsComponent.SPLIT);
        writeCrossbowSkin(SkinsComponent.STOPWATCH);
        writeCrossbowSkin(SkinsComponent.SULFUROUS);
        writeCrossbowSkin(SkinsComponent.TOTEMIC);
        writeCrossbowSkin(SkinsComponent.WILDFLOWER);
        writeCrossbowSkin(SkinsComponent.WRITER);
        writeCrossbowSkin(SkinsComponent.ANTIVIRUS);
        writeCrossbowSkin(SkinsComponent.CELESTIAL);
        writeCrossbowSkin(SkinsComponent.HEARTSTRING);
        writeCrossbowSkin(SkinsComponent.LEGALLY_DISTINCT_BRIMSTONE);
        writeCrossbowSkin(SkinsComponent.MALWARE);
        writeCrossbowSkin(SkinsComponent.PVP);
        writeCrossbowSkin(SkinsComponent.SOLARIS);
        writeCrossbowSkin(SkinsComponent.WARLOCK);
        writeCrossbowSkin(SkinsComponent.DARKSUN);
        writeCrossbowSkin(SkinsComponent.INVERTED);
    }

    @Override
    public String getName() {
        return "TiltedModelProvider";
    }

    //
    // Is this a weird, convulted, and useless way to do this? Yeah, but i just pulled an all nighter, and
    //
    // Is this writing right into resources rather than the generated folder? YEAH. what are YOU going to do about it. You're not my mom?
    public static void writeCrossbowSkin(SkinsComponent skinEnum) {
        createMainModel(skinEnum);
        createSingleSkinModel(skinEnum,"_amethyst", "scatter");
        createSingleSkinModel(skinEnum,"_torch", "torch");
        createSingleSkinModel(skinEnum,"_brimstone_0", "brimstone_0");
        createSingleSkinModel(skinEnum,"_brimstone_1", "brimstone_1");
        createSingleSkinModel(skinEnum,"_brimstone_2", "brimstone_2");
        createSingleSkinModel(skinEnum,"_brimstone_3", "brimstone_3");
        createSingleSkinModel(skinEnum,"_brimstone_4", "brimstone_4");
        createSingleSkinModel(skinEnum,"_brimstone_5", "brimstone_5");
    }

    public static void createMainModel(SkinsComponent skinEnum) {
        try {
            File dir = new File("../../src/main/resources/assets/tilted/models/item/" + skinEnum.name().toLowerCase());
            dir.mkdir();
            FileWriter fileWriter = new FileWriter("../../src/main/resources/assets/tilted/models/item/" +skinEnum.name().toLowerCase() + "/"+ "crossbow.json");
            fileWriter.write("{\n");
            fileWriter.write("    \"parent\": \"minecraft:item/crossbow\",\n");
            fileWriter.write("    \"textures\": {\n");
            fileWriter.write("        \"layer0\": \"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow\"\n");
            fileWriter.write("    }\n");
            fileWriter.write("}");
            fileWriter.close();

            fileWriter = new FileWriter("../../src/main/resources/assets/tilted/models/item/" +skinEnum.name().toLowerCase() + "/"+ "crossbow_arrow.json");
            fileWriter.write("{\n");
            fileWriter.write("    \"parent\": \"minecraft:item/crossbow\",\n");
            fileWriter.write("    \"textures\": {\n");
            fileWriter.write("        \"layer0\": \"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow_arrow\"\n");
            fileWriter.write("    }\n");
            fileWriter.write("}");
            fileWriter.close();

            fileWriter = new FileWriter("../../src/main/resources/assets/tilted/models/item/" +skinEnum.name().toLowerCase() + "/"+ "crossbow_firework.json");
            fileWriter.write("{\n");
            fileWriter.write("    \"parent\": \"minecraft:item/crossbow\",\n");
            fileWriter.write("    \"textures\": {\n");
            fileWriter.write("        \"layer0\": \"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow_firework\"\n");
            fileWriter.write("    }\n");
            fileWriter.write("}");
            fileWriter.close();

            for (int i = 0; i < 3; i++) {
                fileWriter = new FileWriter("../../src/main/resources/assets/tilted/models/item/" +skinEnum.name().toLowerCase() + "/"+ "crossbow_pulling_" + i + ".json");
                fileWriter.write("{\n");
                fileWriter.write("    \"parent\": \"minecraft:item/crossbow\",\n");
                fileWriter.write("    \"textures\": {\n");
                fileWriter.write("        \"layer0\": \"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow_pulling_" + i + "\"\n");
                fileWriter.write("    }\n");
                fileWriter.write("}");
                fileWriter.close();
            }

            dir = new File("../../src/main/resources/assets/tilted/items/" + skinEnum.name().toLowerCase());
            dir.mkdir();
            fileWriter = new FileWriter("../../src/main/resources/assets/tilted/items/" +skinEnum.name().toLowerCase() + "/"+ "crossbow.json");
            // Never let me near an IDE again.
            fileWriter.write("{\n");
            fileWriter.write("  \"model\": {\n");
            fileWriter.write("    \"type\": \"minecraft:select\",\n");
            fileWriter.write("    \"cases\": [\n");
            fileWriter.write("      {\n");
            fileWriter.write("        \"model\": {\n");
            fileWriter.write("          \"type\": \"minecraft:model\",\n");
            fileWriter.write("          \"model\": \"tilted:item/"+ skinEnum.name().toLowerCase() +"/crossbow_arrow\"\n");
            fileWriter.write("        },\n");
            fileWriter.write("        \"when\": \"arrow\"\n");
            fileWriter.write("      },\n");
            fileWriter.write("      {\n");
            fileWriter.write("        \"model\": {\n");
            fileWriter.write("          \"type\": \"minecraft:model\",\n");
            fileWriter.write("          \"model\": \"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow_firework\"\n");
            fileWriter.write("        },\n");
            fileWriter.write("        \"when\": \"rocket\"\n");
            fileWriter.write("      }\n");
            fileWriter.write("    ],\n");
            fileWriter.write("    \"fallback\": {\n");
            fileWriter.write("      \"type\": \"minecraft:condition\",\n");
            fileWriter.write("      \"on_false\": {\n");
            fileWriter.write("        \"type\": \"minecraft:model\",\n");
            fileWriter.write("        \"model\": \"tilted:item/"+ skinEnum.name().toLowerCase() + "/crossbow\"\n");
            fileWriter.write("      },\n");
            fileWriter.write("      \"on_true\": {\n");
            fileWriter.write("        \"type\": \"minecraft:range_dispatch\",\n");
            fileWriter.write("        \"entries\": [\n");
            fileWriter.write("          {\n");
            fileWriter.write("            \"model\": {\n");
            fileWriter.write("              \"type\": \"minecraft:model\",\n");
            fileWriter.write("              \"model\": \"tilted:item/"+ skinEnum.name().toLowerCase() +"/crossbow_pulling_1\"\n");
            fileWriter.write("            },\n");
            fileWriter.write("            \"threshold\": 0.58\n");
            fileWriter.write("          },\n");
            fileWriter.write("          {\n");
            fileWriter.write("            \"model\": {\n");
            fileWriter.write("              \"type\": \"minecraft:model\",\n");
            fileWriter.write("              \"model\": \"tilted:item/"+ skinEnum.name().toLowerCase() +"/crossbow_pulling_2\"\n");
            fileWriter.write("            },\n");
            fileWriter.write("            \"threshold\": 1.0\n");
            fileWriter.write("          }\n");
            fileWriter.write("        ],\n");
            fileWriter.write("        \"fallback\": {");
            fileWriter.write("          \"type\": \"minecraft:model\",\n");
            fileWriter.write("          \"model\": \"tilted:item/"+ skinEnum.name().toLowerCase() +"/crossbow_pulling_0\"\n");
            fileWriter.write("        },\n");
            fileWriter.write("        \"property\": \"minecraft:crossbow/pull\"\n");
            fileWriter.write("      },\n");
            fileWriter.write("      \"property\": \"minecraft:using_item\"\n");
            fileWriter.write("    },\n");
            fileWriter.write("    \"property\": \"minecraft:charge_type\"\n");
            fileWriter.write("  }\n");
            fileWriter.write("}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createSingleSkinModel(SkinsComponent skinEnum, String suffix, String composition) {
        try {
            File dir = new File("../../src/main/resources/assets/tilted/items/" + skinEnum.name().toLowerCase());
            dir.mkdir();
            FileWriter fileWriter = new FileWriter("../../src/main/resources/assets/tilted/items/" +skinEnum.name().toLowerCase() + "/"+ "crossbow" + suffix + ".json");
            fileWriter.write("{\n");
            fileWriter.write("  \"model\": {\n");
            fileWriter.write("      \"type\": \"minecraft:composite\",\n");
            fileWriter.write("      \"models\": [\n{\"type\": \"minecraft:model\",\n\"model\":\"tilted:item/" + skinEnum.name().toLowerCase() + "/crossbow_pulling_2\"\n},\n{\"type\": \"minecraft:model\",\n\"model\": \"tilted:item/" + composition +"\"}]\n");
            fileWriter.write("    }\n");
            fileWriter.write("}");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Crossbow Format:
"{\n,"
"  \"model\": {\n"
"    \"type": "minecraft:select\",\n"
"    \"cases\": [\n"
"      {\n"
"        \"model\": {\n"
"          \"type\": \"minecraft:model\",\n"
"          \"model\": \"minecraft:item/crossbow_arrow\"\n"
"        },\n"
"        \"when\": \"arrow\"\n"
"      },\n"
"      {\n"
"        \"model\": {\n"
"          \"type\": \"minecraft:model\",\n"
"          \"model\": \"minecraft:item/crossbow_firework\"\n"
"        },\n"
"        \"when\": \"rocket\"\n"
"      }\n"
"    ],\n"
"    \"fallback\": {\n"
"      \"type\": \"minecraft:condition\",\n"
"      \"on_false\": {\n"
"        \"type\": \"minecraft:model\",\n"
"        \"model\": \"minecraft:item/crossbow\"\n"
"      },\n"
"      \"on_true\": {\n"
"        \"type\": \"minecraft:range_dispatch\",\n"
"        \"entries\": [\n"
"          {\n"
"            \"model\": {\n"
"              \"type\": \"minecraft:model\",\n"
"              \"model\": \"minecraft:item/crossbow_pulling_1\"\n"
"            },\n"
"            \"threshold\": 0.58\n"
"          },\n"
"          {\n"
"            \"model\": {\n"
"              \"type\": \"minecraft:model\",\n"
"              \"model\": \"minecraft:item/crossbow_pulling_2\"\n"
"            },\n"
"            \"threshold\": 1.0\n"
"          }\n"
"        ],\n"
"        \"fallback\": {"
"          \"type\": \"minecraft:model\",\n"
"          \"model\": \"minecraft:item/crossbow_pulling_0\"\n"
"        },\n"
"        \"property\": \"minecraft:crossbow/pull\"\n"
"      },\n"
"      \"property\": \"minecraft:using_item\"\n"
"    },\n"
"    \"property\": \"minecraft:charge_type\"\n"
"  }\n"
"}"

 */