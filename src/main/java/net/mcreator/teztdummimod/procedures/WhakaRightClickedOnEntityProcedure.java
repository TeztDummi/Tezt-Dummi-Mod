package net.mcreator.teztdummimod.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;
import java.util.Iterator;

@TeztDummiModModElements.ModElement.Tag
public class WhakaRightClickedOnEntityProcedure extends TeztDummiModModElements.ModElement {
	public WhakaRightClickedOnEntityProcedure(TeztDummiModModElements instance) {
		super(instance, 212);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure WhakaRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WhakaRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("tezt_dummi_mod:whackadoo"));
			AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
		if ((entity instanceof TameableEntity) && (sourceentity instanceof PlayerEntity)) {
			((TameableEntity) entity).setTamed(true);
			((TameableEntity) entity).setTamedBy((PlayerEntity) sourceentity);
		}
	}
}
