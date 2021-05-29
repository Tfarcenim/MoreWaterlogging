package tfar.morewaterlogging;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import virtuoel.statement.api.StateRefresher;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreWaterlogging.MODID)
public class MoreWaterlogging {
    // Directly reference a log4j logger.

    public static final String MODID = "morewaterlogging";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final Class<?>[] waterlogged_classes_that_dont_override_getPlacementState =
            new Class<?>[]{
                    BrewingStandBlock.class,
                    BeaconBlock.class,
                    CakeBlock.class,
                    ComposterBlock.class,
                    DaylightDetectorBlock.class,
                    DragonEggBlock.class,
                    EnchantingTableBlock.class,
                    PressurePlateBlock.class,
                    SpawnerBlock.class,
                    WeightedPressurePlateBlock.class
            };

    public MoreWaterlogging() {


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::common);

        StateRefresher.INSTANCE.reorderBlockStates();
    }

    private void common(FMLCommonSetupEvent e) {
        injectWaterlogging(Blocks.BARRIER);
        injectWaterlogging(Blocks.BEACON);
        injectWaterlogging(Blocks.BELL);
        injectWaterlogging(Blocks.BREWING_STAND);
        injectWaterlogging(Blocks.CAKE);
        injectWaterlogging(Blocks.COMPOSTER);
        injectWaterlogging(Blocks.DAYLIGHT_DETECTOR);
        injectWaterlogging(Blocks.DRAGON_EGG);
        injectWaterlogging(Blocks.ENCHANTING_TABLE);
        injectWaterlogging(Blocks.END_PORTAL_FRAME);
        injectWaterlogging(Blocks.GRINDSTONE);
        injectWaterlogging(Blocks.SPAWNER);
        injectWaterlogging(Blocks.STRUCTURE_BLOCK);
        injectWaterlogging(Blocks.TURTLE_EGG);

        injectWaterlogging(AbstractPressurePlateBlock.class);
        injectWaterlogging(AbstractBannerBlock.class);
        injectWaterlogging(AnvilBlock.class);
        injectWaterlogging(BedBlock.class);
        injectWaterlogging(DoorBlock.class);
        injectWaterlogging(FenceGateBlock.class);
        injectWaterlogging(HopperBlock.class);
        injectWaterlogging(PistonBlock.class);
        injectWaterlogging(PistonHeadBlock.class);
        injectWaterlogging(ShulkerBoxBlock.class);
        injectWaterlogging(StonecutterBlock.class);

    }

    public static void injectWaterlogging(Class<? extends Block> clazz) {
        for (Block block : Registry.BLOCK) {
            if (clazz.isAssignableFrom(block.getClass())) {
                injectWaterlogging(block);
            }
        }
    }

    public static void injectWaterlogging(Block block) {
        StateRefresher.INSTANCE.addBlockProperty(block, BlockStateProperties.WATERLOGGED, false);
    }

}
