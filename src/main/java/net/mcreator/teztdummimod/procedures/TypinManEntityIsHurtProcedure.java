package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.entity.GlitchyTypinBugEntity;
import net.mcreator.teztdummimod.TeztDummiModModVariables;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class TypinManEntityIsHurtProcedure extends TeztDummiModModElements.ModElement {
	public TypinManEntityIsHurtProcedure(TeztDummiModModElements instance) {
		super(instance, 94);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency x for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency y for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency z for procedure TypinManEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency world for procedure TypinManEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		TeztDummiModModVariables.MapVariables.get(world).Attacknumber = (double) Math.random();
		TeztDummiModModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 2);
		if (((TeztDummiModModVariables.MapVariables.get(world).Attacknumber) == Math.max(0, 0.5))) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (x + 5), (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x + 5), (int) y, (int) z)));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) (x - 5), (int) y, (int) z)));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z + 5))));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) (z - 5))));
				_ent.setEffectOnly(false);
				((World) world).addEntity(_ent);
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"tp @p");
				}
			}
		} else if (((TeztDummiModModVariables.MapVariables.get(world).Attacknumber) > 0.8)) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 5, Explosion.Mode.BREAK);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new GlitchyTypinBugEntity.CustomEntity(GlitchyTypinBugEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new GlitchyTypinBugEntity.CustomEntity(GlitchyTypinBugEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
		TeztDummiModModVariables.MapVariables.get(world).Attacknumber = (double) (-1);
		TeztDummiModModVariables.MapVariables.get(world).syncData(world);
	}
}
