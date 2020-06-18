package me.patothebest.guiframework.example;

import me.patothebest.guiframework.gui.anvil.AnvilSlot;
import me.patothebest.guiframework.gui.inventory.GUIPage;
import me.patothebest.guiframework.gui.inventory.button.AnvilButton;
import me.patothebest.guiframework.gui.inventory.button.PlaceHolder;
import me.patothebest.guiframework.gui.inventory.button.SimpleButton;
import me.patothebest.guiframework.itemstack.ItemStackBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SimpleGUIExample extends GUIPage<MainClass> {

    public SimpleGUIExample(MainClass plugin, Player player) {
        super(plugin, player, "Testing the gui framework", 9);
        build();
    }

    @Override
    public void buildPage() {
        ItemStackBuilder simpleAction = new ItemStackBuilder().material(Material.TNT).name(ChatColor.RED + "A TNT");
        ItemStackBuilder anvilItem = new ItemStackBuilder().material(Material.ANVIL).name("AN ANVIL");
        ItemStackBuilder placeHolder = new ItemStackBuilder().material(Material.ITEM_FRAME).name(ChatColor.GREEN + "This is just a placeholder");

        addButton(new SimpleButton<>(simpleAction, (plugin1, player, page) -> player.sendMessage("Clicked on TNT")), 2);
        addButton(new AnvilButton<>(anvilItem).confirmAction((plugin1, player, event) -> {
            player.sendMessage("You typed " + event.getOutput());
            event.setWillClose(true);
        }).cancelAction((plugin1, player) -> player.sendMessage("You cancelled")).slot(AnvilSlot.INPUT_LEFT, anvilItem), 4);
        addButton(new PlaceHolder(placeHolder), 6);
    }
}
