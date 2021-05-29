package tfar.morewaterlogging.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.morewaterlogging.MoreWaterlogging;
import tfar.morewaterlogging.WaterloggingUtils;

@Mixin(Block.class)
public class BlockMixin {

	@Inject(method = "getStateForPlacement",at = @At("TAIL"),cancellable = true)
	private void modifyState(BlockItemUseContext context, CallbackInfoReturnable<BlockState> cir) {
		for (Class<?> clazz : MoreWaterlogging.waterlogged_classes_that_dont_override_getPlacementState) {
			if (clazz.isAssignableFrom(this.getClass())) {
				WaterloggingUtils.modifyState(context, cir);
			}
		}
	}
}
