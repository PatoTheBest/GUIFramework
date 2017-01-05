package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIButton;
import com.minebone.guiframework.gui.inventory.GUIPage;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleButton<PluginType extends JavaPlugin> implements GUIButton<PluginType> {

    private ItemStack item;
    private ButtonAction<PluginType> action;

    public SimpleButton(ItemStack item) {
        this.item = item;
    }

    public SimpleButton(ItemStack item, ButtonAction<PluginType> buttonAction) {
        this.item = item;
        this.action = buttonAction;
    }

    public SimpleButton<PluginType> setAction(ButtonAction<PluginType> action) {
        this.action = action;
        return this;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(GUIPage<PluginType> page) {
        if(action == null) {
            return;
        }

        action.onClick(page.getPlugin(), page.getPlayer(), page);
    }

    public void destroy() {
        this.action = null;
        this.item = null;
    }
}
