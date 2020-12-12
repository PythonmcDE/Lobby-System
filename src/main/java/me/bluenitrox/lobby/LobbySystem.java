package me.bluenitrox.lobby;

import me.bluenitrox.lobby.commands.*;
import me.bluenitrox.lobby.listener.InventoryClickEvent;
import me.bluenitrox.lobby.listener.PlayerInteractEvent;
import me.bluenitrox.lobby.listener.PlayerJoinListener;
import me.bluenitrox.lobby.listener.PlayerQuitListener;
import me.bluenitrox.lobby.mysql.MySQL;
import me.bluenitrox.lobby.mysql.MySQL_File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    public LobbySystem instance;

    @Override
    public void onEnable() {
        instance = this;
        startMySQL();
        register(Bukkit.getPluginManager());
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public void register(PluginManager pm){
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("build").setExecutor(new Build());

        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
        pm.registerEvents(new InventoryClickEvent(), this);
        pm.registerEvents(new PlayerInteractEvent(), this);
    }

    public void startMySQL(){
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();
        MySQL.connect();
    }

    public LobbySystem getInstance() {
        return instance;
    }
}
