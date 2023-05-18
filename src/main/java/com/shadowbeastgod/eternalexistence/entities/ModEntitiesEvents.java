package com.shadowbeastgod.eternalexistence.entities;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EternalExistence.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitiesEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.FLOATING_PLATFORM.get(), PlatFormEntity.createAttributes().build());
        event.put(ModEntities.PORTAL_WORMHOLE.get(), PortalWormHoleEntity.createAttributes().build());
        event.put(ModEntities.PORTAL_STRUCTURE.get(), PortalStructureEntity.createAttributes().build());
    }

}
