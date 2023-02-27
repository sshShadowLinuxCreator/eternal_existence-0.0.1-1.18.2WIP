package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PortalplatformSpawn extends Block {

    //used for teleporting to right platform
    int platformID;

    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 32, 7, 32);

    public PortalplatformSpawn(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE.move(-.5,0,-.5);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        PlatFormEntity pe = new PlatFormEntity(ModEntities.FLOATING_PLATFORM.get(),pLevel);
        pe.setPos(Vec3.atCenterOf(pPos));

        pLevel.addFreshEntity(pe);
    }
}
