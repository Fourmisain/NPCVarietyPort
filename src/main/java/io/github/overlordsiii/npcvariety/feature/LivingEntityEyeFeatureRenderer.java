package io.github.overlordsiii.npcvariety.feature;

import io.github.overlordsiii.npcvariety.api.EyeVariantManager;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.VillagerEntity;

public class LivingEntityEyeFeatureRenderer<T extends LivingEntity, M extends CompositeEntityModel<T>> extends FeatureRenderer<T, M> {

	public LivingEntityEyeFeatureRenderer(FeatureRendererContext<T, M> context) {
		super(context);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		if (!entity.isInvisible() && !entity.isSleeping() && entity instanceof EyeVariantManager) {
			renderModel(this.getContextModel(), ((EyeVariantManager) entity).getEyeVariant(), matrices, vertexConsumers, light, entity, 1.0F, 1.0F, 1.0F);
		}
	}
}
