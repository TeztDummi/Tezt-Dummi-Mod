// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelpenguin_hat extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;

	public Modelpenguin_hat() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 24.0F, 5.0F);
		setRotationAngle(bone, 0.0F, -1.5708F, 0.0F);
		bone.setTextureOffset(18, 9).addBox(-9.5F, -7.7F, 3.0F, 9.0F, 4.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(0, 4).addBox(-0.5F, -7.7F, 3.5F, 0.0F, 4.0F, 9.0F, 0.0F, false);
		bone.setTextureOffset(0, 17).addBox(-9.5F, -7.7F, 12.5F, 9.0F, 4.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-10.0F, -7.7F, 3.5F, 0.0F, 4.0F, 9.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-9.5F, -8.0F, 3.5F, 9.0F, 0.0F, 9.0F, 0.0F, false);
		bone.setTextureOffset(0, 59).addBox(-10.2F, -7.0F, 9.5F, 0.0F, 3.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(4, 59).addBox(-10.2F, -7.0F, 4.5F, 0.0F, 3.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(22, 23).addBox(-10.8F, -5.1F, 6.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 21).addBox(-6.0F, -0.1F, -1.8F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(14, 17).addBox(-6.0F, 0.0F, 13.8F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(14, 23).addBox(-5.9F, -6.1F, 0.8F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-9.0F, 0.0F, 16.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(3.1F, -6.1F, -2.8F, 2.0F, 7.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}