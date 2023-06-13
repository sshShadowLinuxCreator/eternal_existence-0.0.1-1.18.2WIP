package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PushAwayEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PushAwayRender extends GeoEntityRenderer<PushAwayEntity> {
    public PushAwayRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PushAwayModel());
        this.shadowRadius = 0;

    }



    @Override
    public ResourceLocation getTextureLocation(PushAwayEntity animatable) {
        return new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/pushaway/push_away.png");
    }


    //ToDO animate Texture
    @Override
    public RenderType getRenderType(PushAwayEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        poseStack.scale(8,2,8);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);


    }

}
