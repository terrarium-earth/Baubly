package earth.terrarium.baubly.client.forge;

import earth.terrarium.baubly.client.BaubleRenderer;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class BaublyClientImpl {
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer) {
        CuriosRendererRegistry.register(item, () -> new BaublyCuriosRendererWrapper(renderer));
    }
}
