package the.sneaked.eden.mixin;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import the.sneaked.eden.world.dimension.ModDimensions;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract boolean teleport(double x, double y, double z, boolean particleEffects);

    @Inject(method = "eatFood", at = @At("RETURN"))
    private void eatFood(World world, ItemStack stack, FoodComponent foodComponent, CallbackInfoReturnable<ItemStack> cir) {
        if (world.isClient || !stack.isOf(Items.APPLE) || !world.getDimensionEntry().matchesKey(ModDimensions.SPACE_DIM_TYPE)) return;
        ServerWorld overworld = world.getServer().getWorld(World.OVERWORLD);
        this.teleport(overworld, );
    }

}
