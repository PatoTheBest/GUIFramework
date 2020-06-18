package me.patothebest.guiframework.gui.inventory.button;

import me.patothebest.guiframework.gui.inventory.GUIPage;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.plugin.Plugin;

@FunctionalInterface
public interface ClickTypeAction {

    void onClick(Plugin plugin, Player player, ClickType clickType, GUIPage page);

}
