package com.shadowbeastgod.eternalexistence.Util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.UUID;

public class PortalNBT {



    public static void addNBT(BlockPos pPos, UUID uuid, BlockState pState,CompoundTag pTag){



        int[] aPos = {pPos.getX(),pPos.getY(),pPos.getZ()};

        pTag.putIntArray("portal_blockpos",aPos);
        pTag.putString("portal_blockstate",pState.toString());
        pTag.putUUID("portal_uuid",uuid);



    }
}
