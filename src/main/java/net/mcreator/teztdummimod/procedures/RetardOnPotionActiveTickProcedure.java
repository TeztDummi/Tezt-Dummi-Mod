package net.mcreator.teztdummimod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class RetardOnPotionActiveTickProcedure extends TeztDummiModModElements.ModElement {
	public RetardOnPotionActiveTickProcedure(TeztDummiModModElements instance) {
		super(instance, 158);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure RetardOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).attackEntityFrom(new DamageSource("%1$s Forgot how to breath").setDamageBypassesArmor(), (float) 0.5);
		}
		entity.setMotion(0, 0, 0);
	}
}
