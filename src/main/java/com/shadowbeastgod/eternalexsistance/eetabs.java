package com.shadowbeastgod.eternalexsistance;

import com.shadowbeastgod.eternalexsistance.items.moditems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class eetabs {

    public static final CreativeModeTab eternalexsistance_ores = new CreativeModeTab("eternalexsistance_ores") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(moditems.RAWWAKARANAI.get());
        }
    };

    public static final CreativeModeTab eternalexsistance_weapons = new CreativeModeTab("eternalexsistance_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(moditems.WAKARANAISWORD.get());
        }
    };

    public static final CreativeModeTab eternalexsistance_tools = new CreativeModeTab("eternalexsistance_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(moditems.WAKARANAIPICKAXE.get());
        }
    };

    /*public static final CreativeModeTab eternalexsistance_nature = new CreativeModeTab("eternalexsistance_nature") {
        @Override
        public ItemStack makeIcon() {
            return null;
        }
    };*/

}
