package me.bluenitrox.lobby;

import me.bluenitrox.lobby.commands.*;
import me.bluenitrox.lobby.listener.*;
import me.bluenitrox.lobby.mysql.MySQL;
import me.bluenitrox.lobby.mysql.MySQL_File;
import me.bluenitrox.lobby.utils.Multiplikator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LobbySystem extends JavaPlugin {

    public static LobbySystem instance;

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
        pm.registerEvents(new PlayerFishEvent(), this);
        pm.registerEvents(new PlayerToggleFlightEvent(), this);
        pm.registerEvents(new PlayerDropitemEvent(), this);
        pm.registerEvents(new SwitchItemSticks(), this);
        pm.registerEvents(new AchievmentEvent(), this);
        pm.registerEvents(new BreakEvent(), this);
        pm.registerEvents(new DamageEvent(), this);

        Multiplikator mp = new Multiplikator(this);
        mp.initialize();
    }

    public void startMySQL(){
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();
        MySQL.connect();

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `locations` ( `name` VARCHAR(30) NOT NULL , `world` VARCHAR(30) NOT NULL , `x` DOUBLE NOT NULL , `y` DOUBLE NOT NULL , `z` DOUBLE NOT NULL , `yaw` FLOAT NOT NULL , `pitch` FLOAT NOT NULL , PRIMARY KEY (`name`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static LobbySystem getInstance() {
        return instance;
    }
}
