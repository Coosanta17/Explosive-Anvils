
package net.coosanta.explosive_anvils.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.coosanta.explosive_anvils.entity.ExplosiveAnvilFallingEntity;
import net.coosanta.explosive_anvils.client.model.Modeltemplate_anvil_Converted;

public class ExplosiveAnvilFallingRenderer extends MobRenderer<ExplosiveAnvilFallingEntity, Modeltemplate_anvil_Converted<ExplosiveAnvilFallingEntity>> {
	public ExplosiveAnvilFallingRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltemplate_anvil_Converted(context.bakeLayer(Modeltemplate_anvil_Converted.LAYER_LOCATION)), 0.9f);
	}

	@Override
	public ResourceLocation getTextureLocation(ExplosiveAnvilFallingEntity entity) {
		return new ResourceLocation("explosive_anvils:textures/entities/anvil.png");
	}

}
