
package net.mcreator.teztdummimod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.teztdummimod.item.TeztDummiEssenceDustItem;

@TeztDummiModModElements.ModElement.Tag
public class RetardrecipeBrewingRecipe extends TeztDummiModModElements.ModElement {
	public RetardrecipeBrewingRecipe(TeztDummiModModElements instance) {
		super(instance, 205);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION, (int) (1))),
				Ingredient.fromStacks(new ItemStack(TeztDummiEssenceDustItem.block, (int) (1))), new ItemStack(Items.POTION, (int) (1)));
	}
}
