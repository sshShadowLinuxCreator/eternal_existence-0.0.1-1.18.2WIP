package com.shadowbeastgod.eternalexistence.entities.customentities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.eventbus.api.BusBuilder;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;

import static net.minecraft.world.entity.Mob.createMobAttributes;
import static software.bernie.geckolib3.util.GeckoLibUtil.createFactory;

public class PushAwayEntity extends AbstractGolem implements IAnimatable {
    private AnimationFactory anima = createFactory(this);

    private BlockPos pushing;

    public PushAwayEntity(EntityType<? extends AbstractGolem> pEntityType, Level pLevel) {
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

    }

    @Override
    public AnimationFactory getFactory() {
        return this.anima;
    }

    public void pushingAway(){
        BlockPos p = this.pushing;
        AABB bb = this.getBoundingBox();
        bb.move(0, 5, 0);
        List<Entity > eop = this.getLevel().getEntities(this, bb);
        for(Entity e : eop){
            double ex = e.getX();
            double xset = ex > p.getX()? 1:-1;
            double ey = e.getY();
            double yset = ey > p.getY()? 1:-1;
            double ez = e.getZ();
            double zset = ez > p.getZ()? 1:-1;





        }

    }
    public void pushFrom(BlockPos bp){
        this.pushing = bp;
    }

    @Override
    public void tick() {
        super.tick();
        /*AABB bb = this.getBoundingBox();
        bb.move(0, 5, 0);
        if(this.getLevel().getEntities(this,bb)!= null && this.pushing != null){
            this.pushingAway();
        }*/
    }
}
