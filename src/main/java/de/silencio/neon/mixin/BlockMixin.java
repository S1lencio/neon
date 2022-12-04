package de.silencio.neon.mixin;


import de.silencio.neon.module.Module;
import de.silencio.neon.module.ModuleManager;
import de.silencio.neon.module.world.XRay;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Block.class)
public class BlockMixin {

    @Inject(at = @At("RETURN"), method = "shouldDrawSide", cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos otherPos, CallbackInfoReturnable<Boolean> cir) {

        if (ModuleManager.INSTANCE.getModule("xray").isEnabled()) {
            cir.setReturnValue(XRay.showBlock(state));
        }
    }
}
