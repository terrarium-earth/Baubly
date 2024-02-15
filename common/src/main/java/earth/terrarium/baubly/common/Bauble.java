package earth.terrarium.baubly.common;

import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.UUID;

public interface Bauble {
    default void tick(ItemStack stack, SlotInfo slot) {
    }

    default void onEquip(ItemStack stack, SlotInfo slot) {
    }

    default void onUnequip(ItemStack stack, SlotInfo slot) {
    }

    default boolean canEquip(ItemStack stack, SlotInfo slot) {
        return true;
    }

    default boolean canUnequip(ItemStack stack, SlotInfo slot) {
        return !EnchantmentHelper.hasBindingCurse(stack);
    }

    default void onBreak(ItemStack stack, SlotInfo slot) {
        slot.wearer().breakItem(stack);
    }

    default DropRule getDropRule(ItemStack stack, SlotInfo slot) {
        return DropRule.DEFAULT;
    }

    default Multimap<Attribute, AttributeModifier> getModifiers(Multimap<Attribute, AttributeModifier> defaultModifiers, ItemStack stack, SlotInfo slot, UUID uuid) {
        return defaultModifiers;
    }
}
