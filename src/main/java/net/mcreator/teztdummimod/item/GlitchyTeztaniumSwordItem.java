
package net.mcreator.teztdummimod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.teztdummimod.procedures.GlitchyTeztaniumSwordLivingEntityIsHitWithToolProcedure;
import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

import java.util.Map;
import java.util.HashMap;

@TeztDummiModModElements.ModElement.Tag
public class GlitchyTeztaniumSwordItem extends TeztDummiModModElements.ModElement {
	@ObjectHolder("tezt_dummi_mod:glitchy_teztanium_sword")
	public static final Item block = null;
	public GlitchyTeztaniumSwordItem(TeztDummiModModElements instance) {
		super(instance, 142);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 16f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(GlitchyTeztaniumItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(TeztDummiModItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					GlitchyTeztaniumSwordLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("glitchy_teztanium_sword"));
	}
}
