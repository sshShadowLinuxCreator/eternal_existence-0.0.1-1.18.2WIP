package com.shadowbeastgod.eternalexistence.Util;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.sk89q.worldedit.extent.InputExtent;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.client.event.InputEvent;

public class ModClientEvents {
    public static class ClientForgeEvents{
        public static void onKeyRegistry(){

        }
        public static void onKeyInput(InputEvent.KeyInputEvent event){
            if(ModKeyBinds.STRUCTURE_JAVA_KEY.consumeClick()){
                Minecraft.getInstance();
            }

        }

    }

}
