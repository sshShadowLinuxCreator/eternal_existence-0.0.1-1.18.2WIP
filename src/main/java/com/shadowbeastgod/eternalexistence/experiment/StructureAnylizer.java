package com.shadowbeastgod.eternalexistence.experiment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.items.customitems.ModArmorMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.IGeneratedBlockstate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.json.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StructureAnylizer extends Item {

    BlockPos first_bp = null;
    BlockPos second_bp = null;

    public StructureAnylizer(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        /*String test = pContext.getLevel().getBlockState(pContext.getClickedPos()).toString();
        String bs = test.contains("[")? test.substring(test.indexOf("[")) : test;
        String bn = test.substring(test.indexOf("{")+1,test.indexOf("}"));
        pContext.getPlayer().sendMessage(new TranslatableComponent( "BlockName:" + bn +" BlockState:" + bs),pContext.getPlayer().getUUID());*/



        boolean a = false;
        boolean b = false;


        if (pContext.getLevel().isClientSide) {
            Player player = pContext.getPlayer();
            if (!player.isCrouching()) {
                a = true;
                first_bp = pContext.getClickedPos();
                player.sendMessage(new TranslatableComponent("First block: X[" + first_bp.getX() + " ,Y[" + first_bp.getY() + " ,Z[" + first_bp.getZ()), player.getUUID());
            } else if (player.isCrouching()) {
                b = true;
                second_bp = pContext.getClickedPos();
                player.sendMessage(new TranslatableComponent("Second block: X[" + second_bp.getX() + " ,Y[" + second_bp.getY() + " ,Z[" + second_bp.getZ()), player.getUUID());


                //calcJson(pContext.getLevel(),first_bp,second_bp,player);


            }
        }
        return super.useOn(pContext);
    }

    public void calcJson(Level level, Player player,String Name){
        BlockPos first_bp = this.first_bp;
        BlockPos second_bp = this.second_bp;


        // Iterate over the blocks in the structure
        Iterable<BlockPos> positions = BlockPos.betweenClosed(first_bp, second_bp);

        int xlc = first_bp.getX() < second_bp.getX() ? first_bp.getX() : second_bp.getX();
        int ylc = first_bp.getY() < second_bp.getY() ? first_bp.getY() : second_bp.getY();
        int zlc = first_bp.getZ() < second_bp.getZ() ? first_bp.getZ() : second_bp.getZ();
        BlockPos lowpos = new BlockPos(xlc,ylc,zlc);

        int xhc = first_bp.getX() > second_bp.getX() ? first_bp.getX() : second_bp.getX();
        int yhc = first_bp.getY() > second_bp.getY() ? first_bp.getY() : second_bp.getY();
        int zhc = first_bp.getZ() > second_bp.getZ() ? first_bp.getZ() : second_bp.getZ();
        BlockPos highpose = new BlockPos(xhc,yhc,zhc);

        int height = yhc - ylc, width = xhc - xlc, depth = zhc - zlc;
        Map<String,Integer> dims = new HashMap<>();
        dims.put("height",height);
        dims.put("width",width);
        dims.put("depth",depth);

        int ixj = 0, iyj = 0, izj = 0;

        BlockState[] nameassing = new BlockState[(xhc-xlc)*(yhc-ylc)*(zhc-zlc)];
        char[] label = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int ilabel = 0;
        int iorginize = 0;
        Map<BlockState,Character> blockStateMatcher = new HashMap<>();
        Map<Block,Character> blockMatcher = new HashMap<>();


        char bsmletter[][][] = new char[height][width][depth];
        char bmletter[][][] = new char[height][width][depth];

        if(positions != null) {
            for (BlockPos bp : positions){
                int xsetzero = bp.getX() - xlc;
                int ysetzero = bp.getY() - ylc;
                int zsetzero = bp.getZ() - zlc;
                if(!blockMatcher.containsKey(level.getBlockState(bp).getBlock())) {
                    blockMatcher.put(level.getBlockState(bp).getBlock(),label[ilabel]);
                }
                if(!blockStateMatcher.containsKey(level.getBlockState(bp))){
                    blockStateMatcher.put(level.getBlockState(bp),label[ilabel]);
                }
                ilabel++;
                bsmletter[ysetzero][xsetzero][zsetzero] = blockStateMatcher.get(level.getBlockState(bp));
                bmletter[ysetzero][xsetzero][zsetzero] = blockMatcher.get(level.getBlockState(bp).getBlock());

            }

        }
        Gson gson = new Gson();
        String jsonFormat = gson.toJson(new JsonStructure(positions,blockMatcher,
                blockStateMatcher,dims,level,lowpos));

        String local = "/structure/" + Name +".json";




        try (FileWriter fileWriter = new FileWriter(local)) {
            BufferedWriter w = new BufferedWriter(fileWriter);
            fileWriter.write(jsonFormat);
            player.sendMessage(new TextComponent("Structure data saved to "+Name+".json"), player.getUUID());
        } catch (IOException e) {
            player.sendMessage(new TextComponent("Error saving structure data: " + e.getMessage()), player.getUUID());
        }




    }

    public boolean commandsin(Player player){
        if(this.first_bp == null && this.second_bp !=null){
            player.sendMessage(new TextComponent("need first Position"),player.getUUID());
        } else if (this.second_bp != null&&this.first_bp != null) {
            player.sendMessage(new TextComponent("need Second Position"),player.getUUID());
        }else if(this.first_bp == null && this.second_bp ==null){
            player.sendMessage(new TextComponent("need Both Position"),player.getUUID());
        }
        return this.first_bp != null && this.second_bp != null;
    }


}
