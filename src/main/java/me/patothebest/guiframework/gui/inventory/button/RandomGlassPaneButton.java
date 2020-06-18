package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIButton;
import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.itemstack.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RandomGlassPaneButton implements GUIButton {


    public RandomGlassPaneButton(final GUIPage page, int slot) {
    }

    @Override
    public void click(GUIPage page) {

    }

    @Override
    public ItemStack getItem() {
        return new ItemStackBuilder(Material.STAINED_GLASS_PANE).setName(" ").setStackData((short) 0);
    }

    @Override
    public void destroy() {

    }
}
