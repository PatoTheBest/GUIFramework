package com.minebone.guiframework.gui.inventory.page;

import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.itemstack.ItemStackBuilder;
import com.minebone.guiframework.gui.inventory.button.PlaceHolder;
import com.minebone.guiframework.gui.inventory.button.SimpleButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class GUIMultiPage<PluginType extends JavaPlugin> extends GUIPage<PluginType> {

    protected int currentPage;
    protected int pageSize = 44;

    public GUIMultiPage(PluginType plugin, Player player, String rawName) {
        this(plugin, player, rawName, 54);
    }

    public GUIMultiPage(PluginType plugin, Player player, String rawName, int size) {
        super(plugin, player, rawName, size);
    }

    public void buildPage() {
        ItemStack nextPage = new ItemStackBuilder().setMaterial(Material.PAPER).setStackAmount(currentPage + 2).setName(ChatColor.YELLOW + "Click to go to next page (page " + (currentPage + 2) + ")");
        ItemStack previousPage = new ItemStackBuilder().setMaterial(Material.PAPER).setStackAmount(currentPage).setName(ChatColor.YELLOW + "Click to go to previous page (page " + (currentPage) + ")");
        ItemStack currentPageItem = new ItemStackBuilder().setMaterial(Material.PAPER).setStackAmount(currentPage + 1).setName(ChatColor.YELLOW + "You are currently on page " + (currentPage + 1) + "");

        if ((currentPage + 1) * pageSize < getListCount()) {
            addButton(new SimpleButton<>(nextPage).setAction((player, core, guiPage) -> {currentPage++;refresh();}), 53);
        }

        if (currentPage != 0) {
            addButton(new SimpleButton<>(previousPage).setAction((player, core, guiPage) -> {currentPage--;refresh();}), 45);
        }

        if(getListCount() != -1) {
            addButton(new PlaceHolder(currentPageItem), 49);
        }
        buildContent();
    }

    protected abstract void buildContent();

    protected abstract int getListCount();

}
