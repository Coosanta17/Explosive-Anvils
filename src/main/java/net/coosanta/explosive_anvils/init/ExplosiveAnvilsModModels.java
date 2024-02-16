
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.coosanta.explosive_anvils.client.model.Modeltemplate_anvil_Converted;

@Environment(EnvType.CLIENT)
public class ExplosiveAnvilsModModels {
	public static void load() {
		EntityModelLayerRegistry.registerModelLayer(Modeltemplate_anvil_Converted.LAYER_LOCATION, Modeltemplate_anvil_Converted::createBodyLayer);
	}
}
