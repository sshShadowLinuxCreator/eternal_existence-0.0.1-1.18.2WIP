package com.shadowbeastgod.eternalexistence.world;

import com.legacy.structure_gel.api.block.GelPortalBlock;
import com.legacy.structure_gel.api.dimension.portal.GelTeleporter;
import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.experiment.CubeUtil;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class GodRealmTeleportal implements ITeleporter {
    public static ServerLevel level = null;
    //public static BlockPos plat;

    public GodRealmTeleportal(BlockPos bpos, ServerLevel level, Entity entity) {
        PortalStructure ps = new PortalStructure(bpos);
        ps.loadFinishStructure(level);
    }




    public Optional<CubeUtil.foundCube> makePortal(BlockPos pos, Direction.Axis axis) {
        //PortalStructureEntity.portalbuild(pos,false);

        return Optional.of(new CubeUtil.foundCube(pos.immutable(),pos.immutable(), 10, 10, 10));
    }


    /*@Override
    @Nullable
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo)
    {
        Vec3 v = new Vec3(plat.getX()-5.5, plat.getY(), plat.getZ()-5.5);
        return new PortalInfo(v, Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }*/


}
