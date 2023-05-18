package com.shadowbeastgod.eternalexistence.sound;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EternalExistence.MOD_ID);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(EternalExistence.MOD_ID, name)));
    }

    public static final RegistryObject<SoundEvent> STRUCTURE_RISING =
            registerSoundEvent("structure_rising");

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
