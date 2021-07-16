package net.mcreator.teztdummimod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.potion.SaltyPotion;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;
import java.util.Collection;

@TeztDummiModModElements.ModElement.Tag
public class SaltyoverlayDisplayOverlayIngameProcedure extends TeztDummiModModElements.ModElement {
	public SaltyoverlayDisplayOverlayIngameProcedure(TeztDummiModModElements instance) {
		super(instance, 239);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure SaltyoverlayDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == SaltyPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			return (true);
		}
		return (false);
	}
}
