package earth.terrarium.baubly.fabric;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketEnums;
import earth.terrarium.baubly.common.Bauble;
import earth.terrarium.baubly.common.DropRule;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

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
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation id) {
        return bauble.getModifiers(Trinket.super.getModifiers(stack, slot, entity, id), stack, FabricUtils.getSlotInfo(slot.inventory().getSlotType(), entity, slot.index()), id);
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
