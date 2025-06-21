package eden.datagen;

import eden.registry.EdenBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.HALO_FLOWER, EdenBlocks.POTTED_HALO_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.WINGED_BEAUTY, EdenBlocks.POTTED_WINGED_BEAUTY, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.RED_CARNATION, EdenBlocks.POTTED_RED_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.BLUE_CARNATION, EdenBlocks.POTTED_BLUE_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.WHITE_CARNATION, EdenBlocks.POTTED_WHITE_CARNATION, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.LILY, EdenBlocks.POTTED_LILY, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(EdenBlocks.DELPHINIUM, EdenBlocks.POTTED_DELPHINIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    }
}