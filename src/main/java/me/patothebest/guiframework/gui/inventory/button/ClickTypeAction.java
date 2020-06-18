package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.plugin.java.JavaPlugin;

@FunctionalInterface
public interface ClickTypeAction<PluginType extends JavaPlugin> {

    void onClick(PluginType plugin, Player player, ClickType clickType, GUIPage<PluginType> page);

}
