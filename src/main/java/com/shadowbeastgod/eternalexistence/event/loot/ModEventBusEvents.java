package com.shadowbeastgod.eternalexistence.event.loot;


import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarEnergyRecipe;
import com.shadowbeastgod.eternalexistence.recipes.EternalAltarRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EternalExistence.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event){
        Registry.register(Registry.RECIPE_TYPE, EternalAltarRecipe.Type.ID, EternalAltarRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, EternalAltarEnergyRecipe.Type.ID, EternalAltarEnergyRecipe.Type.INSTANCE);
    }
}
