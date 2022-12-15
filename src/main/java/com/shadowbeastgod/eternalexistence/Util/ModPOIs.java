package com.shadowbeastgod.eternalexistence.Util;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, EternalExistence.MOD_ID);

    public static final RegistryObject<PoiType> GOD_REALM_PORTAL =
            POI.register("gr_portal", () -> new PoiType("gr_portal",
                    PoiType.getBlockStates(ModBlocks.PORTALSPAWNPLATFORM.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}