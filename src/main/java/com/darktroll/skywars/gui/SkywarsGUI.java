package com.darktroll.skywars.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
public class SkywarsGUI implements InventoryGUI, Listener {
    private Inventory inventory;
    private HashMap<String, ItemStack> items;

    public SkywarsGUI() {
        inventoryInit();
        fillItems();
    }

    @Override
    public Inventory inventoryInit() {
        Inventory inventory = Bukkit.createInventory(null, 27, "Skywars menu");
        this.inventory = inventory;
        return inventory;
    }

    @Override
    public void fillItems() {
        ItemStack sw_solo = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta meta = sw_solo.getItemMeta();
        meta.setDisplayName("Skywars solo");
        sw_solo.setItemMeta(meta);

        inventory.setItem(9, sw_solo);

        items.put("sw_solo", sw_solo);
    }

    @Override
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getInventory().equals(this.inventory)) {
            if(event.getCurrentItem().equals(items.get("sw_solo"))) {
                player.sendMessage("Game is starting...");
            }
            event.setCancelled(true);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
