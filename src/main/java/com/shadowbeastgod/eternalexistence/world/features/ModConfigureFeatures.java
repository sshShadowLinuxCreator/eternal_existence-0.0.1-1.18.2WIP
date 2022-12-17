package com.shadowbeastgod.eternalexistence.world.features;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfigureFeatures {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_WAKARANAI_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.WAKARANAIORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.WAKARANAIDEEPSLATEORE.get().defaultBlockState())
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> WAKARANAI_ORE = FeatureUtils.register("wakaranai_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_WAKARANAI_ORES, 5));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ANOTATOS_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ANOTATOSORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ANOTATOSDEEPSLATEORE.get().defaultBlockState())
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ANOTATOS_ORE = FeatureUtils.register("anotatos_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_ANOTATOS_ORES, 5));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SUMMAVI_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SUMMAVIORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.SUMMAVIDEEPSLATEORE.get().defaultBlockState())
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SUMMAVI_ORE = FeatureUtils.register("summa_vi_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SUMMAVI_ORES, 5));


    
}
