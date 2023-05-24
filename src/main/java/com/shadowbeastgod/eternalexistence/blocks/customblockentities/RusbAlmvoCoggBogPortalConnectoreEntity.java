package com.shadowbeastgod.eternalexistence.blocks.customblockentities;

import com.legacy.structure_gel.api.structure.GelStructurePlacement;
import com.shadowbeastgod.eternalexistence.blocks.ModblockEntities;
import com.shadowbeastgod.eternalexistence.entities.ModEntities;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.shadowbeastgod.eternalexistence.experiment.PortalStructure;
import com.shadowbeastgod.eternalexistence.sound.ModSounds;
import net.minecraft.client.renderer.blockentity.StructureBlockRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StructureBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;

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

    public static void animationBuild(RusbAlmvoCoggBogPortalConnectoreEntity r) {

            BlockPos pPos = r.structurepos;
            Level pLevel = r.level;
            ServerLevel sLevel = (ServerLevel)r.level;
            PortalStructure ps = new PortalStructure(pPos);
            PortalStructureEntity pe = ModEntities.PORTAL_STRUCTURE.get().create(pLevel);
            pe.setPos(new Vec3(pPos.getX(),pPos.getY(),pPos.getZ()));
            if(r.iTickTime==0){
                pLevel.playSound(null,pPos, ModSounds.STRUCTURE_RISING.get(), SoundSource.BLOCKS,100,1);
                pLevel.addFreshEntity(pe);
            } else if (r.iTickTime == 260){
                pe.remove(Entity.RemovalReason.DISCARDED);
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
}
