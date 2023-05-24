package com.shadowbeastgod.eternalexistence.event;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = EternalExistence.MOD_ID)
public class ModEvents {

    //comands
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){

    }


}
