package com.shadowbeastgod.eternalexsistance.blocks;

import com.shadowbeastgod.eternalexsistance.eetabs;
import com.shadowbeastgod.eternalexsistance.eternalexsistance;
import com.shadowbeastgod.eternalexsistance.blocks.customblock.eternalaltar;
import com.shadowbeastgod.eternalexsistance.blocks.customblock.grportalblock;
import com.shadowbeastgod.eternalexsistance.blocks.customblock.portalplatformspawn;
import com.shadowbeastgod.eternalexsistance.blocks.customblock.rusbalmvocoggbogportalconnectore;
import com.shadowbeastgod.eternalexsistance.items.moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class modblocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, eternalexsistance.Mod_ID);


    public static final RegistryObject<Block> WAKARANAIORE = registryObject("wakaranai_ore",()->new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()/*.lightLevel(1)*/), eetabs.eternalexsistance_ores);
    public static final RegistryObject<Block> WAKARANAIBLOCK = registryObject("wakaranai_block",()->new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), eetabs.eternalexsistance_ores);
    public static final RegistryObject<Block> GUILDEDWAKARANAIBLOCK = registryObject("guilded_wakaranai",()->new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), eetabs.eternalexsistance_ores);



    private static final ToIntFunction<BlockState> le = (p_10105_) -> {return 10;} ;
    public static final RegistryObject<Block> ETERNALALTAR = registryObject("eternal_altar",()->new eternalaltar(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion().lightLevel(le)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> RUSBALMVOCOGGBOGPORTALCONNECTORE = registryObject("rus_balm_voc_ogg_bog_portal_connectore",()->new rusbalmvocoggbogportalconnectore(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().noOcclusion().lightLevel(le)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> GRPORTALBLOCK = registryObject("gr_portalblock",()->new grportalblock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().noCollission().lightLevel(le).instabreak()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> PORTALSPAWNPLATFORM = registryObject("portal_spawn_platform",()-> new portalplatformspawn(BlockBehaviour.Properties.of(Material.METAL).strength(2f).lightLevel(le)), CreativeModeTab.TAB_MISC);

    private static <T extends Block> RegistryObject<T> registryObject(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block, CreativeModeTab tab){
            return moditems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties().tab(tab)));

    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }


}
