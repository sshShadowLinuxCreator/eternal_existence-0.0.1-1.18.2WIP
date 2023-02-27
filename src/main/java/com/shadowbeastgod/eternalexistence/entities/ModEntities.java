package com.shadowbeastgod.eternalexistence.entities;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
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
                    .sized(1,1)
                    .build(new ResourceLocation(EternalExistence.MOD_ID,"platform").toString()));

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
