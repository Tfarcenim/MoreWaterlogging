package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import tfar.morewaterlogging.DefaultIWaterLoggable;

@Mixin({
				AnvilBlock.class,
				BarrierBlock.class,
				BeaconBlock.class,
				BellBlock.class,
				BrewingStandBlock.class,
				CakeBlock.class,
				ComposterBlock.class,
				DaylightDetectorBlock.class,
				DoorBlock.class,
				DragonEggBlock.class,
				EnchantingTableBlock.class,
				EndPortalFrameBlock.class,
				FenceGateBlock.class,
				GrindstoneBlock.class,
				HopperBlock.class,
				LeavesBlock.class,
				LecternBlock.class,
				PistonHeadBlock.class,
				SpawnerBlock.class,
				StonecutterBlock.class,
				StructureBlock.class,
				TurtleEggBlock.class
})
public class GetFluidStateMixin extends Block implements DefaultIWaterLoggable {


	public GetFluidStateMixin(Properties properties) {
		super(properties);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return getDefaultState().hasProperty(WATERLOGGED) ? state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state) : super.getFluidState(state);
	}
}
