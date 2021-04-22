
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.item.KeyItem;
import net.mcreator.teztdummimod.item.ChipItem;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TeztDummiModModElements.ModElement.Tag
public class TypinBugEntity extends TeztDummiModModElements.ModElement {
	public static EntityType entity = null;
	public TypinBugEntity(TeztDummiModModElements instance) {
		super(instance, 58);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("typin_bug")
						.setRegistryName("typin_bug");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -26368, new Item.Properties().group(TeztDummiModItemGroup.tab))
				.setRegistryName("typin_bug_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltypinbug(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tezt_dummi_mod:textures/texture.png");
				}
			};
		});
	}
	public static class CustomEntity extends TameableEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
			this.goalSelector.addGoal(2, new OwnerHurtTargetGoal(this));
			this.goalSelector.addGoal(3, new BreedGoal(this, 1));
			this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
			this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(ChipItem.block, (int) (1)));
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
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.processInteract(sourceentity, hand);
			} else if (this.world.isRemote) {
				retval = this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack);
			} else {
				if (this.isTamed()) {
					if (this.isOwner(sourceentity)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal((float) item.getFood().getHealing());
							retval = true;
						} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal(4);
							retval = true;
						} else {
							retval = super.processInteract(sourceentity, hand);
						}
					}
				} else if (this.isBreedingItem(itemstack)) {
					this.consumeItemFromStack(sourceentity, itemstack);
					if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.setTamedBy(sourceentity);
						this.world.setEntityState(this, (byte) 7);
					} else {
						this.world.setEntityState(this, (byte) 6);
					}
					this.enablePersistence();
					retval = true;
				} else {
					retval = super.processInteract(sourceentity, hand);
					if (retval)
						this.enablePersistence();
				}
			}
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(this.world);
			retval.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(retval)), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(KeyItem.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeltypinbug extends EntityModel<Entity> {
		private final ModelRenderer legg;
		private final ModelRenderer cube_r1;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r2;
		public Modeltypinbug() {
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
			cube_r2.setTextureOffset(0, 4).addBox(3.8F, -4.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(4, 4).addBox(3.8F, -4.5F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(3.8F, -4.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r2.setTextureOffset(5, 0).addBox(3.8F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 6).addBox(3.8F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 29).addBox(3.9F, -7.5F, -4.5F, 1.0F, 6.0F, 9.0F, 0.0F, false);
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
