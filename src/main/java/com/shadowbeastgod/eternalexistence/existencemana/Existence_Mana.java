package com.shadowbeastgod.eternalexistence.existencemana;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

//manager for custom energy type
public class Existence_Mana implements Predicate<Integer> {

    private final int value;

    @Override
    public boolean test(Integer value) {
        return value>0;
    }
    
    protected Existence_Mana(Integer value){
        this.value = value;
    }


}


