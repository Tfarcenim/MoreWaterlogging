package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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

	@Inject(method = "<init>",at = @At("TAIL"))
	private void injectDefaultState(CallbackInfo ci) {
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED,false));
	}
}
