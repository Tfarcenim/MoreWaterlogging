package tfar.morewaterlogging.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;

import static tfar.morewaterlogging.DefaultIWaterLoggable.WATERLOGGED;

@Mixin(PistonBlock.class)
public class PistonBlockMixin extends Block {
	public PistonBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
}
