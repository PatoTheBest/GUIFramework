package me.patothebest.guiframework.gui.inventory.page;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.itemstack.ItemStackBuilder;
import me.patothebest.guiframework.gui.inventory.button.PlaceHolder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class SuccessPage<PluginType extends JavaPlugin> extends GUIPage<PluginType> {

    public SuccessPage(PluginType plugin, Player player) {
        super(plugin, player, "Success!", 54);
        build();
    }

    public SuccessPage(PluginType plugin, Player player, boolean b) {
        super(plugin, player, "Success!", 54, true);
        build();
    }

    public void buildPage() {
        ItemStack confirm = new ItemStackBuilder().material(Material.EMERALD_BLOCK).name(ChatColor.GREEN + "Success!");
        for (int i = 0; i < 54; i++) {
            addButton(new PlaceHolder(confirm), i);
        }

    }

    public void onInventoryCloseOverride() {
        onCloseInventory();
    }

    public void destroy() {
    }

    public void onCloseInventory() {}

}
