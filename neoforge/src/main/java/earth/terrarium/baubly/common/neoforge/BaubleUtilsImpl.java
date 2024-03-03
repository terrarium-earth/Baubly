package earth.terrarium.baubly.common.neoforge;

import earth.terrarium.baubly.common.BaubleUtils;
import earth.terrarium.baubly.common.SlotIdentifier;
import net.minecraft.world.Container;
import net.minecraft.world.entity.LivingEntity;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

import java.util.HashMap;
import java.util.Map;

public class BaubleUtilsImpl {
    public static Container getBaubleContainer(LivingEntity entity, String identifier) {
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).orElse(null);

        if (curiosInventory != null) {
            return new WrappedContainer(curiosInventory.getCurios().get(identifier).getStacks());
        }

        return null;
    }

    public static Map<String, Container> getBaubleContainers(LivingEntity entity) {
        ICuriosItemHandler curiosInventory = CuriosApi.getCuriosInventory(entity).orElse(null);
        Map<String, Container> containers = new HashMap<>();

        if (curiosInventory != null) {
            curiosInventory.getCurios().forEach((identifier, stackHandler) -> {
                containers.put(identifier, new WrappedContainer(stackHandler.getStacks()));
            });
        }

        return containers;
    }

    public static Map<String, Container> getBaubleContainer(LivingEntity entity, SlotIdentifier identifier) {
        return Map.of(identifier.curioId(), BaubleUtils.getBaubleContainer(entity, identifier.curioId()));
    }
}
