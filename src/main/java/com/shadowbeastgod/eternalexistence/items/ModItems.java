package com.shadowbeastgod.eternalexistence.items;

import com.shadowbeastgod.eternalexistence.EeTabs;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.items.armor.WakaranaiArmorItem;
import com.shadowbeastgod.eternalexistence.items.customitems.ModArmorMaterials;
import com.shadowbeastgod.eternalexistence.items.sword.WakaranaiSword;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EternalExistence.MOD_ID);
    public static final RegistryObject<Item> RAWWAKARANAI = ITEMS.register("raw_wakaranai",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));
    public static final RegistryObject<Item> WAKARANAIINGOT = ITEMS.register("wakaranai_ingot",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));

    public static final RegistryObject<Item> RAWSUMMAVI = ITEMS.register("raw_summa_vi",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));
    public static final RegistryObject<Item> SUMMAVIINGOT = ITEMS.register("summa_vi_ingot",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));

    public static final RegistryObject<Item> RAWANOTATOS = ITEMS.register("raw_anotatos",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));
    public static final RegistryObject<Item> ANOTATOSINGOT = ITEMS.register("anotatos_ingot",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_ores)));
    public static final RegistryObject<Item> WAKARANAISWORD = ITEMS.register("wakaranai_sword",
            () -> new WakaranaiSword(ModTiers.WAKARANAI, 5, 5f,
                    new Item.Properties().tab(EeTabs.eternalexistence_weapons).stacksTo(1)));
    public static final RegistryObject<Item> WAKARANAISWORDTE = ITEMS.register("wakaranai_sword_teir_2",
            () -> new WakaranaiSword(ModTiers.WAKARANAI, 10, 5f,
                    new Item.Properties().tab(EeTabs.eternalexistence_weapons).stacksTo(1)));
    public static final RegistryObject<Item> SUMMAVIISWORD = ITEMS.register("summa_vi_sword",
            () -> new SwordItem(ModTiers.SUMMAVI, 5 , 4f,
                    new Item.Properties().tab(EeTabs.eternalexistence_weapons).stacksTo(1)));
    public static final RegistryObject<Item> ANOTATOSSWORD = ITEMS.register("anotatos_sword",
            () -> new SwordItem(ModTiers.ANOTATOS, 20, 5f,
                    new Item.Properties().tab(EeTabs.eternalexistence_weapons).stacksTo(1)));
    public static final RegistryObject<Item> SAWSYCTH = ITEMS.register("saw_sycth",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_weapons).stacksTo(1)));

    public static final RegistryObject<Item> WAKARANAIPICKAXE = ITEMS.register("wakaranai_pickaxe",
            () -> new PickaxeItem(ModTiers.WAKARANAI, 4,2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> WAKARANAIAXE = ITEMS.register("wakaranai_axe",
            () -> new AxeItem(ModTiers.WAKARANAI, 4,2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> WAKARANAIHOE = ITEMS.register("wakaranai_hoe",
            () -> new HoeItem(ModTiers.WAKARANAI, 4,2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> WAKARANAISHOVEL = ITEMS.register("wakaranai_shovel",
            () -> new ShovelItem(ModTiers.WAKARANAI, 4,2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));

    public static final RegistryObject<Item> SUMMAVIAXE = ITEMS.register("summa_vi_axe",
            () -> new AxeItem(ModTiers.SUMMAVI, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> SUMMAVIPICKAXE = ITEMS.register("summa_vi_pickaxe",
            () -> new PickaxeItem(ModTiers.SUMMAVI, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> SUMMAVIHOE = ITEMS.register("summa_vi_hoe",
            () -> new HoeItem(ModTiers.SUMMAVI, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> SUMMAVISHOVEL = ITEMS.register("summa_vi_shovel",
            () -> new ShovelItem(ModTiers.SUMMAVI, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));

    public static final RegistryObject<Item> ANOTATOSPICKAXE = ITEMS.register("anotatos_pickaxe",
            () -> new PickaxeItem(ModTiers.ANOTATOS, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> ANOTATOSAXE = ITEMS.register("anotatos_axe",
            () -> new AxeItem(ModTiers.ANOTATOS, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> ANOTATOSHOE = ITEMS.register("anotatos_hoe",
            () -> new HoeItem(ModTiers.ANOTATOS, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));
    public static final RegistryObject<Item> ANOTATOSSHOVEL = ITEMS.register("anotatos_shovel",
            () -> new ShovelItem(ModTiers.ANOTATOS, 4, 2f,
                    new Item.Properties().tab(EeTabs.eternalexistence_tools)));

    public static final RegistryObject<Item> EXISTENCESPARK = ITEMS.register("existence_spark",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_tools).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> existenceTABLET = ITEMS.register("existence_tablet",
            () -> new Item(new Item.Properties().tab(EeTabs.eternalexistence_tools).stacksTo(16).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> WAKARANAI_HELMET= ITEMS.register("wakaranai_helmet",
            () -> new WakaranaiArmorItem(ModArmorMaterials.WAKARANAI, EquipmentSlot.HEAD,
                    new Item.Properties().tab(EeTabs.eternalexistence_armor).stacksTo(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WAKARANAI_CESTPLATE = ITEMS.register("wakaranai_chestplate",
            () -> new ArmorItem(ModArmorMaterials.WAKARANAI, EquipmentSlot.CHEST,
                    new Item.Properties().tab(EeTabs.eternalexistence_armor).stacksTo(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WAKARANAI_LEGGINGS= ITEMS.register("wakaranai_leggings",
            () -> new ArmorItem(ModArmorMaterials.WAKARANAI, EquipmentSlot.LEGS,
                    new Item.Properties().tab(EeTabs.eternalexistence_armor).stacksTo(16).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> WAKARANAI_BOOTS= ITEMS.register("wakaranai_boots",
            () -> new ArmorItem(ModArmorMaterials.WAKARANAI, EquipmentSlot.FEET,
                    new Item.Properties().tab(EeTabs.eternalexistence_armor).stacksTo(16).rarity(Rarity.RARE)));




    public static void register(IEventBus eventBus){ITEMS.register(eventBus);
    }
}
