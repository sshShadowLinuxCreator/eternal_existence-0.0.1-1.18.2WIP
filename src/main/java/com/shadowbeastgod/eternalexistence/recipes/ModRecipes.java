package com.shadowbeastgod.eternalexistence.recipes;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EternalExistence.MOD_ID);

    public static final RegistryObject<RecipeSerializer<EternalAltarRecipe>> ETERNAL_ALTAR_SERIALIZER =
            SERIALIZER.register("eternal_altar_recipe",()->EternalAltarRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<EternalAltarManaRecipe>> ETERNAL_ALTAR_ENERGY_SERIALIZER =
            SERIALIZER.register("eternal_altar_mana_recipe",()->EternalAltarManaRecipe.Serializer.INSTANCE);



    public static void register(IEventBus eventBus){
        SERIALIZER.register(eventBus);
    }
}
