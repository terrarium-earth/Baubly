package earth.terrarium.baubly.client;

import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Expect;
import org.apache.commons.lang3.NotImplementedException;

public class BaublyClient {

    @Expect
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer);
}
