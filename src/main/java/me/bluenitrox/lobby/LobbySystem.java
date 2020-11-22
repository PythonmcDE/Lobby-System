package me.bluenitrox.lobby;

import me.bluenitrox.lobby.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    public LobbySystem instance;

    @Override
    public void onEnable() {
        register(Bukkit.getPluginManager());
    }

    @Override
    public void onDisable() {

    }

    public void register(PluginManager pm){
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("build").setExecutor(new Build());
    }

    public LobbySystem getInstance() {
        return instance;
    }
}
