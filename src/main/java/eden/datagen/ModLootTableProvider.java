package eden.datagen;

import eden.registry.EdenBlocks;
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


        addDrop(EdenBlocks.HALO_FLOWER);
        addPottedPlantDrops(EdenBlocks.POTTED_HALO_FLOWER);
        addDrop(EdenBlocks.WINGED_BEAUTY);
        addPottedPlantDrops(EdenBlocks.POTTED_WINGED_BEAUTY);
        addDrop(EdenBlocks.BLUE_CARNATION);
        addPottedPlantDrops(EdenBlocks.POTTED_BLUE_CARNATION);
        addDrop(EdenBlocks.RED_CARNATION);
        addPottedPlantDrops(EdenBlocks.POTTED_RED_CARNATION);
        addDrop(EdenBlocks.WHITE_CARNATION);
        addPottedPlantDrops(EdenBlocks.POTTED_WHITE_CARNATION);
        addDrop(EdenBlocks.LILY);
        addPottedPlantDrops(EdenBlocks.POTTED_LILY);
        addDrop(EdenBlocks.DELPHINIUM);
        addPottedPlantDrops(EdenBlocks.POTTED_DELPHINIUM);
    }

}