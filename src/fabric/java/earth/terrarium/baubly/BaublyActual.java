package earth.terrarium.baubly;

import dev.emi.trinkets.api.TrinketsApi;
import earth.terrarium.baubly.common.Bauble;
import earth.terrarium.baubly.fabric.BaublyTrinketWrapper;
import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Actual;

public class BaublyActual {
    @Actual
    public static void registerBauble(Item item, Bauble bauble) {
        TrinketsApi.registerTrinket(item, new BaublyTrinketWrapper(bauble));
    }
}
