package com.darktroll.skywars.game;

import org.bukkit.entity.Player;

public class GamePlayer {

    private Player player = null;
    private GameTeam team = null;
    private GamePlayerState gamePlayerState;

    public GamePlayer(Player player) {
        this.player = player;
    }

    public GamePlayer(GameTeam team) {
        this.team = team;
    }

    public enum GamePlayerState {

    }

    public boolean isTeamGame(){
        return team != null && player == null;
    }

    public Player getPlayer() {
        return player;
    }

    public GameTeam getTeam() {
        return team;
    }
}
