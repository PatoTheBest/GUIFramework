package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public interface IncrementingButtonAction<PluginType extends JavaPlugin> {

    void onClick(PluginType plugin, Player player, GUIPage page, int amount);

}
