package com.shadowbeastgod.eternalexistence.items.sword;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;

public class WakaranaiSword extends SwordItem {
    public WakaranaiSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {

        double entityxdisx = entity.getX() - player.getX(), entityxdisy = entity.getY() - player.getY();

        int distance = 3;

        double bx = distance * Math.cos(Math.toRadians(player.getYRot()+90)) + entityxdisx;
        double bz = distance * Math.sin(Math.toRadians(player.getYRot()+90)) + entityxdisy;

        Vec3 mo = new Vec3(bx,entity.getY(),bz);

        for(int x =0 ; x<=15; x++) {
            double px = ((player.getX()+bx)-((x/10)*2))-.3, pz = ((player.getZ()+bz)-((x/10)*2))-.3;
            player.getLevel().addParticle(ParticleTypes.CLOUD, px, player.getY()+.5, pz, 0, 0, 0);
        }

        player.move(MoverType.SELF,mo);

        return super.onLeftClickEntity(stack, player, entity);
    }


}
