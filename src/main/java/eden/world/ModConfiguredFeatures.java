package eden.world;

import eden.Eden;
import eden.registry.EdenBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> HALO_FLOWER_KEY = registerKey("halo_flower_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WINGED_BEAUTY_KEY = registerKey("winged_beauty_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_CARNATION_KEY = registerKey("red_carnation_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CARNATION_KEY = registerKey("white_carnation_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_CARNATION_KEY = registerKey("blue_carnation_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LILY_KEY = registerKey("lily_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DELPHNIUM_KEY = registerKey("delphinium_key");
    //CF -> PF -> BM
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        Object ModBlocks;
        register(context, HALO_FLOWER_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
        new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.HALO_FLOWER
                .getDefaultState())),
        List.of(Blocks.GRASS_BLOCK)));

        register(context, WINGED_BEAUTY_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.WINGED_BEAUTY
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));

        register(context, RED_CARNATION_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.RED_CARNATION
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));

        register(context, WHITE_CARNATION_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.WHITE_CARNATION
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));
        register(context, BLUE_CARNATION_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.BLUE_CARNATION
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));
        register(context, LILY_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.LILY
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));
        register(context, DELPHNIUM_KEY, Feature.RANDOM_PATCH,  ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(EdenBlocks.DELPHINIUM
                        .getDefaultState())),
                List.of(Blocks.GRASS_BLOCK)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Eden.MOD_ID, name));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, C configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

