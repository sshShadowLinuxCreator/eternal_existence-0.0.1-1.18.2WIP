package com.shadowbeastgod.eternalexistence.entities.customentities;

import com.shadowbeastgod.eternalexistence.world.GodRealmTeleportal;
import com.shadowbeastgod.eternalexistence.world.dimensions.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

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

    public void isInside() {
        BlockPos pos = this.blockPosition();
        if (!this.getLevel().isClientSide()) {
            AABB bb = this.getBoundingBox();
            List<Entity > eop = this.getLevel().getEntities(this, bb);

            for (Entity entity : eop) {
                if (entity instanceof LivingEntity) {
                    if(entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
                        if (entity.isOnPortalCooldown()) {
                            entity.setPortalCooldown();}


                        else{

                            if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
                                entity.portalEntrancePos = pos.immutable();
                            }
                            Level entityWorld = entity.level;
                            if (entityWorld != null) {
                                MinecraftServer minecraftserver = entityWorld.getServer();
                                ResourceKey<Level> destination = entity.level.dimension() == ModDimensions.EEGR_KEY
                                        ? Level.OVERWORLD : ModDimensions.EEGR_KEY;
                                if (minecraftserver != null) {
                                    ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                                    if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                                        entity.level.getProfiler().push("gr_portal");
                                        entity.setPortalCooldown();
                                        entity.changeDimension(destinationWorld, new GodRealmTeleportal(pos,destinationWorld, entity));
                                        entity.level.getProfiler().pop();
                                        this.remove(RemovalReason.DISCARDED);
                                    }

                                }

                            }

                        }

                    }
                }
            }

        }

    }

    @Override
    public void tick() {
        super.tick();
        isInside();

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",0,this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> animationEvent) {
        animationEvent.getController().setAnimation(
                new AnimationBuilder().addAnimation("animation.portal_wormhole.default",ILoopType.EDefaultLoopTypes.LOOP));
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
        if(!(pSource == DamageSource.GENERIC)) {
            return super.hurt(pSource, pAmount);
        }
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
