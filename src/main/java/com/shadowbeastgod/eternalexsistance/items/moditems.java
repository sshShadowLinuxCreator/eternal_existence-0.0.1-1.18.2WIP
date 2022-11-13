package com.shadowbeastgod.eternalexsistance.items;

import com.shadowbeastgod.eternalexsistance.eetabs;
import com.shadowbeastgod.eternalexsistance.eternalexsistance;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, eternalexsistance.Mod_ID);
    public static final RegistryObject<Item> RAWWAKARANAI = ITEMS.register("raw_wakaranai",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_ores)));
    public static final RegistryObject<Item> WAKARANAIINGOT = ITEMS.register("wakaranai_ingot",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_ores)));
    public static final RegistryObject<Item> WAKARANAISWORD = ITEMS.register("wakaranai_sword",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_weapons)));

    public static final RegistryObject<Item> WAKARANAIPICKAXE = ITEMS.register("wakaranai_pickaxe",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_tools)));
    public static final RegistryObject<Item> WAKARANAIAXE = ITEMS.register("wakaranai_axe",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_tools)));
    public static final RegistryObject<Item> WAKARANAIHOE = ITEMS.register("wakaranai_hoe",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_tools)));
    public static final RegistryObject<Item> WAKARANAISHOVEL = ITEMS.register("wakaranai_shovel",
            () -> new Item(new Item.Properties().tab(eetabs.eternalexsistance_tools)));


    public static void register(IEventBus eventBus){ITEMS.register(eventBus);
    }
}
