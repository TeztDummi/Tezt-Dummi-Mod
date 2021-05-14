
package net.mcreator.teztdummimod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.teztdummimod.itemgroup.TeztDummiModItemGroup;
import net.mcreator.teztdummimod.TeztDummiModModElements;

@TeztDummiModModElements.ModElement.Tag
public class TheBestClipFromBFMIEverItem extends TeztDummiModModElements.ModElement {
	@ObjectHolder("tezt_dummi_mod:the_best_clip_from_bfmi_ever")
	public static final Item block = null;
	public TheBestClipFromBFMIEverItem(TeztDummiModModElements instance) {
		super(instance, 177);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TeztDummiModModElements.sounds.get(new ResourceLocation("tezt_dummi_mod:bestclipever")),
					new Item.Properties().group(TeztDummiModItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("the_best_clip_from_bfmi_ever");
		}
	}
}
