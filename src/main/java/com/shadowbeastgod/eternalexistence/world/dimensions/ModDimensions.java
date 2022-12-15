package com.shadowbeastgod.eternalexistence.world.dimensions;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> EEGR_KEY  = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(EternalExistence.MOD_ID, "eegrm"));
    public static final ResourceKey<DimensionType> EEGR_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, EEGR_KEY.getRegistryName());

    public static void register(){
        System.out.println("Regersting ModDimensions for" + EternalExistence.MOD_ID);
    }
}
