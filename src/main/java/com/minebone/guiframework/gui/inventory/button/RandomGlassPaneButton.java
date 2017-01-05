package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIButton;
import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.itemstack.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RandomGlassPaneButton implements GUIButton {


    public RandomGlassPaneButton(final GUIPage page, int slot) {
    }

    @Override
    public void click(GUIPage page) {

    }

    @Override
    public ItemStack getItem() {
        return new ItemStackBuilder(Material.STAINED_GLASS_PANE).setName(" ").setStackData((short) 0);
    }

    @Override
    public void destroy() {

    }
}
