package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;

import static tfar.morewaterlogging.DefaultIWaterLoggable.WATERLOGGED;

@Mixin({
				PressurePlateBlock.class,
				WeightedPressurePlateBlock.class
})
public class PressurePlateBlockMixin extends Block implements IWaterLoggable {
	public PressurePlateBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
}
