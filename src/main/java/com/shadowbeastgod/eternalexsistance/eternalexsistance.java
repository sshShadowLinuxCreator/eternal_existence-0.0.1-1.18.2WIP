package com.shadowbeastgod.eternalexsistance;

import com.mojang.logging.LogUtils;
import com.shadowbeastgod.eternalexsistance.blocks.modblockentities;
import com.shadowbeastgod.eternalexsistance.blocks.modblocks;
import com.shadowbeastgod.eternalexsistance.items.moditems;
import com.shadowbeastgod.eternalexsistance.world.dimensions.moddimensions;
import com.shadowbeastgod.eternalexsistance.Util.ModPOIs;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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
