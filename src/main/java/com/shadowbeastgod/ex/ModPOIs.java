package com.shadowbeastgod.ex;

import com.shadowbeastgod.eternalexsistance.eternalexsistance;
import com.shadowbeastgod.eternalexsistance.modblocks.modblocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, eternalexsistance.Mod_ID);

    public static final RegistryObject<PoiType> GOD_REALM_PORTAL =
            POI.register("gr_portal", () -> new PoiType("gr_portal",
                    PoiType.getBlockStates(modblocks.PORTALSPAWNPLATFORM.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}