
package net.mcreator.teztdummimod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

@TeztDummiModModElements.ModElement.Tag
public class TeztaniumSwordItem extends TeztDummiModModElements.ModElement {
	@ObjectHolder("tezt_dummi_mod:teztanium_sword")
	public static final Item block = null;
	public TeztaniumSwordItem(TeztDummiModModElements instance) {
		super(instance, 16);
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
				return 10f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TeztaniumItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(TeztDummiModItemGroup.tab)) {
		}.setRegistryName("teztanium_sword"));
	}
}
