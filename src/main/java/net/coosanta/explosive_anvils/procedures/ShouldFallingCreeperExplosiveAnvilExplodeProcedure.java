package net.coosanta.explosive_anvils.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ShouldFallingCreeperExplosiveAnvilExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (!entity.level().isClientSide())
				entity.discard();
			ExplodeCreeperExplosiveAnvilProcedure.execute(world, x, y, z);
		}
	}
}
