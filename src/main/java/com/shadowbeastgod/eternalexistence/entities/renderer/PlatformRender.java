package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PlatformRender<Type extends PlatFormEntity> extends MobRenderer<Type,PlatformModel<Type>> {

    private static final ResourceLocation Texture = new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/platform.png");

    public PlatformRender(EntityRendererProvider.Context pContext) {
        super(pContext, new PlatformModel<>(pContext.bakeLayer(PlatformModel.LAYER_LOCATION)),0);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return Texture;
    }
}
