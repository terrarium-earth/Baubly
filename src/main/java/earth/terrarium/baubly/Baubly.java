package earth.terrarium.baubly;

import earth.terrarium.baubly.common.Bauble;
import net.minecraft.world.item.Item;
import net.msrandom.multiplatform.annotations.Expect;
import org.apache.commons.lang3.NotImplementedException;

public class Baubly {

    public static final String MOD_ID = "baubly";

    public static void init() {
    }

    @Expect
    public static void registerBauble(Item item, Bauble bauble);

    public static <T extends Item & Bauble> void registerBauble(T item) {
        registerBauble(item, item);
    }
}
