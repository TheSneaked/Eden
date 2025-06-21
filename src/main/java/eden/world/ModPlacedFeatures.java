package eden.world;

import eden.Eden;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> HALO_FLOWER_PLACED_KEY = registerKey("halo_flower_placed");
    public static final RegistryKey<PlacedFeature> WINGED_BEAUTY_PLACED_KEY = registerKey("winged_beauty_placed");
    public static final RegistryKey<PlacedFeature> RED_CARNATION_PLACED_KEY = registerKey("red_carnation_placed");
    public static final RegistryKey<PlacedFeature> WHITE_CARNATION_PLACED_KEY = registerKey("white_carnation_placed");
    public static final RegistryKey<PlacedFeature> BLUE_CARNATION_PLACED_KEY = registerKey("blue_carnation_placed");
    public static final RegistryKey<PlacedFeature> LILY_PLACED_KEY = registerKey("lily_key");
    public static final RegistryKey<PlacedFeature> DELPHINIUM_PLACED_KEY = registerKey("delphinium_placed");
    //delphinium


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context, HALO_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HALO_FLOWER_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, WINGED_BEAUTY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WINGED_BEAUTY_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, RED_CARNATION_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_CARNATION_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, WHITE_CARNATION_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WHITE_CARNATION_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BLUE_CARNATION_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUE_CARNATION_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LILY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LILY_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, DELPHINIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DELPHNIUM_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Eden.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }


}
