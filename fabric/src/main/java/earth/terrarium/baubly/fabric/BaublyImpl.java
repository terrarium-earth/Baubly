package earth.terrarium.baubly.fabric;

import dev.emi.trinkets.api.TrinketsApi;
import earth.terrarium.baubly.common.Bauble;
import net.minecraft.world.item.Item;

public class BaublyImpl {
    public static void registerBauble(Item item, Bauble bauble) {
        TrinketsApi.registerTrinket(item, new BaublyTrinketWrapper(bauble));
    }
}
