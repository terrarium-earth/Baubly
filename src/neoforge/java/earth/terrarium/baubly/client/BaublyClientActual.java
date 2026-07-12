package earth.terrarium.baubly.client;

import earth.terrarium.baubly.client.neoforge.BaublyCuriosRendererWrapper;
import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Actual;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class BaublyClientActual {
    @Actual
    public static void registerBaubleRenderer(Item item, BaubleRenderer renderer) {
        CuriosRendererRegistry.register(item, () -> new BaublyCuriosRendererWrapper(renderer));
    }
}
