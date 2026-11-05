package org.agmas.client.plugins;

//? if < 1.21.4 {

import net.minecraft.resources.ResourceLocation;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;

import org.agmas.Tilted;
import org.agmas.attachments.SkinsComponent;

@Environment(EnvType.CLIENT)
public class CrossbowSkinModelPlugin implements ModelLoadingPlugin {
    private static final String[] ID_CROSSBOW_VANILLA = {
        "crossbow",

        "crossbow_pulling_0",
        "crossbow_pulling_1",
        "crossbow_pulling_2",

        "crossbow_arrow",
        "crossbow_firework"
    };

    private static final String[] ID_CROSSBOW_ENCHANCEMENT = {
        "crossbow_amethyst",

        "crossbow_brimstone_0",
        "crossbow_brimstone_1",
        "crossbow_brimstone_2",
        "crossbow_brimstone_3",
        "crossbow_brimstone_4",
        "crossbow_brimstone_5",

        "crossbow_torch",
    };

    @Override
    public void onInitializeModelLoader(Context context) {
        for (SkinsComponent skin : SkinsComponent.values()) {
            for (String id : ID_CROSSBOW_VANILLA     ) context.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/" + id));
            for (String id : ID_CROSSBOW_ENCHANCEMENT) context.addModels(ResourceLocation.fromNamespaceAndPath(Tilted.MOD_ID, "item/" + skin.name().toLowerCase() + "/" + id));
        }
    }
}

//? }
