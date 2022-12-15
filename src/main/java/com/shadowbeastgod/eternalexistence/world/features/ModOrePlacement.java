package com.shadowbeastgod.eternalexistence.world.features;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier aModifier, PlacementModifier bModifier  ){
        return List.of(aModifier, InSquarePlacement.spread(), bModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier pModifier){
        return orePlacement(CountPlacement.of(i),pModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int j, PlacementModifier pModifier){
        return orePlacement(RarityFilter.onAverageOnceEvery(j),pModifier);
    }


}


