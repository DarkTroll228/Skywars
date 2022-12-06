package com.darktroll.skywars;

import com.darktroll.skywars.commands.SkywarsGUICommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Skywars extends JavaPlugin {

    private static Skywars instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);
        saveDefaultConfig();

        getCommand("menu").setExecutor(new SkywarsGUICommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Skywars getInstance() {
        return instance;
    }
}
