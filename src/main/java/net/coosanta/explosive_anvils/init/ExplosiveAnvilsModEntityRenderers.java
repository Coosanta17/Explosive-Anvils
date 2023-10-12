
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.coosanta.explosive_anvils.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.coosanta.explosive_anvils.client.renderer.ExplosiveAnvilFallingRenderer;

@Environment(EnvType.CLIENT)
public class ExplosiveAnvilsModEntityRenderers {
	public static void load() {
		EntityRendererRegistry.register(ExplosiveAnvilsModEntities.EXPLOSIVE_ANVIL_FALLING, ExplosiveAnvilFallingRenderer::new);
	}
}
