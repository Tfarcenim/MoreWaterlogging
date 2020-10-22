package tfar.morewaterlogging;

import net.minecraft.block.*;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreWaterlogging.MODID)
public class MoreWaterlogging {
    // Directly reference a log4j logger.

    public static final String MODID = "morewaterlogging";

    public static final Logger LOGGER = LogManager.getLogger();

    public static final Class<?>[] waterlogged_classes_that_dont_override_getPlacementState =
            new Class<?>[]{
                    BarrierBlock.class,
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

    public static final Class<?>[] waterlogged_classes_that_dont_override_fillStateContainer =
            new Class<?>[]{
                    BarrierBlock.class,
                    BeaconBlock.class,
                    DragonEggBlock.class,
                    EnchantingTableBlock.class,
                    SpawnerBlock.class,
            };
    public MoreWaterlogging() {
    }
}
