package com.shadowbeastgod.eternalexistence.blocks;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.blocks.customblock.*;
import com.shadowbeastgod.eternalexistence.EeTabs;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    private static final ToIntFunction<BlockState> le = (p_10105_) -> {return 10;} ;

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EternalExistence.MOD_ID);


    public static final RegistryObject<Block> FORGOTTENSTONE =
            registryObject("forgotten_stone",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), EeTabs.eternalexistence_nature);
    public static final RegistryObject<Block> FORGOTTENDIRT =
            registryObject("forgotten_dirt",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), EeTabs.eternalexistence_nature);

    public static final RegistryObject<Block> EIGTHPORTALSTURUCTURE =
            registryObject("eighth_portal_structure",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()), EeTabs.eternalexistence_ect);
    public static final RegistryObject<Block> PORTALPILLAR =
            registryObject("portal_pillars",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).noCollission().requiresCorrectToolForDrops().noOcclusion()), EeTabs.eternalexistence_ect);


    public static final RegistryObject<Block> ESUL =
            registryObject("esul",()->new FlowerBlock(MobEffects.GLOWING, 1000 ,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()/*.lightLevel(le)*/), EeTabs.eternalexistence_nature);

    public static final RegistryObject<Block> POTTED_ESUL =
            registryObjectWithoutItem("potted_esul",()->new FlowerPotBlock(null, ModBlocks.ESUL ,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()/*.lightLevel(le)*/));

    public static final RegistryObject<Block> CRYSTAL =
            registryObject("crystal",()->new Crystal(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);

    public static final RegistryObject<Block> WAKARANAIORE =
            registryObject("wakaranai_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> WAKARANAIDEEPSLATEORE =
            registryObject("wakaranai_deepslate_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> WAKARANAIBLOCK =
            registryObject("wakaranai_block",()->new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> GUILDEDWAKARANAIBLOCK =
            registryObject("guilded_wakaranai",()->new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), EeTabs.eternalexistence_ores);

    public static final RegistryObject<Block> SUMMAVIORE =
            registryObject("summa_vi_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> SUMMAVIDEEPSLATEORE =
            registryObject("summa_vi_deepslate_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> SUMMAVIBLOCK =
            registryObject("summa_vi_block",()->new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), EeTabs.eternalexistence_ores);

    public static final RegistryObject<Block> ANOTATOSORE =
            registryObject("anotatos_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> ANOTATOSDEEPSLATEORE =
            registryObject("anotatos_deepslate_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), EeTabs.eternalexistence_ores);
    public static final RegistryObject<Block> ANOTATOSBLOCK =
            registryObject("anotatos_block",()->new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), EeTabs.eternalexistence_ores);


    public static final RegistryObject<Block> ETERNALALTAR =
            registryObject("eternal_altar",()->new EternAlaltar(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops().noOcclusion().lightLevel(le)), EeTabs.eternalexistence_ect);
    public static final RegistryObject<Block> RUSBALMVOCOGGBOGPORTALCONNECTORE =
            registryObject("rus_balm_voc_ogg_bog_portal_connectore",
                    ()->new RusbAlmvoCoggBogPortalConnectore(BlockBehaviour.Properties.of(Material.METAL)
                            .strength(2f).requiresCorrectToolForDrops().noOcclusion().lightLevel(le)), EeTabs.eternalexistence_ect);

    public static final RegistryObject<Block> GRPORTALBLOCK =
            registryObject("gr_portalblock",()->new GrPortalBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).noCollission().lightLevel(le).instabreak()), EeTabs.eternalexistence_ect);

    public static final RegistryObject<Block> PORTALSPAWNPLATFORM =
            registryObject("portal_spawn_platform",()-> new PortalplatformSpawn(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).lightLevel(le)), EeTabs.eternalexistence_ect);

    public static final RegistryObject<Block> CURSEDBRICKS =
            registryObject("cursed_bricks",()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .noOcclusion().lightLevel(le)), EeTabs.eternalexistence_nature);
    public static final RegistryObject<Block> DARKBRICKS =
            registryObject("dark_bricks",()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .noOcclusion().lightLevel(le)), EeTabs.eternalexistence_nature);

    public static final RegistryObject<Block> DARKBRICKS_STAIR =
            registryObject("dark_bricks_stair",()->new StairBlock(ModBlocks.DARKBRICKS.get().defaultBlockState()
                    ,BlockBehaviour.Properties.copy(Blocks.STONE)
                    .noOcclusion().lightLevel(le)), EeTabs.eternalexistence_nature);

    public static final RegistryObject<Block> DARKBRICKS_SLAB =
            registryObject("dark_bricks_slab",()->new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .noOcclusion().lightLevel(le)), EeTabs.eternalexistence_nature);



    private static <T extends Block> RegistryObject<T> registryObjectWithoutItem(String name, Supplier<T> block){
        return BLOCKS.register(name,block);
    }




    private static <T extends Block> RegistryObject<T> registryObject(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block, CreativeModeTab tab){
            return ModItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties().tab(tab)));

    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}
