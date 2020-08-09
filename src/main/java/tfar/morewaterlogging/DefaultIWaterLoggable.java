package tfar.morewaterlogging;

import net.minecraft.block.IWaterLoggable;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;

public interface DefaultIWaterLoggable extends IWaterLoggable {

	BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

}
