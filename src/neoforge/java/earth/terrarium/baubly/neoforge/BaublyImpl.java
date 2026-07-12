package earth.terrarium.baubly.neoforge;

import earth.terrarium.baubly.common.Bauble;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosApi;

public class BaublyImpl {
    public static void registerBauble(Item item, Bauble bauble) {
        CuriosApi.registerCurio(item, new BaublyCuriosWrapper(bauble));
    }
}
