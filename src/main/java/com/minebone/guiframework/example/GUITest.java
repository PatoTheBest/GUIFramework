package com.minebone.guiframework.example;

import com.minebone.guiframework.gui.anvil.AnvilSlot;
import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.gui.inventory.button.AnvilButton;
import com.minebone.guiframework.gui.inventory.button.PlaceHolder;
import com.minebone.guiframework.gui.inventory.button.SimpleButton;
import com.minebone.guiframework.itemstack.ItemStackBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GUITest extends GUIPage<MainClass> {

    public GUITest(MainClass plugin, Player player) {
        super(plugin, player, "Testing the gui framework", 9);
        build();
    }

    @Override
    public void buildPage() {
        ItemStackBuilder simpleAction = new ItemStackBuilder().setMaterial(Material.TNT).setName(ChatColor.RED + "A TNT");
        ItemStackBuilder anvilItem = new ItemStackBuilder().setMaterial(Material.ANVIL).setName("AN ANVIL");
        ItemStackBuilder placeHolder = new ItemStackBuilder().setMaterial(Material.ITEM_FRAME).setName(ChatColor.GREEN + "This is just a placeholder");

        addButton(new SimpleButton<>(simpleAction, (plugin1, player, page) -> player.sendMessage("Clicked on TNT")), 2);
        addButton(new AnvilButton<>(anvilItem).setConfirmAction((plugin1, player, event) -> {
            player.sendMessage("You typed " + event.getOutput());
            event.setWillClose(true);
        }).setCancelAction((plugin1, player) -> player.sendMessage("You cancelled")).setSlot(AnvilSlot.INPUT_LEFT, anvilItem), 4);
        addButton(new PlaceHolder(placeHolder), 6);
    }

    @Override
    public void destroy() {

    }
}
