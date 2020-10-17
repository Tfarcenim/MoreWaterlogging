package tfar.morewaterlogging;

import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public interface DefaultIWaterLoggable extends IWaterLoggable {

	BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	default boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return state.hasProperty(WATERLOGGED) && IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
}
