package earth.terrarium.baubly.forge;

import earth.terrarium.baubly.common.SlotInfo;
import top.theillusivec4.curios.api.SlotContext;

public class ForgeUtils {
    public static SlotInfo getSlotInfo(SlotContext slotContext) {
        return new SlotInfo(slotContext.identifier(), slotContext.entity(), slotContext.index());
    }
}
