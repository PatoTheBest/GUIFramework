package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.gui.inventory.page.ConfirmationPage;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfirmButton<PluginType extends JavaPlugin> extends SimpleButton<PluginType> {

    private ItemStack item1;
    private ItemStack item2;

    public ConfirmButton(ItemStack item, ItemStack item1, ItemStack item2) {
        super(item);
        this.item1 = item1;
        this.item2 = item2;
    }

    public ConfirmButton(ItemStack item, ItemStack item1, ItemStack item2, ButtonAction<PluginType> buttonAction) {
        super(item, buttonAction);
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public void click(ClickType clickType, GUIPage<PluginType> page) {
        new ConfirmationPage<PluginType>(page.getPlugin(), page.getPlayer(), item1, item2) {
            @Override
            public void onConfirm() {
                if(action == null) {
                    return;
                }

                action.onClick(page.getPlugin(), page.getPlayer(), page);
            }

            @Override
            public void onCancel() {
                getPlayer().closeInventory();
            }
        };
    }
}