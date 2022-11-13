package com.shadowbeastgod.eternalexsistance.blocks.customblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class portalplatformspawn extends Block {

    //used for teleporting to right platform
    int platformID;

    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 32, 7, 32);

    public portalplatformspawn(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE.move(-.5,0,-.5);
    }


}
