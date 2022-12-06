package com.darktroll.skywars.game;

import com.darktroll.skywars.data.DataHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Set;

public class Game {

    // Basic config options
    private int minPlayers;
    private int maxPlayers;
    private World world;
    private Set<Location> spawnPoints;
    private boolean isTeamGame;

    // Active game information
    private String gameName;
    private Set<GamePlayer> players;
    private Set<GamePlayer> spectators;
    private GameState gameState = GameState.LOBBY;


    public Game(String gameName) {
        FileConfiguration configuration = DataHandler.getInstance().getGameInfo();
        this.minPlayers = configuration.getInt("games." + gameName + ".minPlayers");
        this.maxPlayers = configuration.getInt("games." + gameName + ".maxPlayers");
        this.world = Bukkit.createWorld(new WorldCreator("games." + gameName + ".world"));
        for(String point : configuration.getStringList("games." + gameName + ".spawnPoints")) {
            try{
                String[] values = point.split(",");
                double x = Double.parseDouble(values[0].split(":")[1]);
                double y = Double.parseDouble(values[1].split(":")[1]);
                double z = Double.parseDouble(values[2].split(":")[1]);
                Location location = new Location(world, x, y, z);
                spawnPoints.add(location);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.isTeamGame = configuration.getBoolean("games." + gameName + ".isTeamGame");

        this.isTeamGame = configuration.getBoolean("games." + gameName + ".isTeamGame");
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public World getWorld() {
        return world;
    }

    public Set<Location> getSpawnPoints() {
        return spawnPoints;
    }

    public boolean isTeamGame() {
        return isTeamGame;
    }

    public String getGameName() {
        return gameName;
    }

    public Set<GamePlayer> getPlayers() {
        return players;
    }

    public Set<GamePlayer> getSpectators() {
        return spectators;
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean isState(GameState state) {
        return getGameState() == state;
    }

    public enum GameState{
        LOBBY, STARTING, ACTIVE, DEATHMATCH, ENDING
    }
}
