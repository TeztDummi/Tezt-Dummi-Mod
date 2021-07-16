package net.mcreator.teztdummimod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class DesertTeztDummiEntityIsHurtProcedure extends TeztDummiModModElements.ModElement {
	public DesertTeztDummiEntityIsHurtProcedure(TeztDummiModModElements instance) {
		super(instance, 223);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure DesertTeztDummiEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 1);
	}
}
