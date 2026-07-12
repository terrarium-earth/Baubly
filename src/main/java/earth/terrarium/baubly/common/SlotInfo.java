package earth.terrarium.baubly.common;

import net.minecraft.world.entity.LivingEntity;

public record SlotInfo(String identifier, LivingEntity wearer, int index) {
}
