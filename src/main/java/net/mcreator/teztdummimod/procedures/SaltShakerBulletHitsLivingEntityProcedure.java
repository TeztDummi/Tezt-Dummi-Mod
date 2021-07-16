package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.potion.SaltyPotion;
import net.mcreator.teztdummimod.particle.SaltParticleParticle;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class SaltShakerBulletHitsLivingEntityProcedure extends TeztDummiModModElements.ModElement {
	public SaltShakerBulletHitsLivingEntityProcedure(TeztDummiModModElements instance) {
		super(instance, 238);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure SaltShakerBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency x for procedure SaltShakerBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency y for procedure SaltShakerBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency z for procedure SaltShakerBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency world for procedure SaltShakerBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(SaltyPotion.potion, (int) 600, (int) 1, (true), (true)));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
		world.addParticle(SaltParticleParticle.particle, x, y, z, (Math.random() - 0.5), 0.5, (Math.random() - 0.5));
	}
}
