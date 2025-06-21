package eden.registry;

import eden.Eden;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


public class EdenBlocks {

    public static final Block HALO_FLOWER = registerBlock("halo_flower", flower(StatusEffects.ABSORPTION));
    public static final Block POTTED_HALO_FLOWER = registerBlock("potted_halo_flower", flowerPot(HALO_FLOWER));

    public static final Block WINGED_BEAUTY = registerBlock("winged_beauty", flower(StatusEffects.LEVITATION));
    public static final Block POTTED_WINGED_BEAUTY = registerBlock("potted_winged_beauty", flowerPot(WINGED_BEAUTY));

    public static final Block RED_CARNATION = registerBlock("red_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, Block.Settings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_RED_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(Eden.MOD_ID, "potted_red_carnation"),
            new FlowerPotBlock(RED_CARNATION, Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block WHITE_CARNATION = registerBlock("white_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, Block.Settings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_WHITE_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(Eden.MOD_ID, "potted_white_carnation"),
            new FlowerPotBlock(WHITE_CARNATION, Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block BLUE_CARNATION = registerBlock("blue_carnation",
            new FlowerBlock(StatusEffects.LEVITATION, 6, Block.Settings.copy(Blocks.POPPY).nonOpaque().noCollision()) );

    public static final Block POTTED_BLUE_CARNATION = Registry.register(Registries.BLOCK, Identifier.of(Eden.MOD_ID, "potted_blue_carnation"),
            new FlowerPotBlock(BLUE_CARNATION, Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block LILY = registerBlock("lily",
            new FlowerBlock(StatusEffects.LEVITATION, 6, Block.Settings.copy(Blocks.POPPY).nonOpaque().noCollision()) );
    public static final Block POTTED_LILY = Registry.register(Registries.BLOCK, Identifier.of(Eden.MOD_ID, "potted_lily"),
            new FlowerPotBlock(LILY, Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block DELPHINIUM = registerBlock("delphinium", flower(StatusEffects.LEVITATION));
    public static final Block POTTED_DELPHINIUM = registerBlock("potted_delphinium", flowerPot(DELPHINIUM));



    public static void registerModBlocks() {
        Eden.LOGGER.info("Registering Mod Blocks for " + Eden.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(EdenBlocks.HALO_FLOWER);
            entries.add(EdenBlocks.WINGED_BEAUTY);
            entries.add(EdenBlocks.RED_CARNATION);
            entries.add(EdenBlocks.BLUE_CARNATION);
            entries.add(EdenBlocks.WHITE_CARNATION);
            entries.add(EdenBlocks.DELPHINIUM);
            entries.add(EdenBlocks.LILY);
        });
    }

    private static Block flower(RegistryEntry<StatusEffect> effect) {
        return new FlowerBlock(effect, 6, Block.Settings.copy(Blocks.POPPY).nonOpaque().noCollision());
    }

    private static Block flowerPot(Block flower) {
        return new FlowerPotBlock(flower, Block.Settings.copy(Blocks.POTTED_ALLIUM).nonOpaque());
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Eden.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Eden.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    
}
