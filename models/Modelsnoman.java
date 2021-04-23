// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelsnoman extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer Body;

	public Modelsnoman() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 7.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(1.0F, -4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 5).addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 40).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(30, 30).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(40, 14).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 14.75F, 0.0F);
		Body.setTextureOffset(0, 22).addBox(-5.0F, -7.75F, -5.0F, 10.0F, 7.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-6.0F, -0.75F, -6.0F, 12.0F, 10.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}