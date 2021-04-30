
package net.mcreator.teztdummimod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

@TeztDummiModModElements.ModElement.Tag
public class PenguinBeefItem extends TeztDummiModModElements.ModElement {
	@ObjectHolder("tezt_dummi_mod:cooked_penguin")
	public static final Item block = null;
	public PenguinBeefItem(TeztDummiModModElements instance) {
		super(instance, 144);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TeztDummiModItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(8).saturation(12.8f).meat().build()));
			setRegistryName("cooked_penguin");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
