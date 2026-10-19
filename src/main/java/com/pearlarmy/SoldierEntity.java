package com.pearlarmy;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Army soldier. Built on Zombie so the vanilla humanoid model, armor trims and
 * held items all render for free. The owner is the nearest player.
 */
public class SoldierEntity extends Zombie {
	private int seenTimestamp = 0;
	private boolean seenInit = false;

	public SoldierEntity(EntityType<? extends Zombie> type, Level level) {
		super(type, level);
		this.setSilent(true); // 141 zombie groans would be unbearable
	}

	public static AttributeSupplier.Builder createSoldierAttributes() {
		return Zombie.createAttributes()
				.add(Attributes.MAX_HEALTH, 40.0)
				.add(Attributes.MOVEMENT_SPEED, 0.3)
				.add(Attributes.FOLLOW_RANGE, 48.0)
				.add(Attributes.ATTACK_DAMAGE, 3.0)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this, SoldierEntity.class));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			return;
		}

		Player owner = this.level().getNearestPlayer(this, 128.0);
		if (owner == null) {
			return;
		}

		// Attack whatever the owner just attacked.
		int stamp = owner.getLastHurtMobTimestamp();
		if (!this.seenInit) {
			this.seenInit = true;
			this.seenTimestamp = stamp; // ignore old fights from before we spawned
		} else if (stamp != this.seenTimestamp) {
			this.seenTimestamp = stamp;
			LivingEntity victim = owner.getLastHurtMob();
			if (victim != null
					&& victim.isAlive()
					&& victim != this
					&& victim != owner
					&& !(victim instanceof SoldierEntity)
					&& victim.distanceToSqr(this) < 64.0 * 64.0) {
				this.setTarget(victim);
			}
		}

		// Stay put (keeps the formation) unless the owner gets far away.
		if (this.getTarget() == null && this.tickCount % 20 == 0) {
			double dist = this.distanceToSqr(owner);
			if (dist > 3600.0) {
				this.setPos(owner.getX(), owner.getY(), owner.getZ());
				this.getNavigation().stop();
			} else if (dist > 256.0) {
				this.getNavigation().moveTo(owner, 1.1);
			}
		}
	}
      }
