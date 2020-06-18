package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.gui.inventory.GUIButton;
import org.bukkit.inventory.ItemStack;

public class PlaceHolder implements GUIButton {

    private ItemStack item;

    public PlaceHolder(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(GUIPage page) {
    }

    public void destroy() {
        this.item = null;
    }

}
