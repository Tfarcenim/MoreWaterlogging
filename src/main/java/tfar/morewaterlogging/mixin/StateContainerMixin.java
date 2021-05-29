package tfar.morewaterlogging.mixin;

import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StateContainer.Builder.class)
public class StateContainerMixin {

    //stop the game from crashing if another mod adds waterlogging to a subclass
    //@Inject(method = "validateProperty",at = @At("HEAD"),cancellable = true)
 //   private void disableValidation(Property<?> property, CallbackInfo ci) {
  //      if (BlockStateProperties.WATERLOGGED.getName().equals(property.getName())) {
  ////          ci.cancel();
 //       }
  //  }
}
