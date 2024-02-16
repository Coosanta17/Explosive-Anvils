/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.coosanta.explosive_anvils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

import net.coosanta.explosive_anvils.init.ExplosiveAnvilsModProcedures;
import net.coosanta.explosive_anvils.init.ExplosiveAnvilsModItems;
import net.coosanta.explosive_anvils.init.ExplosiveAnvilsModEntities;
import net.coosanta.explosive_anvils.init.ExplosiveAnvilsModBlocks;

public class ExplosiveAnvilsMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "explosive_anvils";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing ExplosiveAnvilsMod");

		ExplosiveAnvilsModEntities.load();
		ExplosiveAnvilsModBlocks.load();
		ExplosiveAnvilsModItems.load();

		ExplosiveAnvilsModProcedures.load();

	}
}
