package com.darktroll.skywars.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface InventoryGUI {
    Inventory inventoryInit();
    void fillItems();
    void onClick(InventoryClickEvent event);
}
