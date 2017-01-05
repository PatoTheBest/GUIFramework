package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.gui.inventory.GUIButton;
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
