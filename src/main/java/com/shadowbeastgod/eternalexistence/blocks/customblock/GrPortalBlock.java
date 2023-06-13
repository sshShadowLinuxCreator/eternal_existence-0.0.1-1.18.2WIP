package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.legacy.structure_gel.api.block.GelPortalBlock;
import com.legacy.structure_gel.api.dimension.portal.GelTeleporter;
import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.GrPortal;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalWormHoleEntity;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.shadowbeastgod.eternalexistence.world.GodRealmTeleportal;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.IBlockRenderProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class GrPortalBlock extends BaseEntityBlock {

    private int testTimer = 0;

    public GrPortalBlock(Properties pProperties) {
        super(pProperties);
    }


    //ToDo remove structure on destroy
    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        BlockEntity be = pLevel.getBlockEntity(pPos);
        GrPortal gp = (GrPortal)be;
        if(!pLevel.isClientSide) {
            if(be instanceof GrPortal) {
                gp.revertStructure(pPos, gp);
            }

        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);

    }



    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GrPortal(pPos,pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType,ModblockEntities.GRPORTAL.get(),GrPortal::tick);
    }

    //ToDo create galaxyShader
    //https://www.shadertoy.com/view/MslGWN use this to make it
    //parameter is the shape
    //it'll be slightly transparent
    //instead of time to adjust image use playerCords
    //animate it
    //128x pixels


}



