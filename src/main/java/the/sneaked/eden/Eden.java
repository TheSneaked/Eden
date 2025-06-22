package the.sneaked.eden;

import the.sneaked.eden.registry.EdenBlocks;
import the.sneaked.eden.world.dimension.ModDimensions;
import the.sneaked.eden.world.gen.ModWorldGeneration;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eden implements ModInitializer {

	public static final String NAME = "Eden";
	public static final String MOD_ID = "eden";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {

		ServerTickEvents.END_SERVER_TICK.register(Eden::endTick);

		ServerTickEvents.END_SERVER_TICK.register(server -> TickDelayScheduler.tick());
		EdenBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();

	}

	private static void endTick(MinecraftServer server) {

		for (ServerPlayerEntity entity : server.getOverworld().getPlayers()) {

			if (entity.getPos().y <= 320) continue;

			ServerWorld eden = server.getWorld(ModDimensions.SPACE_LEVEL_KEY);
			if (eden == null) return;

			entity.teleport(entity.getX(), 300, entity.getZ(), false);
			TickDelayScheduler.schedule(1, () -> entity.teleport(eden, 0, 100, 0,  entity.getYaw(), entity.getPitch()));

		}

	}

}