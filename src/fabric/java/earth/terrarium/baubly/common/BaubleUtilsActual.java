package earth.terrarium.baubly.common;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.world.Container;
import net.minecraft.world.entity.LivingEntity;
import net.msrandom.multiplatform.annotations.Actual;

import java.util.HashMap;
import java.util.Map;

public class BaubleUtilsActual {

    @Actual
    public static Container getBaubleContainer(LivingEntity entity, String identifier) {
        String group = identifier.split("/")[0];
        String slot = identifier.split("/")[1];
        var inventory = TrinketsApi.getTrinketComponent(entity).orElse(null);

        if (inventory != null) {
            return inventory.getInventory().get(group).get(slot);
        }
        return null;
    }

    @Actual
    public static Map<String, Container> getBaubleContainers(LivingEntity entity) {
        var inventory = TrinketsApi.getTrinketComponent(entity).orElse(null);
        Map<String, Container> containers = new HashMap<>();

        if (inventory != null) {
            inventory.getInventory().forEach((group, map) -> {
                map.forEach((slot, container) -> {
                    containers.put(group + "/" + slot, container);
                });
            });
        }

        return containers;
    }

    @Actual
    public static Map<String, Container> getBaubleContainer(LivingEntity entity, SlotIdentifier identifier) {
        Map<String, Container> map = new HashMap<>();
        for (String id : identifier.trinketIds()) {
            var container = BaubleUtils.getBaubleContainer(entity, id);
            if (container != null) {
                map.put(id, container);
            }
        }
        return map;
    }
}
