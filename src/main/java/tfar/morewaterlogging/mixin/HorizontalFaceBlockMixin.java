package tfar.morewaterlogging.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.item.BlockItemUseContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.morewaterlogging.WaterloggingUtils;

@Mixin(HorizontalFaceBlock.class)
public class HorizontalFaceBlockMixin {

	@Inject(method = "getStateForPlacement",at = @At("RETURN"),cancellable = true)
	private void adjustWaterlogging(BlockItemUseContext context, CallbackInfoReturnable<BlockState> cir) {
		if ((Object)this instanceof GrindstoneBlock) {
			WaterloggingUtils.modifyState(context,cir);
		}
	}
}
