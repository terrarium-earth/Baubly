package earth.terrarium.baubly.client.fabric;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import earth.terrarium.baubly.client.BaubleRenderer;
import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Actual;

public class BaublyClientActual {
    @Actual
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer) {
        TrinketRendererRegistry.registerRenderer(item, new BaublyTrinketRendererWrapper(renderer));
    }
}
