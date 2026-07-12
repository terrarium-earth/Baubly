package earth.terrarium.baubly.client;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.baubly.common.SlotInfo;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface BaubleRenderer {

    void render(ItemStack stack,
                SlotInfo slotContext,
                PoseStack matrixStack,
                EntityModel<? extends LivingEntity> entityModel,
                MultiBufferSource renderTypeBuffer,
                int light, float limbSwing,
                float limbSwingAmount,
                float partialTicks,
                float ageInTicks, float netHeadYaw,
                float headPitch);
}
