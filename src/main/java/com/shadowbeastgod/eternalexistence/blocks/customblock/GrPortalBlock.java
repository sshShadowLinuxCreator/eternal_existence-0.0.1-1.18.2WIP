package com.shadowbeastgod.eternalexistence.blocks.customblock;

import com.shadowbeastgod.eternalexistence.world.GodRealmTeleportal;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.TerrainShaper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public class GrPortalBlock extends Block {

    BlockState bs;
    public static final IntegerProperty PORTAL = IntegerProperty.create("portal",0,72);



    public GrPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PORTAL);
    }



    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, @NotNull Entity entity) {
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
                    ResourceKey<Level> destination = entity.level.dimension() == ModDimensions.EEGR_KEY
                            ? Level.OVERWORLD : ModDimensions.EEGR_KEY;
                    if (minecraftserver != null) {
                        ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                        if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                            entity.level.getProfiler().push("gr_portal");
                            entity.setPortalCooldown();
                            entity.changeDimension(destinationWorld, new GodRealmTeleportal(pos,destinationWorld, entity));
                            entity.level.getProfiler().pop();
                            }

                        }


                    }



                }


            }

        }
}



