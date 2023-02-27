package com.shadowbeastgod.eternalexistence.existencemana;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//ToDo Fix it to read json Files
public class Existence_Mana_Json_Reader extends SimpleJsonResourceReloadListener {

    public static final Existence_Mana_Json_Reader INSTANCE = new Existence_Mana_Json_Reader();
    private static final Logger LOGGER = LogUtils.getLogger();


    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(ResourceLocation.class, new ResourceLocation.Serializer())
            .create();

    /*private Pattern MANA_TYPES = Pattern.compile(
            "(?<Type>[a-zA-Z0-9._-]+)"
    );*/

    private Map<ResourceLocation, Map<ResourceLocation, JsonElement>> data;


    public Existence_Mana_Json_Reader() {
        super(GSON,"mana");
    }


    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager pResourceManager, ProfilerFiller pProfiler) {
        Map<ResourceLocation, Map<ResourceLocation, JsonElement>> data = new HashMap<>();

    }




}
