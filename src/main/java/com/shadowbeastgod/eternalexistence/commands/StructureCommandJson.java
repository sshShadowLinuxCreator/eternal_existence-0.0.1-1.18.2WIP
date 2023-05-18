package com.shadowbeastgod.eternalexistence.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.shadowbeastgod.eternalexistence.experiment.StructureAnylizer;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.synchronization.ArgumentTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class StructureCommandJson {
    StructureAnylizer sa;
    Player pr;

    public StructureCommandJson(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("createjsonstructure").requires((context)->{
            Player p = null;
            try {
                p = context.getPlayerOrException().connection.getPlayer();
                pr = p;
            } catch (CommandSyntaxException e) {
                throw new RuntimeException(e);
            }
            Item tool = p.getMainHandItem().getItem() == ModItems.ANYLIST_STRUCTUR.get()? p.getMainHandItem().getItem():null;
            StructureAnylizer a = (StructureAnylizer) tool;
            sa = a;
            return a.commandsin(p);
        }).then(Commands.argument("name", StringArgumentType.string()))
                        .executes((command)->{
            return commandJson(pr.level,pr,StringArgumentType.getString(command,"name"));
                })

        );

    }

    private int commandJson(Level level, Player player,String name){
        sa.calcJson(level,player,name);
        return 0;
    }

}
