package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.itemstack.ItemStackBuilder;
import me.patothebest.guiframework.gui.inventory.GUIButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class IncrementingButton<PluginType extends JavaPlugin> implements GUIButton<PluginType> {

    private final ItemStack item;
    private int amount;
    private IncrementingButtonAction<PluginType> action;

    public IncrementingButton(ItemStackBuilder item, int amount) {
        this.item = item.setStackAmount(Math.abs(amount));
    }

    public IncrementingButton(ItemStackBuilder item, int amount, IncrementingButtonAction<PluginType> buttonAction) {
        this.item = item.setStackAmount(Math.abs(amount));
        this.action = buttonAction;
    }

    public IncrementingButton(int amount, IncrementingButtonAction<PluginType> buttonAction) {
        this.item = new ItemStackBuilder().setMaterial(Material.STAINED_GLASS_PANE).setStackAmount(Math.abs(amount)).setStackData((short) (amount < 0 ? 14 : 5)).setName((amount < 0 ? ChatColor.RED : ChatColor.GREEN).toString() + amount);
        this.amount = amount;
        this.action = buttonAction;
    }

    public IncrementingButton setAction(IncrementingButtonAction<PluginType> action) {
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

        action.onClick(page.getPlugin(), page.getPlayer(), page, amount);
    }

    public void destroy() {
    }
}
