package com.shadowbeastgod.eternalexsistance.blocks.customblock;

import com.shadowbeastgod.eternalexsistance.world.godrealmteleportal;
import com.shadowbeastgod.eternalexsistance.world.dimensions.moddimensions;
import io.netty.handler.codec.mqtt.MqttProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class grportalblock extends Block {
    
    public static final IntegerProperty PORTAL = IntegerProperty.create("portal",0,72);

    public grportalblock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PORTAL);
    }




    /*@Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockStateProperties.WEST
        return this.defaultBlockState().setValue();
        //pContext.getLevel().getBlockState().getBlock()
    }*/


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
                    ResourceKey<Level> destination = entity.level.dimension() == moddimensions.EEGR_KEY
                            ? Level.OVERWORLD : moddimensions.EEGR_KEY;
                    if (minecraftserver != null) {
                        ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                        if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                            entity.level.getProfiler().push("gr_portal");
                            entity.setPortalCooldown();
                            entity.changeDimension(destinationWorld, new godrealmteleportal(pos,destinationWorld, entity));
                            entity.level.getProfiler().pop();
                            }

                        }


                    }



                }


            }

        }


    }



