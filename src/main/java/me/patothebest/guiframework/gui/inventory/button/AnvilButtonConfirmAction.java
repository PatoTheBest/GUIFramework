package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.anvil.AnvilClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public interface AnvilButtonConfirmAction {

    void onConfirm(Plugin plugin, Player player, AnvilClickEvent event);

}
