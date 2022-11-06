package com.shadowbeastgod.eternalexsistance;

import com.mojang.logging.LogUtils;
import com.shadowbeastgod.eternalexsistance.modblocks.customblock.eternalaltar;
import com.shadowbeastgod.eternalexsistance.modblocks.modblockentities;
import com.shadowbeastgod.eternalexsistance.modblocks.modblocks;
import com.shadowbeastgod.eternalexsistance.moditems.moditems;
import com.shadowbeastgod.eternalexsistance.world.moddimensions.moddimensions;
import com.shadowbeastgod.ex.ModPOIs;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.ItemModifierManager;
import net.minecraftforge.client.model.BakedItemModel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(eternalexsistance.Mod_ID)
public class eternalexsistance
{
    public static final String Mod_ID = "eternalexsistance";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public eternalexsistance()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        moditems.register(eventBus);
        modblocks.register(eventBus);
        modblockentities.register(eventBus);

        moddimensions.register();

        ModPOIs.register(eventBus);

        eventBus.addListener(this::setup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent eveny){
        ItemBlockRenderTypes.setRenderLayer(modblocks.ETERNALALTAR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(modblocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(modblocks.GRPORTALBLOCK.get() ,RenderType.translucent());

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(modblocks.GRPORTALBLOCK.get() ,RenderType.translucent());
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
