package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.gui.inventory.GUIButton;
import org.bukkit.inventory.ItemStack;

public class CloseButton implements GUIButton {

    private ItemStack item;

    public CloseButton(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(GUIPage page) {
        page.getPlayer().closeInventory();
    }

    public void destroy() {
        this.item = null;
    }

}