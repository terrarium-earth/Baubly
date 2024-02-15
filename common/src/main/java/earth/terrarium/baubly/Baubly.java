package earth.terrarium.baubly;

import dev.architectury.injectables.annotations.ExpectPlatform;
import earth.terrarium.baubly.common.Bauble;
import net.minecraft.world.item.Item;

public class Baubly {

    public static final String MOD_ID = "baubly";

    public static void init() {
    }

    @ExpectPlatform
    public static void registerBauble(Item item, Bauble bauble) {

    }

    public static <T extends Item & Bauble> void registerBauble(T item) {
        registerBauble(item, item);
    }
}
