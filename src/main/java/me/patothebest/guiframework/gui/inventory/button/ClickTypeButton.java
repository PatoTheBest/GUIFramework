package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIButton;
import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ClickTypeButton<PluginType extends JavaPlugin> implements GUIButton<PluginType> {

    private ItemStack item;
    protected ClickTypeAction<PluginType> action;

    public ClickTypeButton(ItemStack item) {
        this.item = item;
    }

    public ClickTypeButton(ItemStack item, ClickTypeAction<PluginType> buttonAction) {
        this.item = item;
        this.action = buttonAction;
    }

    public ClickTypeButton<PluginType> action(ClickTypeAction<PluginType> action) {
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

        action.onClick(page.getPlugin(), page.getPlayer(), clickType, page);
    }

    public void destroy() {
        this.action = null;
        this.item = null;
    }
}