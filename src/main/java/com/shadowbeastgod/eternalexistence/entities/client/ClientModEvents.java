package com.shadowbeastgod.eternalexistence.entities.client;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.renderer.PlatformModel;
import com.shadowbeastgod.eternalexistence.entities.renderer.PlatformRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EternalExistence.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private ClientModEvents(){}

    @SubscribeEvent
    public static void  registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(PlatformModel.LAYER_LOCATION,PlatformModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.FLOATING_PLATFORM.get() , PlatformRender::new);
    }

}
