package net.mcreator.teztdummimod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.teztdummimod.entity.WhakaEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WhakaRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(WhakaEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelwackadoo(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("tezt_dummi_mod:textures/wacka.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelwackadoo extends EntityModel<Entity> {
		private final ModelRenderer Whaka;
		public Modelwackadoo() {
			textureWidth = 64;
			textureHeight = 64;
			Whaka = new ModelRenderer(this);
			Whaka.setRotationPoint(-0.5F, 24.0F, 0.5F);
			Whaka.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -6.0F, 10.0F, 1.0F, 11.0F, 0.0F, false);
			Whaka.setTextureOffset(21, 12).addBox(-2.0F, -1.0F, 5.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(28, 12).addBox(-5.0F, -1.0F, -5.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
			Whaka.setTextureOffset(9, 29).addBox(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			Whaka.setTextureOffset(21, 14).addBox(-3.0F, -1.0F, -7.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 12).addBox(-3.0F, -11.0F, -4.0F, 7.0F, 10.0F, 7.0F, 0.0F, false);
			Whaka.setTextureOffset(39, 11).addBox(6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
			Whaka.setTextureOffset(21, 22).addBox(-3.0F, -12.0F, -4.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 29).addBox(4.0F, -11.0F, -4.0F, 1.0F, 10.0F, 7.0F, 0.0F, false);
			Whaka.setTextureOffset(31, 0).addBox(-3.0F, -11.0F, -5.0F, 7.0F, 10.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(16, 30).addBox(-4.0F, -11.0F, -4.0F, 1.0F, 10.0F, 7.0F, 0.0F, false);
			Whaka.setTextureOffset(32, 30).addBox(-3.0F, -11.0F, 3.0F, 7.0F, 10.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 6).addBox(-2.0F, -9.0F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(3, 5).addBox(2.0F, -9.0F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 4).addBox(-2.0F, -7.0F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 2).addBox(0.0F, -7.1F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(3, 3).addBox(-1.0F, -6.6F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Whaka.setTextureOffset(3, 1).addBox(1.0F, -6.6F, -5.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Whaka.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
