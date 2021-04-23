// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class ModelPenguin_Pillo extends EntityModel<Entity> {
	private final ModelRenderer Rightflap;
	private final ModelRenderer Leftflap;
	private final ModelRenderer Head;
	private final ModelRenderer Body;

	public ModelPenguin_Pillo() {
		textureWidth = 128;
		textureHeight = 128;

		Rightflap = new ModelRenderer(this);
		Rightflap.setRotationPoint(0.0F, 24.0F, 0.0F);
		Rightflap.setTextureOffset(0, 54).addBox(-16.0F, -12.0F, -6.0F, 2.0F, 10.0F, 18.0F, 0.0F, false);

		Leftflap = new ModelRenderer(this);
		Leftflap.setRotationPoint(0.0F, 24.0F, 0.0F);
		Leftflap.setTextureOffset(40, 54).addBox(14.0F, -12.0F, -6.0F, 2.0F, 10.0F, 18.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 14.0F, -6.5F);
		Head.setTextureOffset(72, 74).addBox(-8.0F, -6.0F, -7.5F, 16.0F, 12.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -9.5F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 6).addBox(-2.0F, -8.0F, 14.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-14.0F, -14.0F, -8.0F, 28.0F, 12.0F, 22.0F, 0.0F, false);
		Body.setTextureOffset(0, 34).addBox(-12.0F, -2.0F, -6.0F, 24.0F, 2.0F, 18.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Rightflap.render(matrixStack, buffer, packedLight, packedOverlay);
		Leftflap.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}