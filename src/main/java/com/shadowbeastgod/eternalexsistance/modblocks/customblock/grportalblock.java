package com.shadowbeastgod.eternalexsistance.modblocks.customblock;

import com.shadowbeastgod.eternalexsistance.modblocks.modblocks;
import com.shadowbeastgod.eternalexsistance.world.modbiomes.godrealmteleportal;
import com.shadowbeastgod.eternalexsistance.world.moddimensions.moddimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class grportalblock extends Block {


    public grportalblock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity) {
        if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
            if (entity.isOnPortalCooldown()) {
                entity.setPortalCooldown();}


                else{

                    if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
                        entity.portalEntrancePos = pos.immutable();
                    }
                    Level entityWorld = entity.level;
                    if (entityWorld != null) {
                        MinecraftServer minecraftserver = entityWorld.getServer();
                        ResourceKey<Level> destination = entity.level.dimension() == moddimensions.EEGR_KEY
                                ? Level.OVERWORLD : moddimensions.EEGR_KEY;
                        if (minecraftserver != null) {
                            ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                            if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                                entity.level.getProfiler().push("gr_portal");
                                entity.setPortalCooldown();
                                entity.changeDimension(destinationWorld, new godrealmteleportal(destinationWorld));
                                entity.level.getProfiler().pop();
                            }
                        }


                    }


                }
            }


        }

    public static BlockState updateFromNeighbourShapes(BlockState pCurrentState, LevelAccessor pLevel, BlockPos pPos) {

        char[][] btportal= {
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'}
        };
        char[][] mportal={
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','F','#','#','#','#','#','F','#','#'},
                {'#','#','#','F','#','#','#','F','#','#','#'},
                {'#','#','#','#','F','F','F','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'},
                {'#','#','#','#','#','#','#','#','#','#','#'}
        };

        boolean checked = false;
        for(Direction direction : UPDATE_SHAPE_ORDER) {
            while (!checked) {
                int x = 0;
                int y = 0;
                int z = 0;
                int variant = 0;
                String var = ("model:"+variant);
                BlockPos pc = pLevel.


                if (y>=1 && y<=3 && btportal[x][z]=='F'){

                }
                x++;
                if (x==10){
                    x=0;
                    z++;
                    if(z==10){
                        x=0;
                        z=0;
                        y++;
                        if(y==5){
                            checked = true;
                        }

                    }
                }

            }
        }
        BlockState blockstate = pCurrentState;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(Direction direction : UPDATE_SHAPE_ORDER) {
            blockpos$mutableblockpos.setWithOffset(pPos, direction);
            blockstate = blockstate.updateShape(direction, pLevel.getBlockState(blockpos$mutableblockpos), pLevel, pPos, blockpos$mutableblockpos);
        }

        return blockstate;
    }

    public static void updateOrDestroy(BlockState pOldState, BlockState pNewState, LevelAccessor pLevel, BlockPos pPos, int pFlags) {
        updateOrDestroy(pOldState, pNewState, pLevel, pPos, pFlags, 512);
    }
    public static void updateOrDestroy(BlockState pOldState, BlockState pNewState, LevelAccessor pLevel, BlockPos pPos, int pFlags, int pRecursionLeft) {
        if (pNewState != pOldState) {
            if (pNewState.isAir()) {
                if (!pLevel.isClientSide()) {
                    pLevel.destroyBlock(pPos, (pFlags & 32) == 0, (Entity)null, pRecursionLeft);
                }
            } else {
                pLevel.setBlock(pPos, pNewState, pFlags & -33, pRecursionLeft);
            }
        }

    }

}
