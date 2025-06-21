package eden;

import eden.block.ModBlocks;
import eden.datagen.ModWorldGenerator;
import eden.world.dimension.ModDimensions;
import eden.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.font.UnihexFont;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.feature.EndPlatformFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Eden implements ModInitializer {
	public static final String MOD_ID = "eden";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {




		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity entity : server.getOverworld().getPlayers()) {
				if (entity.getPos().y > 320) {
					ServerWorld eden = server.getWorld(ModDimensions.SPACE_LEVEL_KEY);
					if (eden != null) {
						entity.teleport(entity.getX(), 300, entity.getZ(), false);
						TickDelayScheduler.schedule(1, () -> entity.teleport(eden, 0, 100, 0,  entity.getYaw(), entity.getPitch()));
					}
				}
			}
		});

		ServerTickEvents.END_SERVER_TICK.register(server -> TickDelayScheduler.tick());
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}