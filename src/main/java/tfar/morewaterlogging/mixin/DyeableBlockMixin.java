package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.morewaterlogging.DefaultIWaterLoggable;

import static tfar.morewaterlogging.DefaultIWaterLoggable.WATERLOGGED;

@Mixin({
				BannerBlock.class,
				BedBlock.class,
				ShulkerBoxBlock.class
})
public class DyeableBlockMixin extends Block implements DefaultIWaterLoggable {
	public DyeableBlockMixin(Properties properties) {
		super(properties);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.hasProperty(WATERLOGGED) && state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Inject(method = "<init>",at = @At("TAIL"))
	private void injectDefaultState(DyeColor colorIn, Properties properties, CallbackInfo ci) {
		if (getDefaultState().hasProperty(WATERLOGGED)) {
			this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
		}
	}
}
