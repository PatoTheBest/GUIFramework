package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public interface IncrementingButtonAction<PluginType extends JavaPlugin> {

    void onClick(PluginType plugin, Player player, GUIPage page, int amount);

}
