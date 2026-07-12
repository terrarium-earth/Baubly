package earth.terrarium.baubly.fabric;

import dev.emi.trinkets.api.SlotType;
import dev.emi.trinkets.api.TrinketInventory;
import earth.terrarium.baubly.common.SlotInfo;
import net.minecraft.world.entity.LivingEntity;

public class FabricUtils {
    public static SlotInfo getSlotInfo(SlotType slotType, LivingEntity entity, int index) {
        var name = slotType.getGroup() + "/" + slotType.getName();
        return new SlotInfo(name, entity, index);
    }
}
