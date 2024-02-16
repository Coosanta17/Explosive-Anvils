
package net.coosanta.explosive_anvils.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.coosanta.explosive_anvils.entity.CreeperExplosvieAnvilFallingEntityEntity;
import net.coosanta.explosive_anvils.client.model.Modeltemplate_anvil_Converted;

public class CreeperExplosvieAnvilFallingEntityRenderer extends MobRenderer<CreeperExplosvieAnvilFallingEntityEntity, Modeltemplate_anvil_Converted<CreeperExplosvieAnvilFallingEntityEntity>> {
	public CreeperExplosvieAnvilFallingEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltemplate_anvil_Converted(context.bakeLayer(Modeltemplate_anvil_Converted.LAYER_LOCATION)), 0.9f);
	}

	@Override
	public ResourceLocation getTextureLocation(CreeperExplosvieAnvilFallingEntityEntity entity) {
		return new ResourceLocation("explosive_anvils:textures/entities/anvil.png");
	}

}
