package net.mcreator.teztdummimod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.teztdummimod.entity.GlitchyTypinBugEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GlitchyTypinBugRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GlitchyTypinBugEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeltypinbugglitch(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("tezt_dummi_mod:textures/typinbugglitch.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeltypinbugglitch extends EntityModel<Entity> {
		private final ModelRenderer legg;
		private final ModelRenderer cube_r1;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r2;
		public Modeltypinbugglitch() {
			textureWidth = 64;
			textureHeight = 64;
			legg = new ModelRenderer(this);
			legg.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			legg.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
			cube_r1.setTextureOffset(43, 8).addBox(0.0F, -2.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(-3.0F, -2.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(-3.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(3.0F, -2.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(0.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(3.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(43, 8).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -2.0F, 0.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, 3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, -3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, -2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, -1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, 1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(2.2F, -1.2F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, 3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, -3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, -2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, -1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, 1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(1.1F, -1.2F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(-1.1F, -1.2F, 3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(-1.1F, -1.2F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(-1.1F, -1.2F, -2.05F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(-1.1F, -1.2F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(-1.1F, -1.2F, -3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, 1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, -1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, -2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, -3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, -4.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(6, 35).addBox(0.0F, -1.2F, 3.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(22, 20).addBox(3.9F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 11).addBox(4.0F, -8.0F, -5.0F, 1.0F, 8.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			legg.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
