package earth.terrarium.baubly.fabric;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketEnums;
import earth.terrarium.baubly.common.Bauble;
import earth.terrarium.baubly.common.DropRule;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public record BaublyTrinketWrapper(Bauble bauble) implements Trinket {
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        bauble.tick(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        bauble.onEquip(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        bauble.onUnequip(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return bauble.canEquip(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public boolean canUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return bauble.canUnequip(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        return bauble.getModifiers(Trinket.super.getModifiers(stack, slot, entity, uuid), stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()), uuid);
    }

    @Override
    public void onBreak(ItemStack stack, SlotReference slot, LivingEntity entity) {
        bauble.onBreak(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
    }

    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        DropRule dropRule = bauble.getDropRule(stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()));
        return switch (dropRule) {
            case ALWAYS_KEEP -> TrinketEnums.DropRule.KEEP;
            case ALWAYS_DROP -> TrinketEnums.DropRule.DROP;
            case DESTROY -> TrinketEnums.DropRule.DESTROY;
            case DEFAULT -> TrinketEnums.DropRule.DEFAULT;
        };
    }


}
