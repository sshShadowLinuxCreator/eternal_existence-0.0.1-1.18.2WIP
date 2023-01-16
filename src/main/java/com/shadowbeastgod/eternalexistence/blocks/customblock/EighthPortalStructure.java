package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class EighthPortalStructure extends Block {

    protected static final VoxelShape DEFAULT = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

    public EighthPortalStructure(Properties pProperties) {
        super(pProperties);

    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return DEFAULT;
    }
}
