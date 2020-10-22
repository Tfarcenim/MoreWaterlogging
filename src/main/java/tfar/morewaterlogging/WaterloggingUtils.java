package tfar.morewaterlogging;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashSet;

public class WaterloggingUtils {

	public static void modifyState(BlockItemUseContext context, CallbackInfoReturnable<BlockState> cir) {
		if (cir.getReturnValue() == null || !cir.getReturnValue().hasProperty(DefaultIWaterLoggable.WATERLOGGED))return;
		World world = context.getWorld();
		BlockPos blockPos = context.getPos();
		BlockState state = cir.getReturnValue();
		cir.setReturnValue(state.with(DefaultIWaterLoggable.WATERLOGGED, world.getFluidState(blockPos).getFluid() == Fluids.WATER));
	}

	private static final HashSet<Class<? extends Block>> cache = new HashSet<>();

	public static void warn(Block block) {
		if (!cache.contains(block.getClass())) {
			MoreWaterlogging.LOGGER.warn(block.getClass() + " extends " + block.getClass().getSuperclass() +
					" and overrides fillStateContainer, but doesn't call super, this is a bug in the mod extending the class, report to them." +
					"  This block will NOT be waterloggable until it's fixed on their end");
			cache.add(block.getClass());
		}
	}
}
