package com.darktroll.skywars.data;

import com.darktroll.skywars.Skywars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class DataHandler {

    private static DataHandler instance = new DataHandler();
    private File gameInfoFile;
    private FileConfiguration gameInfo;

    private DataHandler() {
        this.gameInfoFile = new File(Skywars.getInstance().getDataFolder(), "gameInfo.yml");
        if(!this.gameInfoFile.exists()){
            try {
                this.gameInfoFile.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        this.gameInfo = YamlConfiguration.loadConfiguration(this.gameInfoFile);
    }

    public void saveGameInfo() {
        try {
            this.gameInfo.save(this.gameInfoFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataHandler getInstance() {
        return instance;
    }

    public FileConfiguration getGameInfo() {
        return gameInfo;
    }
}
