package com.shadowbeastgod.eternalexistence.entities.customentities;

import com.google.common.base.Verify;
import net.minecraft.commands.CommandSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LogEventListener;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;

import java.util.List;
import java.util.stream.Stream;

public class PlatFormEntity extends AbstractGolem {

    private final float maxEntityHeight;
    private boolean onriding = true;
    private Vec3 up = new Vec3(0,.01,0);
    private Vec3 up2 = new Vec3(0,.019,0);
    private int ontime = 60;

    public PlatFormEntity(EntityType<? extends PlatFormEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.maxEntityHeight = 5f;
    }


    public static AttributeSupplier.Builder createAttributes(){
        return createMobAttributes().add(Attributes.MAX_HEALTH,100000);
    }

    public void onTop() {
        if (!this.getLevel().isClientSide()) {
            AABB bb = this.getBoundingBox();
            bb.move(0, 5, 0);
            List<Entity >eop = this.getLevel().getEntities(this, bb);

            for (Entity entity : eop) {
                if (entity instanceof LivingEntity) {
                    if (!entity.isPassenger()) {
                        entity.startRiding(this);
                    }
                }
            }

        }

    }


    public void goingUp(){
        this.onTop();
        if(!this.getPassengers().isEmpty()) {
            this.move(MoverType.SELF,up);
            this.setBoundingBox(this.getBoundingBox().move(0, 0.1, 0)); // adjust the bounding box position

            // Check for riders and move them up with the platform
            /*for (Entity entity : this.getPassengers()) {
                entity.setPos(entity.getX(), entity.getY() + 0.5, entity.getZ());
            }*/
        }
        else{

            if (this.ontime <=0) {
                this.remove(RemovalReason.DISCARDED);
            }

            this.ontime--;
        }
    }

    @Override
    public void tick() {

        super.tick();

        this.goingUp();

        if(this.getHealth() <= 0 || this.ontime <=0){
            this.remove(RemovalReason.KILLED);
        }


        this.level.addParticle(ParticleTypes.DRAGON_BREATH,this.getX(),this.getY(),this.getZ(),1,1,1);


    }

    @Override
    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset()+.3;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean isSuppressingBounce() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
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
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if(!(pSource == DamageSource.GENERIC)) {
            return super.hurt(pSource, pAmount);
        }
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }


    public void setRidindEntity(Entity pEntity) {
        pEntity.startRiding(this);
    }
}
