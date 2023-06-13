package com.shadowbeastgod.eternalexistence.entities.renderer;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PushAwayEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PushAwayEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PushAwayModel extends AnimatedGeoModel<PushAwayEntity> {
    @Override
    public ResourceLocation getModelLocation(PushAwayEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"geo/push_away.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PushAwayEntity object) {
        return new ResourceLocation(EternalExistence.MOD_ID,"textures/entities/pushaway/push_away.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PushAwayEntity animatable) {
        return null;
    }
}
