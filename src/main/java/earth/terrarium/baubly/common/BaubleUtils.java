package earth.terrarium.baubly.common;

import net.minecraft.world.Container;
import net.minecraft.world.entity.LivingEntity;
import net.msrandom.multiplatform.annotations.Expect;

import javax.annotation.Nullable;
import java.util.Map;

public class BaubleUtils {

    @Expect
    public static @Nullable Map<String, Container> getBaubleContainers(LivingEntity entity);

    @Expect
    public static Container getBaubleContainer(LivingEntity entity, String identifier);

    @Expect
    public static Map<String, Container> getBaubleContainer(LivingEntity entity, SlotIdentifier identifier);
}
