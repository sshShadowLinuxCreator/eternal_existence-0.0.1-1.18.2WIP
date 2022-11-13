package com.shadowbeastgod.eternalexsistance.blocks.customblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class rusbalmvocoggbogportalconnectore extends Block {

    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 16, 32, 16);

    public rusbalmvocoggbogportalconnectore(Properties properties){
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }


}
