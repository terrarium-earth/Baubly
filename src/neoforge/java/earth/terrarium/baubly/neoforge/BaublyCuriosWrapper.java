package earth.terrarium.baubly.neoforge;

import com.google.common.collect.Multimap;
import earth.terrarium.baubly.common.Bauble;
import earth.terrarium.baubly.common.DropRule;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public record BaublyCuriosWrapper(Bauble bauble) implements ICurioItem {
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        bauble.tick(stack, ForgeUtils.getSlotInfo(slotContext));
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        bauble.onEquip(stack, ForgeUtils.getSlotInfo(slotContext));
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        bauble.onUnequip(stack, ForgeUtils.getSlotInfo(slotContext));
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return bauble.canEquip(stack, ForgeUtils.getSlotInfo(slotContext));
    }

    @Override
    public boolean canUnequip(SlotContext slotContext, ItemStack stack) {
        return bauble.canUnequip(stack, ForgeUtils.getSlotInfo(slotContext));
    }

    @Override
    public void curioBreak(SlotContext slotContext, ItemStack stack) {
        bauble.onBreak(stack, ForgeUtils.getSlotInfo(slotContext));
    }


    @NotNull
    @Override
    public ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, boolean recentlyHit, ItemStack stack) {
        DropRule dropRule = bauble.getDropRule(stack, ForgeUtils.getSlotInfo(slotContext));
        return switch (dropRule) {
            case ALWAYS_KEEP -> ICurio.DropRule.ALWAYS_KEEP;
            case DESTROY -> ICurio.DropRule.DESTROY;
            case ALWAYS_DROP -> ICurio.DropRule.ALWAYS_DROP;
            case DEFAULT -> ICurio.DropRule.DEFAULT;
        };
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        return bauble.getModifiers(ICurioItem.super.getAttributeModifiers(slotContext, id, stack), stack, ForgeUtils.getSlotInfo(slotContext), id);
    }
}
