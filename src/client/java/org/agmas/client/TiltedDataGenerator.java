package org.agmas.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.agmas.client.datagen.ModTagProviders;
import org.agmas.client.datagen.TiltedModelProvider;
import org.agmas.client.datagen.TiltedRecipeProvider;

public class TiltedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		//
		//
		// THE DATAGEN IN THIS MOD IS HAUNTED BY MY SPAGHETTI CODE AND THE EVIL FABRIC
		// DATAGEN DEMONS. PROCEED WITH CAUTION.
		//
		//


		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TiltedModelProvider::new);
		pack.addProvider(ModTagProviders.ItemTags::new);
		pack.addProvider(TiltedRecipeProvider::new);
		//pack.addProvider(TiltedLangProvider::new);
	}
}
