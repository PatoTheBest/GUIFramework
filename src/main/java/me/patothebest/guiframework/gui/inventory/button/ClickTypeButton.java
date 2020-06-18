package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIButton;
import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickTypeButton implements GUIButton {

    private ItemStack item;
    protected ClickTypeAction action;

    public ClickTypeButton(ItemStack item) {
        this.item = item;
    }

    public ClickTypeButton(ItemStack item, ClickTypeAction buttonAction) {
        this.item = item;
        this.action = buttonAction;
    }

    public ClickTypeButton action(ClickTypeAction action) {
        this.action = action;
        return this;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(ClickType clickType, GUIPage page) {
        if(action == null) {
            return;
        }

        action.onClick(clickType);
    }

    public void destroy() {
        this.action = null;
        this.item = null;
    }
}
