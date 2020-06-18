package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIButton;
import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleButton<PluginType extends JavaPlugin> implements GUIButton<PluginType> {

    private ItemStack item;
    protected ButtonAction<PluginType> action;

    public SimpleButton(ItemStack item) {
        this.item = item;
    }

    public SimpleButton(ItemStack item, ButtonAction<PluginType> buttonAction) {
        this.item = item;
        this.action = buttonAction;
    }

    public SimpleButton<PluginType> action(ButtonAction<PluginType> action) {
        this.action = action;
        return this;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(ClickType clickType, GUIPage<PluginType> page) {
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
