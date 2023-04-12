package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PlatFormEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PortalplatformSpawn extends Block {

    private int cd = 0;
    private Vec3i initspawn = new Vec3i(0,.5,1);

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


        if(this.cd == 60) {
            pe.setPos(new Vec3(pEntity.getX(),pPos.getY() + this.SHAPE.bounds().maxY, pEntity.getZ()));
            pLevel.addFreshEntity(pe);
            pe.setRidindEntity(pEntity);
        }
        else if(this.cd >= 65) {
            this.cd = 0;
        }
        this.cd++;

        System.out.println(this.cd);
    }
}
