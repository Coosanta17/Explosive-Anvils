package net.coosanta.explosive_anvils.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ShouldFallingExplosiveAnvilExplodeTickProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (!entity.level().isClientSide())
				entity.discard();
			ExplodeFallingExplosiveAnvilProcedure.execute(world, x, y, z);
			return true;
		}
		return false;
	}
}
