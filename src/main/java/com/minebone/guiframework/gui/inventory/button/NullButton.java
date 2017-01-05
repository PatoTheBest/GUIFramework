package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.gui.inventory.GUIButton;
import org.bukkit.inventory.ItemStack;

public class NullButton implements GUIButton {

    @Override
    public void click(GUIPage page) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public ItemStack getItem() {
        return null;
    }
}
