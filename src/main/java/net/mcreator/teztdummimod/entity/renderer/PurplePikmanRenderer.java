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

import net.mcreator.teztdummimod.entity.PurplePikmanEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PurplePikmanRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PurplePikmanEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpurplesus(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("tezt_dummi_mod:textures/purple_sus.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelpurplesus extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer body;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		public Modelpurplesus() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 15.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head.setTextureOffset(32, 0).addBox(1.0F, -6.0F, -4.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(38, 0).addBox(-3.0F, -6.0F, -4.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(16, 16).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1745F, 0.3491F, -0.3927F);
			cube_r1.setTextureOffset(0, 16).addBox(8.7688F, -11.481F, 4.9772F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(20, 28).addBox(11.7688F, -11.481F, 4.9772F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 26).addBox(9.7688F, -12.481F, 4.9772F, 2.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.2618F, 0.0F);
			cube_r2.setTextureOffset(20, 20).addBox(2.5176F, -16.0F, -0.0319F, 3.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.1745F, 0.0F);
			cube_r3.setTextureOffset(24, 5).addBox(1.3473F, -15.0F, -0.3696F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0873F, 0.0F);
			cube_r4.setTextureOffset(6, 26).addBox(0.1743F, -14.0F, -0.6924F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0436F, 0.0F);
			cube_r5.setTextureOffset(0, 0).addBox(-0.9128F, -12.0F, -0.9981F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-3.0F, 16.0F, 0.0F);
			rightarm.setTextureOffset(14, 26).addBox(-1.0F, -0.6F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(3.0F, 16.0F, 0.0F);
			leftarm.setTextureOffset(26, 26).addBox(0.0F, -0.6F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 18.0F, 0.0F);
			body.setTextureOffset(0, 16).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-1.0F, 21.0F, 0.0F);
			rightleg.setTextureOffset(24, 0).addBox(-1.3F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(1.0F, 21.0F, 0.0F);
			leftleg.setTextureOffset(20, 23).addBox(-0.6F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
