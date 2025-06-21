package eden.datagen;

import eden.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {


        addDrop(ModBlocks.HALO_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_HALO_FLOWER);
        addDrop(ModBlocks.WINGED_BEAUTY);
        addPottedPlantDrops(ModBlocks.POTTED_WINGED_BEAUTY);
        addDrop(ModBlocks.BLUE_CARNATION);
        addPottedPlantDrops(ModBlocks.POTTED_BLUE_CARNATION);
        addDrop(ModBlocks.RED_CARNATION);
        addPottedPlantDrops(ModBlocks.POTTED_RED_CARNATION);
        addDrop(ModBlocks.WHITE_CARNATION);
        addPottedPlantDrops(ModBlocks.POTTED_WHITE_CARNATION);
        addDrop(ModBlocks.LILY);
        addPottedPlantDrops(ModBlocks.POTTED_LILY);
        addDrop(ModBlocks.DELPHINIUM);
        addPottedPlantDrops(ModBlocks.POTTED_DELPHINIUM);
    }

}