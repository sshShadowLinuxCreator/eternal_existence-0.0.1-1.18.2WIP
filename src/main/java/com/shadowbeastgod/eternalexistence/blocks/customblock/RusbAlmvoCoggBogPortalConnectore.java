package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.RusbAlmvoCoggBogPortalConnectoreEntity;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RusbAlmvoCoggBogPortalConnectore extends BaseEntityBlock {
    private static final VoxelShape SHAPE =  Block.box(0, 0, 0, 16, 18, 16);
    private boolean rp = false;
    private int intest;


    public RusbAlmvoCoggBogPortalConnectore(Properties properties){
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {

        //test for right build

        super.tick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {


        BlockEntity entity = pLevel.getBlockEntity(pPos);
        RusbAlmvoCoggBogPortalConnectoreEntity racbpce = (RusbAlmvoCoggBogPortalConnectoreEntity) entity;


        //test for right dimensions
        boolean inRightWorld = pLevel.dimension() == Level.OVERWORLD || pLevel.dimension() == ModDimensions.EEGR_KEY;
        //test for right item
        boolean rightItem = pPlayer.getHandSlots().iterator().next().sameItem(ModItems.EXISTENCESPARK.get().getDefaultInstance());
        //test for right hand
        boolean rightHand = pHand == InteractionHand.MAIN_HAND;
        //has all test together to initiate the portal animation stuff
        boolean rightSetup = rightHand && rightItem && inRightWorld;






        if(!pLevel.isClientSide){



            boolean doIt = racbpce.rightPlacement(pPos,racbpce);

            if(entity instanceof RusbAlmvoCoggBogPortalConnectoreEntity&& doIt){

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
