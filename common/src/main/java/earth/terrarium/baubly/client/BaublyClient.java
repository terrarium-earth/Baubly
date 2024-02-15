package earth.terrarium.baubly.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.NotImplementedException;

public class BaublyClient {

    @ExpectPlatform
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer) {
        throw new NotImplementedException();
    }
}
