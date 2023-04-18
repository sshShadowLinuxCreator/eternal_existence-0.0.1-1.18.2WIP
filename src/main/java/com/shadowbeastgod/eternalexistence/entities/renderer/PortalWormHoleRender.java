package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PortalWormHoleRender extends GeoEntityRenderer<PortalWormHoleEntity> {
    //AnimatedGeoModel<PortalWormHoleEntity> modelProvider
    public PortalWormHoleRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PortalWormHoleModel());
        this.shadowRadius =0;

    }

    @Override
    public ResourceLocation getTextureLocation(PortalWormHoleEntity animatable) {
        return new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/portalwormhole/portal_wormhole.png");
    }

    @Override
    public RenderType getRenderType(PortalWormHoleEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer,
                                    int packedLight, ResourceLocation texture) {
        poseStack.scale(1,1,1);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }

    @Override
    protected int getBlockLightLevel(PortalWormHoleEntity pEntity, BlockPos pPos) {
        return 5;
    }
}
