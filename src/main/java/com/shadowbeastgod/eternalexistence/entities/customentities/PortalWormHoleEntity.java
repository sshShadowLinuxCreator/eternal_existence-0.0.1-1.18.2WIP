package com.shadowbeastgod.eternalexistence.entities.customentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static software.bernie.geckolib3.util.GeckoLibUtil.createFactory;

public class PortalWormHoleEntity extends AbstractGolem implements IAnimatable {

    private AnimationFactory anima = createFactory(this);
    public PortalWormHoleEntity(EntityType<? extends AbstractGolem> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.minorHorizontalCollision = false;
        this.verticalCollisionBelow = false;
        this.verticalCollision = false;
        this.horizontalCollision = false;

    }

    public static AttributeSupplier.Builder createAttributes(){
        return createMobAttributes().add(Attributes.MAX_HEALTH,100000);
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",0,this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> animationEvent) {
        animationEvent.getController().setAnimation(new AnimationBuilder().addAnimation("default"));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.anima;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean isColliding(BlockPos pPos, BlockState pState) {
        return false;
    }

    @Override
    protected boolean isHorizontalCollisionMinor(Vec3 pDeltaMovement) {
        return false;
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return false;
    }

    @Override
    public boolean isSensitiveToWater() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void push(Entity pEntity) {

    }

    @Override
    protected void pushEntities() {

    }

    @Override
    protected void doPush(Entity pEntity) {

    }

    @Override
    public void push(double pX, double pY, double pZ) {

    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
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
}
