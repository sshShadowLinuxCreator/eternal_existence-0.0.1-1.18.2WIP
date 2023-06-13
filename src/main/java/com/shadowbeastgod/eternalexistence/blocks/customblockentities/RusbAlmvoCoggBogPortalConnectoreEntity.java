package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.legacy.structure_gel.api.structure.GelStructurePlacement;
import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.shadowbeastgod.eternalexistence.sound.ModSounds;
import net.minecraft.client.renderer.blockentity.StructureBlockRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StructureBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RusbAlmvoCoggBogPortalConnectoreEntity extends BlockEntity {
    private int iTickTime = 0;
    private boolean build = false;
    private BlockPos structurepos;

    public RusbAlmvoCoggBogPortalConnectoreEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModblockEntities.RUSBALMVOCOGGBOGPORTALCONNECTORE.get(), pPos, pBlockState);
    }

    public void structure(boolean start, BlockPos blockPos){
        this.structurepos = blockPos;
        this.build = start;

    }

//ToDo work on animation{push away entity, magic circle, portal structure particles}
    public static void animationBuild(RusbAlmvoCoggBogPortalConnectoreEntity r) {

            BlockPos pPos = r.structurepos;
            Level pLevel = r.level;
            ServerLevel sLevel = (ServerLevel)r.level;
            Vec3 v3 = Vec3.atBottomCenterOf(pPos);
            PortalStructure ps = new PortalStructure(pPos.offset(-25,-26,-25));
            PortalStructureEntity pe = ModEntities.PORTAL_STRUCTURE.get().create(pLevel);
            pe.setPos(v3);
            if(r.iTickTime==0){
                pLevel.playSound(null,pPos, ModSounds.STRUCTURE_RISING.get(), SoundSource.BLOCKS,10,1);
                pLevel.addFreshEntity(pe);
            } else if (r.iTickTime == 260){
                ps.loadFinishStructure(sLevel);
                r.iTickTime = 0;
                r.build = false;
            }
            r.iTickTime++;



    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, RusbAlmvoCoggBogPortalConnectoreEntity pBlockEntity) {
        if (pBlockEntity.build){
            animationBuild(pBlockEntity);
        }

    }



    public boolean rightPlacement(BlockPos pPos, RusbAlmvoCoggBogPortalConnectoreEntity rusbAlmvoCoggBogPortalConnectoreEntity){
        boolean rp = false;
        ServerLevel pLevel = (ServerLevel) rusbAlmvoCoggBogPortalConnectoreEntity.level;

        PortalStructure ps = new PortalStructure(pPos);
        Map<BlockPos, BlockState> struct = ps.portalPlatformStateList(pLevel);
        List<BlockPos> lbp = struct.keySet().stream().toList();
        BlockPos wbp = new BlockPos(pPos.getX() - 8, pPos.getY() - 1, pPos.getZ() - 8);
        //32 -10 88
        int i = 0;

        for (BlockPos bp : lbp) {
            BlockPos serverbp = new BlockPos(bp.getX() + wbp.getX(), bp.getY() + wbp.getY(), bp.getZ() + wbp.getZ());
            BlockState wbs = pLevel.getBlockState(serverbp);
            BlockState nbs = struct.get(bp);
            if (wbs == nbs) {
                i++;
            }

        }

        if (i == struct.size()) {
            rp = true;
        }


        return rp;
    }



}
