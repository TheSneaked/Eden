package the.sneaked.eden.mixin;

import the.sneaked.eden.world.dimension.ModDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Optional;
import java.util.Set;


@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "onStoppedUsing", at = @At("TAIL"))
    private void KickedOut(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        if (!world.isClient) {
            if (stack.isOf(Items.APPLE) && user.getWorld().getDimensionEntry().getKey().equals(Optional.of(ModDimensions.SPACE_DIM_TYPE))) {
                MinecraftServer server = world.getServer();

                ServerWorld serverWorld = server.getOverworld();
                user.teleport(serverWorld, 1, 100, 1, Set.of(), 0, 0);
            }


        }

    }

}






