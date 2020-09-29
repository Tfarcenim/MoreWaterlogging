package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.state.StateContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static tfar.morewaterlogging.DefaultIWaterLoggable.WATERLOGGED;
@Mixin({
				AnvilBlock.class,
				BannerBlock.class,
				BedBlock.class,
				BellBlock.class,
				BrewingStandBlock.class,
				CakeBlock.class,
				ComposterBlock.class,
				DaylightDetectorBlock.class,
				DoorBlock.class,
				EndPortalFrameBlock.class,
				FenceGateBlock.class,
				GrindstoneBlock.class,
				HopperBlock.class,
				LeavesBlock.class,
				LecternBlock.class,
				PistonBlock.class,
				PressurePlateBlock.class,
				PistonHeadBlock.class,
				ShulkerBoxBlock.class,
				StonecutterBlock.class,
				StructureBlock.class,
				TurtleEggBlock.class,
				WeightedPressurePlateBlock.class
})
public class FillStateContainerMixin {

	@Inject(method = "fillStateContainer",at = @At("TAIL"))
	private void injectBlockStates(StateContainer.Builder<Block, BlockState> builder, CallbackInfo ci) {
		builder.add(WATERLOGGED);
	}
}
