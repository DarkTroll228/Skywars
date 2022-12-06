package com.darktroll.skywars.commands;

import com.darktroll.skywars.gui.SkywarsGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkywarsGUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) return false;
        SkywarsGUI gui = new SkywarsGUI();
        Player player = (Player) sender;

        player.openInventory(gui.getInventory());
        return true;
    }
}
