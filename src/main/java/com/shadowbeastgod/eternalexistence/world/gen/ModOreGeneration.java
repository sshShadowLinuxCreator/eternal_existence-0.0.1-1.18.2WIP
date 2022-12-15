package com.shadowbeastgod.eternalexistence.world.gen;

import com.shadowbeastgod.eternalexistence.world.features.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event){
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.WAKARANAI_ORE_PLACED);
        base.add(ModPlacedFeatures.ANOTATOS_ORE_PLACED);
        base.add(ModPlacedFeatures.SUMMA_VI_ORE_PLACED);


    }
}
