package the.sneaked.eden;

import the.sneaked.eden.data.EdenLootTableProvider;
import the.sneaked.eden.data.ModModelProvider;
import the.sneaked.eden.data.ModRegistryDataGenerator;
import the.sneaked.eden.world.ModConfiguredFeatures;
import the.sneaked.eden.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;


import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class EdenDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EdenLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}

}