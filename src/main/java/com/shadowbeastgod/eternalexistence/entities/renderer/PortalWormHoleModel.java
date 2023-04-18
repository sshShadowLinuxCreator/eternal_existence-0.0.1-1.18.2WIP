package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PortalWormHoleModel extends AnimatedGeoModel<PortalWormHoleEntity> {
    @Override
    public ResourceLocation getModelLocation(PortalWormHoleEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"geo/portal_wormhole.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PortalWormHoleEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/portalwormhole/portal_wormhole.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PortalWormHoleEntity animatable) {
        return new ResourceLocation(EternalExistence.MOD_ID,"animations/portalwormhole/portal.model.animation.json");
    }
}
