package com.shadowbeastgod.eternalexistence;

import com.mojang.logging.LogUtils;
import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import com.shadowbeastgod.eternalexistence.recipes.ModRecipes;
import com.shadowbeastgod.eternalexistence.screen.EternalAltarScreen;
import com.shadowbeastgod.eternalexistence.screen.ModMenuTypes;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import com.shadowbeastgod.eternalexistence.Util.ModPOIs;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EternalExistence.MOD_ID)
public class EternalExistence
{
    public static final String MOD_ID = "eternalexistence";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EternalExistence()
    {
        //(1) has structure for boss fight and laboratory
        //ToDo add lore
        //ToDo Bosses: Laboratory Gollum, Lucon (demon + hell hound with synth )
        //ToDo monsters
        //ToDo Creatures
        //ToDo Forgotten People
        //ToDo new Portal models
        //ToDo terrain generation to make: dripping lands, destroy lands, the void, mirror lands
        //ToDo Create Terrain Generation, Create Bosses, Create Tier Weapons,Implement{Tinkers Construct, Patchouli,Crafting Tweaks,TheOneProb}

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModblockEntities.register(eventBus);

        ModEntities.register(eventBus);

        ModDimensions.register();

        ModPOIs.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        GeckoLib.initialize();



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent eveny){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ETERNALALTAR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRPORTALBLOCK.get() ,RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTAL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EIGTHPORTALSTURUCTURE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PORTALPILLAR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ESUL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ESUL.get(), RenderType.cutout());

        MenuScreens.register(ModMenuTypes.ETERNAL_ALTAR_MENU.get(), EternalAltarScreen::new);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.ESUL.getId(), ModBlocks.POTTED_ESUL);
        });


    }
}
