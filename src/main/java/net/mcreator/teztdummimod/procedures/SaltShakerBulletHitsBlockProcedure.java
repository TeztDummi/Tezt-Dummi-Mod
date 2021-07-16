package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.teztdummimod.particle.SaltParticleParticle;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class SaltShakerBulletHitsBlockProcedure extends TeztDummiModModElements.ModElement {
	public SaltShakerBulletHitsBlockProcedure(TeztDummiModModElements instance) {
		super(instance, 240);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency x for procedure SaltShakerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency y for procedure SaltShakerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency z for procedure SaltShakerBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency world for procedure SaltShakerBulletHitsBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
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
