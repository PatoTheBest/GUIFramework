package me.patothebest.guiframework.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("I'm sorry, this command can only be executed by players!");
            return false;
        }

        new MainGUIExample(this, (Player) sender);
        return true;
    }
}
