package com.shadowbeastgod.eternalexistence.entities;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;

import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import com.shadowbeastgod.eternalexistence.entities.customentities.PushAwayEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {


    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, EternalExistence.MOD_ID);

    public static final RegistryObject<EntityType<PlatFormEntity>> FLOATING_PLATFORM =
            ENTITIES.register("platform",()-> EntityType.Builder.of(
                    PlatFormEntity::new, MobCategory.AMBIENT)
                    .sized(1,.125f)
                    .build(new ResourceLocation(EternalExistence.MOD_ID,"platform").toString()));

    public static final RegistryObject<EntityType<PortalWormHoleEntity>> PORTAL_WORMHOLE =
            ENTITIES.register("portal_wormhole",()-> EntityType.Builder.of(
                            PortalWormHoleEntity::new, MobCategory.AMBIENT)
                    .sized(1.125f,.2f)
                    .build(new ResourceLocation(EternalExistence.MOD_ID,"portal_wormhole").toString()));

    public static final RegistryObject<EntityType<PortalStructureEntity>> PORTAL_STRUCTURE =
            ENTITIES.register("portal_structure",()-> EntityType.Builder.of(
                            PortalStructureEntity::new, MobCategory.AMBIENT)
                    .sized(1,.125f)
                    .build(new ResourceLocation(EternalExistence.MOD_ID,"platform").toString()));

    public static final RegistryObject<EntityType<PushAwayEntity>> PUSH_AWAY =
            ENTITIES.register("push_away",()-> EntityType.Builder.of(
                            PushAwayEntity::new, MobCategory.AMBIENT)
                    .sized(19,2)
                    .build(new ResourceLocation(EternalExistence.MOD_ID,"push_away").toString()));

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
