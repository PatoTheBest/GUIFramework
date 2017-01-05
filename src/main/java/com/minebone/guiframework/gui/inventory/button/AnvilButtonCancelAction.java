package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.anvil.AnvilClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public interface AnvilButtonCancelAction<PluginType extends JavaPlugin> {

    void onCancel(PluginType plugin, Player player);

}
