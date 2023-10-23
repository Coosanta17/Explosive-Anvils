package net.coosanta.explosive_anvils.entity;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.coosanta.explosive_anvils.procedures.ShouldFallingCreeperExplosiveAnvilExplodeProcedure;
import net.coosanta.explosive_anvils.procedures.ExplodeCreeperExplosiveAnvilProcedure;

public class CreeperExplosvieAnvilFallingEntityEntity extends PathfinderMob {
	public CreeperExplosvieAnvilFallingEntityEntity(EntityType<CreeperExplosvieAnvilFallingEntityEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(true);
		setPersistenceRequired();
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (CreeperExplosvieAnvilFallingEntityEntity.this.isInWater())
					CreeperExplosvieAnvilFallingEntityEntity.this.setDeltaMovement(CreeperExplosvieAnvilFallingEntityEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !CreeperExplosvieAnvilFallingEntityEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - CreeperExplosvieAnvilFallingEntityEntity.this.getX();
					double dy = this.wantedY - CreeperExplosvieAnvilFallingEntityEntity.this.getY();
					double dz = this.wantedZ - CreeperExplosvieAnvilFallingEntityEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * CreeperExplosvieAnvilFallingEntityEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					CreeperExplosvieAnvilFallingEntityEntity.this.setYRot(this.rotlerp(CreeperExplosvieAnvilFallingEntityEntity.this.getYRot(), f, 10));
					CreeperExplosvieAnvilFallingEntityEntity.this.yBodyRot = CreeperExplosvieAnvilFallingEntityEntity.this.getYRot();
					CreeperExplosvieAnvilFallingEntityEntity.this.yHeadRot = CreeperExplosvieAnvilFallingEntityEntity.this.getYRot();
					if (CreeperExplosvieAnvilFallingEntityEntity.this.isInWater()) {
						CreeperExplosvieAnvilFallingEntityEntity.this.setSpeed((float) CreeperExplosvieAnvilFallingEntityEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						CreeperExplosvieAnvilFallingEntityEntity.this.setXRot(this.rotlerp(CreeperExplosvieAnvilFallingEntityEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(CreeperExplosvieAnvilFallingEntityEntity.this.getXRot() * (float) (Math.PI / 180.0));
						CreeperExplosvieAnvilFallingEntityEntity.this.setZza(f3 * f1);
						CreeperExplosvieAnvilFallingEntityEntity.this.setYya((float) (f1 * dy));
					} else {
						CreeperExplosvieAnvilFallingEntityEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					CreeperExplosvieAnvilFallingEntityEntity.this.setSpeed(0);
					CreeperExplosvieAnvilFallingEntityEntity.this.setYya(0);
					CreeperExplosvieAnvilFallingEntityEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation(""));
	}

	@Override
	public void thunderHit(ServerLevel serverWorld, LightningBolt lightningBolt) {
		super.thunderHit(serverWorld, lightningBolt);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		Entity sourceentity = source.getEntity();
		ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity sourceentity = source.getEntity();
		Entity entity = this;
		Level world = this.level();
		ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		ShouldFallingCreeperExplosiveAnvilExplodeProcedure.execute(world, x, y, z, entity);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		Entity entity = this;
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 999);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 0);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		return builder;
	}
}
