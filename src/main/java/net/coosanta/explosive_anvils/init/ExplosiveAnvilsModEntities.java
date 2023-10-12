
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.coosanta.explosive_anvils.entity.ExplosiveAnvilFallingEntity;
import net.coosanta.explosive_anvils.ExplosiveAnvilsMod;

public class ExplosiveAnvilsModEntities {
	public static EntityType<ExplosiveAnvilFallingEntity> EXPLOSIVE_ANVIL_FALLING;

	public static void load() {
		EXPLOSIVE_ANVIL_FALLING = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(ExplosiveAnvilsMod.MODID, "explosive_anvil_falling"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, ExplosiveAnvilFallingEntity::new)
				.dimensions(new EntityDimensions(0.9f, 0.9f, true)).fireImmune().trackRangeBlocks(128).forceTrackedVelocityUpdates(true).trackedUpdateRate(3).build());
		ExplosiveAnvilFallingEntity.init();
		FabricDefaultAttributeRegistry.register(EXPLOSIVE_ANVIL_FALLING, ExplosiveAnvilFallingEntity.createAttributes());
	}

	private static <T extends Entity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
		return FabricEntityTypeBuilder.create(MobCategory.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(1).trackedUpdateRate(64).build();
	}
}
