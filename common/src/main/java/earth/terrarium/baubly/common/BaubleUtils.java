package earth.terrarium.baubly.common;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.Container;
import net.minecraft.world.entity.LivingEntity;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;

public class BaubleUtils {

    @ExpectPlatform
    public static Map<String, Container> getBaubleContainers(LivingEntity entity) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static Container getBaubleContainer(LivingEntity entity, String identifier) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static Container getBaubleContainer(LivingEntity entity, SlotIdentifier identifier) {
        throw new NotImplementedException();
    }
}
