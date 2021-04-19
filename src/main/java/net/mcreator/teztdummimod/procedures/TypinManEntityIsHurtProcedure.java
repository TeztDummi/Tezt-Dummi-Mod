package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class TypinManEntityIsHurtProcedure extends TeztDummiModModElements.ModElement {
	public TypinManEntityIsHurtProcedure(TeztDummiModModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TypinManEntityIsHurt!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() >= Math.max(0, 0.5))) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) (x + 5), (int) y, (int) z, false));
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) (x + 5), (int) y, (int) z, (float) 4, Explosion.Mode.BREAK);
			}
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) (x - 5), (int) y, (int) z, false));
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) y, (int) (z + 5), false));
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) x, (int) y, (int) (z + 5), (float) 4, Explosion.Mode.BREAK);
			}
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) y, (int) (z - 5), false));
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 4, Explosion.Mode.BREAK);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
			}
		} else if ((Math.random() > Math.max(0.5, 0.8))) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		} else if (true) {
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
			}
		}
	}
}
