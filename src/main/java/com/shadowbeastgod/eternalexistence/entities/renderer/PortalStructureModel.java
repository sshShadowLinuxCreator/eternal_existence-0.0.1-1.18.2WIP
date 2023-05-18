package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PortalStructureModel extends AnimatedGeoModel<PortalStructureEntity> {
    @Override
    public ResourceLocation getModelLocation(PortalStructureEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"geo/portal_structure.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PortalStructureEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/portal_structure.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PortalStructureEntity animatable) {
        return new ResourceLocation(EternalExistence.MOD_ID,"animations/portal_structure.animation.json");
    }
}
