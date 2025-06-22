package the.sneaked.eden;

import the.sneaked.eden.registry.EdenBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EdenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.HALO_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_HALO_FLOWER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.WINGED_BEAUTY);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_WINGED_BEAUTY);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.WHITE_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_WHITE_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.BLUE_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_BLUE_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.RED_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_RED_CARNATION);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.LILY);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_LILY);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.DELPHINIUM);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), EdenBlocks.POTTED_DELPHINIUM);
    }
}
