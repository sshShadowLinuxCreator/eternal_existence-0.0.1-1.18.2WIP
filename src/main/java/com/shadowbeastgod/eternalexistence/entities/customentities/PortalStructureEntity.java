package com.shadowbeastgod.eternalexistence.entities.customentities;

import com.shadowbeastgod.eternalexistence.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.example.registry.SoundRegistry;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static software.bernie.geckolib3.util.GeckoLibUtil.createFactory;

public class PortalStructureEntity extends AbstractGolem implements IAnimatable {
    private AnimationFactory anima = createFactory(this);

    private int animationnum = 0;
    private Boolean killme= false;
    private int itime = 0;

    public PortalStructureEntity(EntityType<? extends AbstractGolem> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public static AttributeSupplier.Builder createAttributes(){
        return createMobAttributes().add(Attributes.MAX_HEALTH,100000);
    }


    @Override
    public void registerControllers(AnimationData data) {
       AnimationController controller = new AnimationController(this,"controller",0,this::predicate);

       controller.registerSoundListener(this::soundListener);
       data.addAnimationController(controller);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> animationEvent) {

        if(animationnum == 0) {
            animationEvent.getController().setAnimation(
                new AnimationBuilder().addAnimation("animation.portal_structure.rising"
                        , ILoopType.EDefaultLoopTypes.PLAY_ONCE));

            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;

    }

    private <E extends IAnimatable> void soundListener(SoundKeyframeEvent<E> event){
        this.playSound(ModSounds.STRUCTURE_RISING.get(), 100, 1);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.anima;
    }

    public void killOff(Boolean kill){
        this.killme = kill;
    }

    @Override
    public void tick() {
        super.tick();
        this.itime++;
        if(this.itime >=360){
            this.level.playSound(null,this.getX(),this.getY(),this.getZ(), SoundEvents.AMETHYST_CLUSTER_HIT,SoundSource.AMBIENT,5,0);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void tickLeash() {
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
    public boolean canHoldItem(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }


}
