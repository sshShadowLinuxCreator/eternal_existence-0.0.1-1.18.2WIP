package com.shadowbeastgod.eternalexsistance.world.dimensions;

import com.shadowbeastgod.eternalexsistance.eternalexsistance;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class moddimensions {
    public static final ResourceKey<Level> EEGR_KEY  = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(eternalexsistance.Mod_ID, "eegrm"));
    public static final ResourceKey<DimensionType> EEGR_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, EEGR_KEY.getRegistryName());

    public static void register(){
        System.out.println("Regersting ModDimensions for" + eternalexsistance.Mod_ID);
    }
}
