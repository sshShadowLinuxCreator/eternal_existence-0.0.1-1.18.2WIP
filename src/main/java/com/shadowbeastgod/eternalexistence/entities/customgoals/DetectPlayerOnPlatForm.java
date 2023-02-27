package com.shadowbeastgod.eternalexistence.entities.customgoals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class DetectPlayerOnPlatForm extends Goal {
    private Entity RidingEntity;
    private Entity Platform;
    private BlockPos RidingBlockPos = this.RidingEntity.blockPosition();

    private BlockPos PlatFormBlockPos = this.Platform.blockPosition();

    public DetectPlayerOnPlatForm(Entity ridingEntity, Entity platform) {
        this.RidingEntity = ridingEntity;
        this.Platform = platform;

    }



    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        if (this.RidingEntity.getY() + .5 == this.Platform.getY() || this.RidingEntity.level == this.Platform.level){
            return true;
        }
        return false;
    }

    @Override
    public void stop() {
        this.Platform.discard();
        super.stop();
    }

    @Override
    public void tick() {
        Vec3i up = new Vec3i(0,.1,0);
        BlockPos.MutableBlockPos rmb = this.RidingBlockPos.mutable();
        BlockPos.MutableBlockPos pmb = this.PlatFormBlockPos.mutable();
        rmb.setWithOffset(this.RidingBlockPos, up);
        pmb.setWithOffset(this.PlatFormBlockPos, up);

        this.RidingEntity.moveTo(Vec3.atCenterOf(rmb));
        this.Platform.moveTo(Vec3.atCenterOf(pmb));
        super.tick();
    }
}
