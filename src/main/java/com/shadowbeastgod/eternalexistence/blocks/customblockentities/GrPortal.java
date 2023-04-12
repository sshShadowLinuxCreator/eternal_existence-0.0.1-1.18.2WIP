package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.sk89q.worldedit.world.chunk.Chunk;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class GrPortal extends BlockEntity implements MenuProvider {


    public GrPortal(BlockPos pPos, BlockState pBlockState) {
        super(ModblockEntities.GRPORTAL.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("God Realm Portal Block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }



    public static void addNBT(BlockPos pPos,UUID uuid,BlockState pState){

        CompoundTag ct = new CompoundTag();
        int[] aPos = {pPos.getX(),pPos.getY(),pPos.getZ()};


        ct.putIntArray("portal_blockpos",aPos);
        ct.putString("portal_blockstate",pState.toString());
        ct.putUUID("portal_uuid",uuid);


    }



}

