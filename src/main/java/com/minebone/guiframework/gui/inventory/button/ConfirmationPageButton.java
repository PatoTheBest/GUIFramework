package com.minebone.guiframework.gui.inventory.button;

import com.minebone.guiframework.gui.inventory.GUIPage;
import com.minebone.guiframework.gui.inventory.page.ConfirmationPage;
import com.minebone.guiframework.gui.inventory.GUIButton;
import org.bukkit.inventory.ItemStack;

public class ConfirmationPageButton implements GUIButton {

    private ItemStack item;
    private final boolean isConfirm;

    public ConfirmationPageButton(boolean isConfirm, ItemStack item) {
        this.item = item;
        this.isConfirm = isConfirm;
    }

    public ItemStack getItem() {
        return item;
    }

    public void click(GUIPage page) {
        ConfirmationPage confirmationPage = (ConfirmationPage) page;
        if (isConfirm) {
            confirmationPage.onConfirm();
        } else {
            confirmationPage.onCancel();
        }
    }

    public void destroy() {
        this.item = null;
    }

}
