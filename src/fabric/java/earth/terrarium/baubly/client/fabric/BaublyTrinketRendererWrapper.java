package earth.terrarium.baubly.client.fabric;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import earth.terrarium.baubly.client.BaubleRenderer;
import earth.terrarium.baubly.fabric.FabricUtils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public record BaublyTrinketRendererWrapper(BaubleRenderer renderer) implements TrinketRenderer {
    @Override
    public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        renderer.render(itemStack, FabricUtils.getSlotInfo(slotReference.inventory().getSlotType(), livingEntity, slotReference.index()), poseStack, entityModel, multiBufferSource, i, v, v1, v2, v3, v4, v5);
    }
}
