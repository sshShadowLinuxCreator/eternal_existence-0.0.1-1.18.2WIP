package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.sk89q.worldedit.world.chunk.Chunk;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.io.DataOutput;
import java.io.IOException;
import java.util.*;

public class GrPortal extends BlockEntity {


    private int testTimer = 0;
    private List<Entity> wormlist = new ArrayList<>();

    public GrPortal(BlockPos pPos, BlockState pBlockState) {
        super(ModblockEntities.GRPORTAL.get(), pPos, pBlockState);
    }



    public void addNBT(UUID uuid){

        CompoundTag ct = new CompoundTag();
        ct.putUUID("portal_uuid",uuid);
        this.saveAdditional(ct);


    }

    public boolean testForStructer(BlockPos pPos,GrPortal gp){
        //test for portal being broken
        ServerLevel pLevel = (ServerLevel) gp.level;
        BlockPos bl = new BlockPos(pPos.getX()-8,pPos.getY()-17,pPos.getZ()-8);
        PortalStructure pst = new PortalStructure(pPos);
        Map<BlockPos, BlockState> bMap = pst.portalBuiltStateList(pLevel);
        List<BlockPos> structPos = bMap.keySet().stream().toList();


        int i = 0;
        for(BlockPos bp: structPos){
            BlockPos mp = new BlockPos(bp.getX() + bl.getX(),bp.getY() + bl.getY(),bp.getZ() + bl.getZ());
            BlockState nbs = bMap.get(bp);
            BlockState lbs = pLevel.getBlockState(mp);

            if(nbs != lbs){
                return true;
            }
        }


        return false;

    }

    public void revertStructure(BlockPos pPos, GrPortal gp){

        ServerLevel l = (ServerLevel) gp.level;

        Player p = l.getNearestPlayer((double)pPos.getX(),(double)pPos.getY(),(double)pPos.getZ(), 100.00,true );


        BlockPos bps = new BlockPos(pPos.getX()-8,pPos.getY()-16,pPos.getZ()-8);
        BlockPos bl = new BlockPos(pPos.getX()-8,pPos.getY()-17,pPos.getZ()-8);
        PortalStructure pst = new PortalStructure(bps);
        Map<BlockPos, BlockState> bMap = pst.portalBuiltStateList(l);
        List<BlockPos> structPos = bMap.keySet().stream().toList();

        for (BlockPos bp : structPos){
            BlockPos rps = new BlockPos(bp.getX() + bl.getX(),bp.getY() + bl.getY(),bp.getZ() + bl.getZ());
            if(l.getBlockState(rps)==bMap.get(bp)){
                l.removeBlock(rps,false);
            }
        }
        pst.loadPlatform(l);
    }

    public static <E extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, GrPortal grPortal) {

        /*grPortal.testTimer++;
        if(grPortal.testTimer >= 10) {
            //ToDo create an AABB area around Structure and test for Entities inside
            Vec3 lowestpoint = new Vec3(blockPos.getX()-8,blockPos.getY()-17,blockPos.getZ()-8);
            Vec3 hieghstpoint = new Vec3(blockPos.getX()+9,blockPos.getY()+9,blockPos.getZ()+9);

            AABB aabb = new AABB(lowestpoint,hieghstpoint);
            List<Entity> p = level.getEntities(null,aabb);
            ;
            if (!level.isClientSide && p != null) {

                if (grPortal.testForStructer(blockPos, grPortal)) {
                    grPortal.revertStructure(blockPos, grPortal);
                }

            }
            grPortal.testTimer = 0;
        }*/

        if(!level.isClientSide){
            //testing if living entity is below it
            PortalWormHoleEntity pwhe = new PortalWormHoleEntity(ModEntities.PORTAL_WORMHOLE.get(),level);

            //Structure size 17, 26, 17
            //portal location 8, 17, 8

            Vec3 lowestpoint = new Vec3(blockPos.getX()-1,blockPos.getY()-9,blockPos.getZ()-1);
            Vec3 hieghstpoint = new Vec3(blockPos.getX()+1,blockPos.getY()-3,blockPos.getZ()+1);

            AABB aabb = new AABB(lowestpoint,hieghstpoint);
            List<Entity> le = level.getEntities(null,aabb);



            for(Entity e: le) {
                if (e instanceof LivingEntity && grPortal.wormlist.contains(e)) {
                    grPortal.wormlist.add(e);
                    double ex = e.getX();
                    double ez = e.getZ();
                    pwhe.setPos(new Vec3(ex,blockPos.getY() - 2.1,ez));
                    level.addFreshEntity(pwhe);
                }
            }
        }

    }
}

