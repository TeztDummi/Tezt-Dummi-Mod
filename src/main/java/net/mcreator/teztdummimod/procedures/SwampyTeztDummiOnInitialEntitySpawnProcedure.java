package net.mcreator.teztdummimod.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class SwampyTeztDummiOnInitialEntitySpawnProcedure extends TeztDummiModModElements.ModElement {
	public SwampyTeztDummiOnInitialEntitySpawnProcedure(TeztDummiModModElements instance) {
		super(instance, 214);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency entity for procedure SwampyTeztDummiOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.2)) {
			{
				final ItemStack _setstack = new ItemStack(Items.STONE_SWORD, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.5)) {
			{
				final ItemStack _setstack = new ItemStack(Items.STONE_AXE, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
	}
}
