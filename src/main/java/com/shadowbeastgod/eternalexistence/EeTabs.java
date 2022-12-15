package com.shadowbeastgod.eternalexistence;

import com.shadowbeastgod.eternalexistence.blocks.ModBlocks;
import com.shadowbeastgod.eternalexistence.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class EeTabs {

    public static final CreativeModeTab eternalexistence_ores = new CreativeModeTab("eternalexistence_ores") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAWWAKARANAI.get());
        }
    };

    public static final CreativeModeTab eternalexistence_weapons = new CreativeModeTab("eternalexistence_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WAKARANAISWORD.get());
        }
    };

    public static final CreativeModeTab eternalexistence_tools = new CreativeModeTab("eternalexistence_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WAKARANAIPICKAXE.get());
        }
    };

    public static final CreativeModeTab eternalexistence_ect = new CreativeModeTab("eternalexistence_ect") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.ETERNALALTAR.get().asItem());
        }
    };
    public static final CreativeModeTab eternalexistence_armor = new CreativeModeTab("eternalexistence_armor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WAKARANAIPICKAXE.get());
        }
    };

    public static final CreativeModeTab eternalexistence_nature = new CreativeModeTab("eternalexistence_nature") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.FORGOTTENSTONE.get().asItem());
        }
    };

}
