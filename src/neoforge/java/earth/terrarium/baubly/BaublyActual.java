package earth.terrarium.baubly;

import earth.terrarium.baubly.common.Bauble;
import earth.terrarium.baubly.neoforge.BaublyCuriosWrapper;
import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Actual;
import top.theillusivec4.curios.api.CuriosApi;

public class BaublyActual {
    @Actual
    public static void registerBauble(Item item, Bauble bauble) {
        CuriosApi.registerCurio(item, new BaublyCuriosWrapper(bauble));
    }
}
