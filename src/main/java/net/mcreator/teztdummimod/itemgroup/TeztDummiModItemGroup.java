
package net.mcreator.teztdummimod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.teztdummimod.block.TeztaniumBlockBlock;
import net.mcreator.teztdummimod.TeztDummiModModElements;

@TeztDummiModModElements.ModElement.Tag
public class TeztDummiModItemGroup extends TeztDummiModModElements.ModElement {
	public TeztDummiModItemGroup(TeztDummiModModElements instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtezt_dummi_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TeztaniumBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
