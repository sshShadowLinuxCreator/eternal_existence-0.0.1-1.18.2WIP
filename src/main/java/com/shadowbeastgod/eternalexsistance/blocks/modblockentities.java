package com.shadowbeastgod.eternalexsistance.blocks;

import com.shadowbeastgod.eternalexsistance.eternalexsistance;
import com.shadowbeastgod.eternalexsistance.blocks.customblockentities.grportal;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modblockentities {


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, eternalexsistance.Mod_ID);

    public static final RegistryObject<BlockEntityType<grportal>> GRPORTAL =
            BLOCK_ENTITIES.register("gr_portal",()-> BlockEntityType.Builder.of(grportal::new,
                    modblocks.GRPORTALBLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<grportal>> ETERNALALTAR =
            BLOCK_ENTITIES.register("eternal_altar",()-> BlockEntityType.Builder.of(grportal::new,
                    modblocks.GRPORTALBLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<grportal>> PORTALSPAWNPLATFORM =
            BLOCK_ENTITIES.register("portal_spawn_platform",()-> BlockEntityType.Builder.of(grportal::new,
                    modblocks.PORTALSPAWNPLATFORM.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }




}
