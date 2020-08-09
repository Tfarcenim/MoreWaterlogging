package tfar.morewaterlogging.mixin;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.morewaterlogging.WaterloggingUtils;

@Mixin({
				AnvilBlock.class,
				BannerBlock.class,
				BedBlock.class,
				BellBlock.class,
				DoorBlock.class,
				EndPortalFrameBlock.class,
				FenceGateBlock.class,
				LeavesBlock.class,
				LecternBlock.class
})
public class GetPlacementStateMixin {

	@Inject(method = "getStateForPlacement",at = @At("RETURN"), cancellable = true)
	private void placeWaterLoggedState(BlockItemUseContext context, CallbackInfoReturnable<BlockState> cir) {
		WaterloggingUtils.modifyState(context,cir);
	}
}
