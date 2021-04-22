
package net.mcreator.teztdummimod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TeztDummiModModElements.ModElement.Tag
public class GlitchyTypinBugEntity extends TeztDummiModModElements.ModElement {
	public static EntityType entity = null;
	public GlitchyTypinBugEntity(TeztDummiModModElements instance) {
		super(instance, 63);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("glitchy_typin_bug")
						.setRegistryName("glitchy_typin_bug");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -11730944, -26880, new Item.Properties().group(TeztDummiModItemGroup.tab))
				.setRegistryName("glitchy_typin_bug_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltypinbugglitch(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tezt_dummi_mod:textures/typinbugglitch.png");
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
			experienceValue = 5;
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
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, true));
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
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2);
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(ParticleTypes.CRIT, d0, d1, d2, d3, d4, d5);
				}
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
