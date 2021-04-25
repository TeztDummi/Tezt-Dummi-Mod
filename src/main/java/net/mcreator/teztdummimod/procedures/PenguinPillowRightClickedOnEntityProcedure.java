package net.mcreator.teztdummimod.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Map;
import java.util.Iterator;

@TeztDummiModModElements.ModElement.Tag
public class PenguinPillowRightClickedOnEntityProcedure extends TeztDummiModModElements.ModElement {
	public PenguinPillowRightClickedOnEntityProcedure(TeztDummiModModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure PenguinPillowRightClickedOnEntity!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof ServerPlayerEntity) {
			Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
					.getAdvancement(new ResourceLocation("tezt_dummi_mod:into_the_sunset"));
			AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemaningCriteria().iterator();
				while (_iterator.hasNext()) {
					String _criterion = (String) _iterator.next();
					((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
				}
			}
		}
	}
}
