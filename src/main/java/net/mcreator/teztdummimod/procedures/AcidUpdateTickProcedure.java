package net.mcreator.teztdummimod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Blocks;

import net.mcreator.teztdummimod.block.AcidBlock;
import net.mcreator.teztdummimod.TeztDummiModModElements;
import net.mcreator.teztdummimod.TeztDummiModMod;

import java.util.Map;

@TeztDummiModModElements.ModElement.Tag
public class AcidUpdateTickProcedure extends TeztDummiModModElements.ModElement {
	public AcidUpdateTickProcedure(TeztDummiModModElements instance) {
		super(instance, 226);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency x for procedure AcidUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency y for procedure AcidUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency z for procedure AcidUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TeztDummiModMod.LOGGER.warn("Failed to load dependency world for procedure AcidUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
					SoundCategory.NEUTRAL, (float) 0.1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")),
					SoundCategory.NEUTRAL, (float) 0.1, (float) 1, false);
		}
		if (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.4)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + (-1)), (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))))).getBlock() == AcidBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))))).getBlock() == Blocks.BEDROCK.getDefaultState()
						.getBlock())) == (false))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (-1))), Blocks.AIR.getDefaultState(), 3);
			}
		}
	}
}
