package me.patothebest.guiframework.example;

import me.patothebest.guiframework.gui.anvil.AnvilSlot;
import me.patothebest.guiframework.gui.inventory.GUIButton;
import me.patothebest.guiframework.gui.inventory.button.AnvilButton;
import me.patothebest.guiframework.gui.inventory.button.SimpleButton;
import me.patothebest.guiframework.gui.inventory.page.StaticPaginatedUI;
import me.patothebest.guiframework.itemstack.ItemStackBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class StaticPaginatedGUIExample extends StaticPaginatedUI<Material, MainClass> {

    public StaticPaginatedGUIExample(MainClass plugin, Player player) {
        super(plugin, player, "Testing the gui framework", () -> Compatibility.COMPATIBLE_MATERIALS);
        build();
    }

    public StaticPaginatedGUIExample(MainClass plugin, Player player, String filter) {
        super(plugin, player, "Testing the gui framework", () -> Compatibility.COMPATIBLE_MATERIALS
                .stream()
                .filter(material -> material.name().contains(filter.toUpperCase()))
                .collect(Collectors.toList()));
        build();
    }

    @Override
    protected GUIButton<MainClass> createButton(Material material) {
        return new SimpleButton<MainClass>(new ItemStackBuilder(material).lore(ChatColor.GREEN + "Click to get!")).action((plugin, player, page) -> {
            player.getInventory().addItem(new ItemStackBuilder(material));
        });
    }

    @Override
    protected void buildFooter() {
        addButton(new AnvilButton<MainClass>(new ItemStackBuilder().material(Material.BOOK).name("Filter"))
                .confirmAction((plugin, player, event) -> {
                    new StaticPaginatedGUIExample(plugin, player, event.getOutput());
                }).cancelAction(StaticPaginatedGUIExample::new)
                .slot(AnvilSlot.INPUT_LEFT, new ItemStackBuilder().material(Material.BOOK).name("Dirt")), 51);
    }
}
