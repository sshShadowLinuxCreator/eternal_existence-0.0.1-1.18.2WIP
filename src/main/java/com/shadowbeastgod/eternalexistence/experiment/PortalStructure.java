package com.shadowbeastgod.eternalexistence.experiment;

import com.legacy.structure_gel.api.structure.GelStructurePlacement;
import com.legacy.structure_gel.core.structure.GelTemplate;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.ResourceLocationException;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class PortalStructure {

    private BlockPos placementPos;
    private ResourceLocation full = new ResourceLocation(EternalExistence.MOD_ID,"structure/built_portal_structure.nbt");
    private ResourceLocation start = new ResourceLocation(EternalExistence.MOD_ID,"structure/portal_platform.nbt");


    public PortalStructure(BlockPos placementPos) {
        this.placementPos = placementPos;
    }




    private CompoundTag loadnbt(ResourceLocation rl){
        CompoundTag loaded = new CompoundTag().getCompound(rl.getPath() + rl.getNamespace());
        return loaded;
    }
    private static Random createRandom(long pSeed) {
        return pSeed == 0L ? new Random(Util.getMillis()) : new Random(pSeed);
    }

    public void loadFinishStructure(ServerLevel pLevel){

        if(this.full != null){
            StructureManager structuremanager = pLevel.getStructureManager();

            Optional<StructureTemplate> optional = null;
            try {
                optional = structuremanager.get(this.full);
            } catch (ResourceLocationException resourcelocationexception) {
            }



            boolean ready = optional.get() != null;
            if(ready) {
                StructureTemplate template = optional.get();

                Vec3i veci = template.getSize();

                CompoundTag tag = loadnbt(this.full);
                Mirror mirror = Mirror.NONE;
                Rotation rotation = Rotation.NONE;
                boolean ignoreEntities = tag.getBoolean("ignoreEntities");
                Long seed = tag.getLong("seed");

                try {
                    rotation = Rotation.valueOf(tag.getString("rotation"));
                } catch (IllegalArgumentException illegalargumentexception2) {
                    rotation = Rotation.NONE;
                }

                try {
                    mirror = Mirror.valueOf(tag.getString("mirror"));
                } catch (IllegalArgumentException illegalargumentexception1) {
                    mirror = Mirror.NONE;
                }


                StructurePlaceSettings structureplacesettings =
                        (new StructurePlaceSettings())
                                .setMirror(mirror)
                                .setRotation(rotation)
                                .setIgnoreEntities(ignoreEntities);

                BlockPos posplace = this.placementPos.offset(veci.below()).offset(0, -1, 0);
                template.placeInWorld(pLevel, posplace, posplace, structureplacesettings, createRandom(seed), 2);
            }

        }



    }
    public void loadPlatform(ServerLevel pLevel){
        if(this.start != null){
            StructureManager structuremanager = pLevel.getStructureManager();

            Optional<StructureTemplate> optional = null;
            try {
                optional = structuremanager.get(this.start);
            } catch (ResourceLocationException resourcelocationexception) {
            }
            StructureTemplate template = optional.get();

            Vec3i veci = template.getSize();

            CompoundTag tag = loadnbt(this.start);
            Mirror mirror = Mirror.NONE;
            Rotation rotation = Rotation.NONE;
            boolean ignoreEntities  = tag.getBoolean("ignoreEntities");
            Long seed = tag.getLong("seed");

            try {
                rotation = Rotation.valueOf(tag.getString("rotation"));
            } catch (IllegalArgumentException illegalargumentexception2) {
                rotation = Rotation.NONE;
            }

            try {
                mirror = Mirror.valueOf(tag.getString("mirror"));
            } catch (IllegalArgumentException illegalargumentexception1) {
                mirror = Mirror.NONE;
            }



            StructurePlaceSettings structureplacesettings =
                    (new StructurePlaceSettings())
                            .setMirror(mirror)
                            .setRotation(rotation)
                            .setIgnoreEntities(ignoreEntities);


            BlockPos posplace = this.placementPos;
            template.placeInWorld(pLevel,posplace,posplace,structureplacesettings,createRandom(seed),2);

        }
    }
}


