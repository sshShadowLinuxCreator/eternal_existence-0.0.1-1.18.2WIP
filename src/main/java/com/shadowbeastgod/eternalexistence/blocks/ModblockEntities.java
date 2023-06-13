package com.shadowbeastgod.eternalexistence.blocks;

import com.shadowbeastgod.eternalexistence.EternalExistence;
import com.shadowbeastgod.eternalexistence.blocks.customblock.RusbAlmvoCoggBogPortalConnectore;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.EteranlAltarBlockEntity;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.GrPortal;
import com.shadowbeastgod.eternalexistence.blocks.customblockentities.RusbAlmvoCoggBogPortalConnectoreEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModblockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EternalExistence.MOD_ID);

    public static final RegistryObject<BlockEntityType<GrPortal>> GRPORTAL =
            BLOCK_ENTITIES.register("gr_portal",()-> BlockEntityType.Builder.of(GrPortal::new,
                    ModBlocks.GRPORTALBLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<EteranlAltarBlockEntity>> ETERNALALTAR =
            BLOCK_ENTITIES.register("eternal_altar_block_entity",()-> BlockEntityType.Builder.of(EteranlAltarBlockEntity::new,
                    ModBlocks.ETERNALALTAR.get()).build(null));

    public static final RegistryObject<BlockEntityType<RusbAlmvoCoggBogPortalConnectoreEntity>> RUSBALMVOCOGGBOGPORTALCONNECTORE =
            BLOCK_ENTITIES.register("rus_balm_voc_ogg_bog_portal_connectore_entity",()-> BlockEntityType.Builder.of(RusbAlmvoCoggBogPortalConnectoreEntity::new,
                    ModBlocks.RUSBALMVOCOGGBOGPORTALCONNECTORE.get()).build(null));



    public static void register(IEventBus eventBus){

        BLOCK_ENTITIES.register(eventBus);
    }




}
