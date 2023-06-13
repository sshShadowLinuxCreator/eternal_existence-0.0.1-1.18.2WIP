package com.shadowbeastgod.eternalexistence.Util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.resources.CloseableResourceManager;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ModResource {




    public ResourceManager serverStructureResourceManager(Level level) {
        StructureManager structureManager = Objects.requireNonNull(level.getServer()).getStructureManager();
        Field structureManagerField;
        ResourceManager resourceManager;


        try {
            structureManagerField = StructureManager.class.getDeclaredField("resourceManager");
            structureManagerField.setAccessible(true);
            resourceManager = (ResourceManager) structureManagerField.get(structureManager);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return resourceManager;
    }
}
