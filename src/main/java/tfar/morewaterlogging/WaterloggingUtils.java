package tfar.morewaterlogging;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class WaterloggingUtils {

	public static void modifyState(BlockItemUseContext context, CallbackInfoReturnable<BlockState> cir) {
		if (cir.getReturnValue() == null)return;
		World world = context.getWorld();
		BlockPos blockPos = context.getPos();
		BlockState state = cir.getReturnValue();
		cir.setReturnValue(state.with(DefaultIWaterLoggable.WATERLOGGED, world.getFluidState(blockPos).getFluid() == Fluids.WATER));
	}
}
