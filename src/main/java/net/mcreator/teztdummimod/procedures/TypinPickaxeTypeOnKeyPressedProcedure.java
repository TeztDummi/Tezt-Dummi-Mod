package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.item.TypinPickaxeItem;
import net.mcreator.teztdummimod.TeztDummiModModVariables;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class TypinPickaxeTypeOnKeyPressedProcedure extends TeztDummiModModElements.ModElement {
	public TypinPickaxeTypeOnKeyPressedProcedure(TeztDummiModModElements instance) {
		super(instance, 119);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TypinPickaxeTypeOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure TypinPickaxeTypeOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TypinPickaxeItem.block, (int) (1)).getItem())) {
			if (((TeztDummiModModVariables.MapVariables.get(world).TypinPickaxeType) == 0)) {
				TeztDummiModModVariables.MapVariables.get(world).TypinPickaxeType = (double) 1;
				TeztDummiModModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3x3 Mode On"), (true));
				}
			} else if (((TeztDummiModModVariables.MapVariables.get(world).TypinPickaxeType) == 1)) {
				TeztDummiModModVariables.MapVariables.get(world).TypinPickaxeType = (double) 0;
				TeztDummiModModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3x3 Mode Off"), (true));
				}
			}
		}
	}
}
