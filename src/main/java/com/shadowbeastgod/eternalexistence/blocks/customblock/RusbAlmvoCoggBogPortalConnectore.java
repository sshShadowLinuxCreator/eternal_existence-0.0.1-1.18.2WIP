package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.RusbAlmvoCoggBogPortalConnectoreEntity;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class RusbAlmvoCoggBogPortalConnectore extends BaseEntityBlock {
    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 16, 18, 16);


    public RusbAlmvoCoggBogPortalConnectore(Properties properties){
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        boolean inRightWorld = pLevel.dimension() == Level.OVERWORLD || pLevel.dimension() == ModDimensions.EEGR_KEY;

        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND&&inRightWorld){
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof RusbAlmvoCoggBogPortalConnectoreEntity){
                RusbAlmvoCoggBogPortalConnectoreEntity racbpce = (RusbAlmvoCoggBogPortalConnectoreEntity) entity;
                racbpce.structure(true,pPos);
            }

        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RusbAlmvoCoggBogPortalConnectoreEntity(pPos,pState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModblockEntities.RUSBALMVOCOGGBOGPORTALCONNECTORE.get(),RusbAlmvoCoggBogPortalConnectoreEntity::tick);
    }

}
