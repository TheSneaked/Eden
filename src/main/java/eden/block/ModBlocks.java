package eden.block;


import eden.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block HALO_FLOWER = registerBlock("halo_flower",
            new FlowerBlock(StatusEffects.ABSORPTION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_HALO_FLOWER = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_halo_flower"),
            new FlowerPotBlock(HALO_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block WINGED_BEAUTY = registerBlock("winged_beauty",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_WINGED_BEAUTY = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_winged_beauty"),
            new FlowerPotBlock(WINGED_BEAUTY, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block RED_CARNATION = registerBlock("red_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_RED_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_red_carnation"),
            new FlowerPotBlock(RED_CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block WHITE_CARNATION = registerBlock("white_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_WHITE_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_white_carnation"),
            new FlowerPotBlock(WHITE_CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block BLUE_CARNATION = registerBlock("blue_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );

    public static final Block POTTED_BLUE_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_blue_carnation"),
            new FlowerPotBlock(BLUE_CARNATION, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block LILY = registerBlock("lily",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );

    public static final Block POTTED_LILY = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_lily"),
            new FlowerPotBlock(LILY, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block DELPHINIUM = registerBlock("delphinium",
            new FlowerBlock(StatusEffects.LEVITATION, 6, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_DELPHINIUM = Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, "potted_delphinium"),
            new FlowerPotBlock(DELPHINIUM, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(eden.Eden.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(eden.Eden.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        eden.Eden.LOGGER.info("Registering Mod Blocks for " + eden.Eden.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
           entries.add(ModBlocks.HALO_FLOWER);
            entries.add(ModBlocks.WINGED_BEAUTY);
            entries.add(ModBlocks.RED_CARNATION);
            entries.add(ModBlocks.BLUE_CARNATION);
            entries.add(ModBlocks.WHITE_CARNATION);
            entries.add(ModBlocks.DELPHINIUM);
            entries.add(ModBlocks.LILY);

        });
    }
}
