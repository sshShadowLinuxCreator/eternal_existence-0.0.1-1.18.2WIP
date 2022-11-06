package com.shadowbeastgod.eternalexsistance.world.modbiomes;

import com.shadowbeastgod.eternalexsistance.experiment.portalStructure;
import com.shadowbeastgod.ex.ModPOIs;
import net.minecraft.BlockUtil;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Comparator;
import java.util.Optional;

public class godrealmteleportal implements ITeleporter {
    public static ServerLevel level = null;

    public godrealmteleportal(ServerLevel level) {
        this.level = level;
    }
    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pos, Direction.Axis axis) {
        portalStructure.build(pos,false);

        return Optional.of(new BlockUtil.FoundRectangle(pos.immutable(), 10, 10));
    }
    public Optional<BlockUtil.FoundRectangle> getExistingPortal(BlockPos pos) {
        PoiManager poiManager = this.level.getPoiManager();
        poiManager.ensureLoadedAndValid(this.level, pos, 64);
        Optional<PoiRecord> optional = poiManager.getInSquare((poiType) ->
                poiType == ModPOIs.GOD_REALM_PORTAL.get(), pos, 64, PoiManager.Occupancy.ANY).sorted(Comparator.<PoiRecord>comparingDouble((poi) ->
                poi.getPos().distSqr(pos)).thenComparingInt((poi) ->
                poi.getPos().getY())).filter((poi) ->
                this.level.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.AXIS)).findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.level.getBlockState(blockpos);
            return BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) ->
                    this.level.getBlockState(posIn) == blockstate);
        });
    }

}
