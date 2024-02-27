
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.coosanta.explosive_anvils.procedures.SpawnFallingExplosiveAnvilProcedure;
import net.coosanta.explosive_anvils.procedures.ShouldSpawnFallingCreeperExplosiveAnvilProcedure;
import net.coosanta.explosive_anvils.procedures.ShouldFallingExplosiveAnvilExplodeTickProcedure;
import net.coosanta.explosive_anvils.procedures.ShouldFallingCreeperExplosiveAnvilExplodeProcedure;
import net.coosanta.explosive_anvils.procedures.ExplodeFallingExplosiveAnvilProcedure;
import net.coosanta.explosive_anvils.procedures.ExplodeCreeperExplosiveAnvilProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class ExplosiveAnvilsModProcedures {
	public static void load() {
		new ExplodeFallingExplosiveAnvilProcedure();
		new SpawnFallingExplosiveAnvilProcedure();
		new ShouldFallingExplosiveAnvilExplodeTickProcedure();
		new ShouldSpawnFallingCreeperExplosiveAnvilProcedure();
		new ExplodeCreeperExplosiveAnvilProcedure();
		new ShouldFallingCreeperExplosiveAnvilExplodeProcedure();
	}
}
