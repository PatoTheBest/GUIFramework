package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.gui.inventory.GUIButton;
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
