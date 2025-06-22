package the.sneaked.eden.component;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Optional;

public class LocationComponent implements PositionComponent {

    private Map<RegistryKey<World>, Vec3d> locations;

    @Override
    public Vec3d getPosition(RegistryKey<World> dimension) {
        return Optional.of(locations.get(dimension)).orElse(Vec3d.ZERO);
    }

    @Override
    public void setPosition(RegistryKey<World> dimension, Vec3d position) {
        this.locations.put(dimension, position);
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        NbtCompound locationCompound = new NbtCompound();
        for(RegistryKey<World> key : locations.keySet()) {
            Vec3d location = locations.get(key);
            locationCompound.put(key.getRegistry().toString(), new double[]{location.x, location.y, location.z});
        }
        nbtCompound.put("locations", locationCompound);
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        NbtCompound locationCompound = nbtCompound.getCompound("locations");
        for(String key : locationCompound.getKeys()) {
            locations.put();
        }
    }

}
