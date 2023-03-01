package com.shadowbeastgod.eternalexistence.entities.customentities;

import net.minecraft.commands.CommandSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class PlatFormEntity extends AbstractGolem {

    private final float maxEntityHeight;

    public PlatFormEntity(EntityType<? extends PlatFormEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.maxEntityHeight = 5f;
    }


    public static AttributeSupplier.Builder createAttributes(){
        return createMobAttributes().add(Attributes.MAX_HEALTH,100000);
    }

    @Override
    public void tick() {
        //ToDo Fix this
        if (!this.getLevel().isClientSide()) {
            AABB bb = this.getBoundingBox().move(0,.5,0);
            List<Entity> entitiesOnPlatform = this.getLevel().getEntities((Entity) null, bb, entity -> entity instanceof LivingEntity);
            LivingEntity targetEntity = null;
            if (!entitiesOnPlatform.isEmpty()) {
                targetEntity = (LivingEntity) entitiesOnPlatform.get(0);
            }
            if (targetEntity != null) {
                targetEntity.setDeltaMovement(0,1,0);
                System.out.println(targetEntity.getName().getString());
                this.setDeltaMovement(0,1,0);

            }
        }

        if(this.getHealth() <= 0){
            this.remove(RemovalReason.KILLED);
        }


        this.level.addParticle(ParticleTypes.DRAGON_BREATH,this.getX(),this.getY(),this.getZ(),1,1,1);

        super.tick();
    }



    @Override
    public boolean canBeCollidedWith() {
        return true;
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

    /*@Override
    public boolean isNoAi() {
        return true;
    }*/

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(pSource instanceof CommandSource) {
            return super.hurt(pSource, pAmount);
        }
        return false;
    }


}
