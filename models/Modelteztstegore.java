// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelteztstegore extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer legl1;
	private final ModelRenderer legl2;
	private final ModelRenderer leg_r1;
	private final ModelRenderer legl3;
	private final ModelRenderer legr1;
	private final ModelRenderer legr2;
	private final ModelRenderer legr3;

	public Modelteztstegore() {
		textureWidth = 256;
		textureHeight = 256;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -7.0F, -19.0F);
		Head.setTextureOffset(0, 0).addBox(2.1F, -9.5F, -23.3F, 2.0F, 8.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 0).addBox(-1.9F, -5.1F, -23.3F, 2.0F, 4.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 0).addBox(-3.9F, -8.5F, -23.3F, 2.0F, 4.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 0).addBox(-5.5F, -12.5F, -23.3F, 2.0F, 4.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 0).addBox(0.1F, -1.7F, -23.3F, 2.0F, 2.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 32).addBox(6.5F, -12.9F, -23.3F, 2.0F, 2.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(0, 32).addBox(-8.3F, -1.7F, -23.3F, 2.0F, 2.0F, 2.0F, 0.1F, false);
		Head.setTextureOffset(124, 0).addBox(-10.0F, -27.0F, -20.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
		Head.setTextureOffset(28, 40).addBox(-14.0F, -23.0F, -20.0F, 4.0F, 8.0F, 12.0F, 0.0F, false);
		Head.setTextureOffset(108, 120).addBox(8.0F, -27.0F, -20.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
		Head.setTextureOffset(110, 94).addBox(10.0F, -23.0F, -20.0F, 4.0F, 8.0F, 12.0F, 0.0F, false);
		Head.setTextureOffset(40, 0).addBox(-2.0F, -21.0F, -14.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(138, 34).addBox(-2.0F, -15.0F, -8.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 80).addBox(-12.0F, -17.0F, -22.0F, 24.0F, 22.0F, 16.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(120, 80).addBox(-2.0F, -42.0F, -19.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(120, 80).addBox(-2.0F, -42.0F, -9.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(120, 80).addBox(-2.0F, -42.0F, 1.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(120, 80).addBox(-2.0F, -42.0F, 11.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(120, 80).addBox(-2.0F, -42.0F, 21.0F, 4.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-16.0F, -36.0F, -31.0F, 32.0F, 20.0F, 60.0F, 0.0F, false);
		Body.setTextureOffset(124, 18).addBox(-2.0F, -39.0F, 29.0F, 4.0F, 16.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(124, 40).addBox(-2.0F, -41.0F, 35.0F, 4.0F, 14.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(30, 16).addBox(-2.0F, -43.0F, 41.0F, 4.0F, 8.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(64, 80).addBox(-2.0F, -35.0F, 41.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		legl1 = new ModelRenderer(this);
		legl1.setRotationPoint(9.0F, 8.0F, -18.0F);
		legl1.setTextureOffset(80, 80).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		legl2 = new ModelRenderer(this);
		legl2.setRotationPoint(9.0F, 8.0F, 0.0F);

		leg_r1 = new ModelRenderer(this);
		leg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		legl2.addChild(leg_r1);
		setRotationAngle(leg_r1, 0.0F, -0.0436F, 0.0F);
		leg_r1.setTextureOffset(80, 80).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		legl3 = new ModelRenderer(this);
		legl3.setRotationPoint(7.0F, 8.0F, 18.0F);
		legl3.setTextureOffset(80, 80).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		legr1 = new ModelRenderer(this);
		legr1.setRotationPoint(-9.0F, 8.0F, -18.0F);
		legr1.setTextureOffset(80, 80).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		legr2 = new ModelRenderer(this);
		legr2.setRotationPoint(-9.0F, 8.0F, 0.0F);
		legr2.setTextureOffset(80, 80).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		legr3 = new ModelRenderer(this);
		legr3.setRotationPoint(-7.0F, 8.0F, 18.0F);
		legr3.setTextureOffset(0, 0).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		legl1.render(matrixStack, buffer, packedLight, packedOverlay);
		legl2.render(matrixStack, buffer, packedLight, packedOverlay);
		legl3.render(matrixStack, buffer, packedLight, packedOverlay);
		legr1.render(matrixStack, buffer, packedLight, packedOverlay);
		legr2.render(matrixStack, buffer, packedLight, packedOverlay);
		legr3.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.legl1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legl3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legl2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legr1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legr3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legr2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}