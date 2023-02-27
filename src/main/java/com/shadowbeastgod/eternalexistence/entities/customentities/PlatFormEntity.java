package com.shadowbeastgod.eternalexistence.entities.customentities;

import com.mojang.serialization.Dynamic;
import com.shadowbeastgod.eternalexistence.entities.customgoals.DetectPlayerOnPlatForm;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import org.checkerframework.common.returnsreceiver.qual.This;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.html.HTML;
import java.util.List;

public class PlatFormEntity extends AbstractGolem {




    public PlatFormEntity(EntityType<? extends PlatFormEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    protected void registerGoals() {
        if (this.ridingEntity() != null){
            this.goalSelector.addGoal(1, new DetectPlayerOnPlatForm(this.ridingEntity(), this));
        }

    }


    public static AttributeSupplier.Builder createAttributes(){
        return createMobAttributes().add(Attributes.MAX_HEALTH,100000);
    }

    @Override
    public void tick() {
        this.level.addParticle(ParticleTypes.DRAGON_BREATH,this.getX(),this.getY(),this.getZ(),1,1,1);
    }

    public Entity ridingEntity(){
        List<LivingEntity> le = null;
        Entity e = this.level.getNearestEntity(le, TargetingConditions.DEFAULT ,null,this.getX(),this.getY(),this.getZ());
        return e;
    }


    @Override
    public boolean isPathFinding() {
        return false;
    }

    @Override
    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }

    @Override
    public boolean canHoldItem(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        return false;
    }

    @Override
    public boolean canTakeItem(ItemStack pItemstack) {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return super.canCollideWith(pEntity);
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean isNoAi() {
        return true;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
}
