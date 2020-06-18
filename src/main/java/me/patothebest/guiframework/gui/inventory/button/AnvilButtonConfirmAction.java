package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.anvil.AnvilClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public interface AnvilButtonConfirmAction<PluginType extends JavaPlugin> {

    void onConfirm(PluginType plugin, Player player, AnvilClickEvent event);

}
