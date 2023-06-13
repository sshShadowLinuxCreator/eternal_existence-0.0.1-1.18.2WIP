package com.shadowbeastgod.eternalexistence.experiment;

import com.legacy.structure_gel.api.structure.GelStructurePlacement;
import com.legacy.structure_gel.api.structure.StructureAccessHelper;
import com.legacy.structure_gel.core.structure.GelTemplate;
import com.mojang.datafixers.DataFixer;
import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.Util.ModResource;
import com.shadowbeastgod.eternalexistence.entities.customentities.PortalStructureEntity;
import com.sk89q.worldedit.world.World;
import net.minecraft.ResourceLocationException;
import net.minecraft.Util;
import net.minecraft.client.renderer.blockentity.StructureBlockRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.gametest.framework.StructureUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.WorldStem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.CloseableResourceManager;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.WorldData;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PortalStructure {


    private ResourceLocation resourceLocation;
    private ModResource modResource = new ModResource();




    private BlockPos placementPos;
    private ResourceLocation full = new ResourceLocation(EternalExistence.MOD_ID,"built_portal_structure");
    private ResourceLocation start = new ResourceLocation(EternalExistence.MOD_ID,"portal_platform");


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






    public Map<BlockPos,BlockState> portalBuiltStateList(Level level){
        Map<BlockPos,BlockState> st = new HashMap<>();
        ResourceLocation rs = new ResourceLocation(EternalExistence.MOD_ID,"structures/built_portal_structure.nbt");
        Resource resource = null;
        CompoundTag tag = null;

        ModResource mr = new ModResource();
        ResourceManager resourceManager = mr.serverStructureResourceManager(level);


        try {
            resource = resourceManager.getResource(rs);
            tag = NbtIo.readCompressed(resource.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ListTag blockStateListTag = tag.getList("palette",10);
        ListTag blockPosListTag = tag.getList("blocks",10);

        int i = 0;
        for(int j = 0; j< blockPosListTag.size();j++){
            CompoundTag cp = blockPosListTag.getCompound(j);
            ListTag lpos = cp.getList("pos",3);
            int sta = cp.getInt("state");
            CompoundTag ibs = blockStateListTag.getCompound(sta);
            BlockState bsi = NbtUtils.readBlockState(ibs);

            if(bsi.getBlock() != Blocks.AIR){
                BlockPos bslo = new BlockPos(lpos.getInt(0),lpos.getInt(1),lpos.getInt(2));
                st.put(bslo,bsi);
                i++;
            }
        }


        return st;

        //pos1 8, 17, 8, dims 17, 26, 17


    }

    public Map<BlockPos,BlockState> portalPlatformStateList(ServerLevel level){

        Map<BlockPos,BlockState> ppl = new HashMap<>();
        ResourceLocation rs = new ResourceLocation(EternalExistence.MOD_ID,"structures/portal_platform.nbt");
        Resource resource = null;
        CompoundTag tag = null;

        ModResource mr = new ModResource();
        ResourceManager resourceManager = mr.serverStructureResourceManager(level);


        try {
            resource = resourceManager.getResource(rs);
            tag = NbtIo.readCompressed(resource.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ListTag blockStateListTag = tag.getList("palette",10);
        ListTag blockPosListTag = tag.getList("blocks",10);

        int i = 0;
        for(int j = 0; j< blockPosListTag.size();j++){
            CompoundTag cp = blockPosListTag.getCompound(j);
            ListTag lpos = cp.getList("pos",3);
            int sta = cp.getInt("state");
            CompoundTag ibs = blockStateListTag.getCompound(sta);
            BlockState bsi = NbtUtils.readBlockState(ibs);

            if(bsi.getBlock() != Blocks.AIR){
                BlockPos bslo = new BlockPos(lpos.getInt(0),lpos.getInt(1),lpos.getInt(2));
                ppl.put(bslo,bsi);
                i++;
            }
        }


        return ppl;
    }





}


