package net.mcreator.teztdummimod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import net.mcreator.teztdummimod.entity.PenguinPillowEntity;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@TeztDummiModModElements.ModElement.Tag
public class PenginPillowFlapOnKeyPressedProcedure extends TeztDummiModModElements.ModElement {
	public PenginPillowFlapOnKeyPressedProcedure(TeztDummiModModElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PenginPillowFlapOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PenginPillowFlapOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PenginPillowFlapOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PenginPillowFlapOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PenginPillowFlapOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isPassenger())) {
			if ((((Entity) world
					.getEntitiesWithinAABB(PenguinPillowEntity.CustomEntity.class,
							new AxisAlignedBB(x - (0.1 / 2d), y - (0.1 / 2d), z - (0.1 / 2d), x + (0.1 / 2d), y + (0.1 / 2d), z + (0.1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)) {
				(entity.getRidingEntity()).setMotion(((entity.getRidingEntity()).getMotion().getX()), 1,
						((entity.getRidingEntity()).getMotion().getZ()));
			}
		}
	}
}
