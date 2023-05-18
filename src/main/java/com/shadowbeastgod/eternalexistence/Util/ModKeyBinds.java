package com.shadowbeastgod.eternalexistence.Util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    public static final String KEY_CATEGORY_ETERNAL_EXISTENCE = "key.category.eternalexistence.ee_tinker_tools";
    public static final String KEY_CREATE_STRUCTURE_JAVA_INPUT = "key.eternalexistence.java_structure";

    public static final KeyMapping STRUCTURE_JAVA_KEY =
            new KeyMapping(KEY_CREATE_STRUCTURE_JAVA_INPUT,
                    KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_J,
                    KEY_CATEGORY_ETERNAL_EXISTENCE);
}
