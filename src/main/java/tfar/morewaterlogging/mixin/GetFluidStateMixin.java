package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.morewaterlogging.DefaultIWaterLoggable;
import tfar.morewaterlogging.WaterloggingUtils;

import static tfar.morewaterlogging.DefaultIWaterLoggable.WATERLOGGED;

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
				LeavesBlock.class,
				LecternBlock.class
})
public class GetFluidStateMixin extends Block implements IWaterLoggable {


	public GetFluidStateMixin(Properties properties) {
		super(properties);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Inject(method = "<init>",at = @At("TAIL"))
	private void injectDefaultState(AbstractBlock.Properties properties, CallbackInfo ci) {
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED,false));
	}
}
