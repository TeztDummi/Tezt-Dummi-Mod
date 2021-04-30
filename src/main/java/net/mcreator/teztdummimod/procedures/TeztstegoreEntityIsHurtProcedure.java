package net.mcreator.teztdummimod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class TeztstegoreEntityIsHurtProcedure extends TeztDummiModModElements.ModElement {
	public TeztstegoreEntityIsHurtProcedure(TeztDummiModModElements instance) {
		super(instance, 123);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TeztstegoreEntityIsHurt!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((Math.random() < 0.1)) {
			sourceentity.setMotion(0, 2, 0);
		}
	}
}
