package earth.terrarium.baubly.client.fabric;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import earth.terrarium.baubly.client.BaubleRenderer;
import net.minecraft.world.item.Item;

public class BaublyClientImpl {
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer) {
        TrinketRendererRegistry.registerRenderer(item, new BaublyTrinketRendererWrapper(renderer));
    }
}
