package the.sneaked.eden.component;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.ladysnake.cca.api.v3.component.Component;

public interface PositionComponent extends Component {

    Vec3d getPosition(RegistryKey<World> dimension);
    void setPosition(RegistryKey<World> dimension, Vec3d position);

}
