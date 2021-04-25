
package net.mcreator.teztdummimod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.teztdummimod.procedures.TeztstegoreOnInitialEntitySpawnProcedure;
import net.mcreator.teztdummimod.procedures.TeztstegoreEntityIsHurtProcedure;
import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TeztDummiModModElements.ModElement.Tag
public class TeztstegoreEntity extends TeztDummiModModElements.ModElement {
	public static EntityType entity = null;
	public TeztstegoreEntity(TeztDummiModModElements instance) {
		super(instance, 114);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2f, 2f)).build("teztstegore")
						.setRegistryName("teztstegore");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16764058, -16738048, new Item.Properties().group(TeztDummiModItemGroup.tab))
				.setRegistryName("teztstegore_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("tezt_dummi_mod:tezlands")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelteztstegore(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tezt_dummi_mod:textures/zteztstegore.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 20;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("sourceentity", sourceentity);
				TeztstegoreEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				TeztstegoreOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(3D);
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
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
}
