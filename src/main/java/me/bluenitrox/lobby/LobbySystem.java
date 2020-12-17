package me.bluenitrox.lobby;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.lobby.manager.LocationManager;
import me.bluenitrox.lobby.mysql.MySQL;
import me.bluenitrox.lobby.mysql.MySQL_File;
import me.bluenitrox.lobby.utils.Multiplikator;
import me.bluenitrox.lobby.commands.*;
import me.bluenitrox.lobby.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class LobbySystem extends JavaPlugin {



    public static ArrayList<Player> p = new ArrayList<>();

    public static LobbySystem instance;

    @Override
    public void onEnable() {
        instance = this;
        startMySQL();
        register(Bukkit.getPluginManager());
        runnable();
    }

    @Override
    public void onDisable() {
        try(PreparedStatement ps1 = MySQL.getConnection().prepareStatement("DROP TABLE DailyReward")){
            ps1.executeUpdate();
        }catch (SQLException e){

        }
        MySQL.disconnect();
    }

    public void register(PluginManager pm){
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("coinshop").setExecutor(new CoinShopNPC());
        getCommand("build").setExecutor(new Build());
        getCommand("dailyreward").setExecutor(new DailyReward());

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
        pm.registerEvents(new EatEvent(), this);
        pm.registerEvents(new WeatherChange(), this);
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new BootsListener(), this);
        pm.registerEvents(new CreatureSpawnEvent(), this);
        pm.registerEvents(new Explode(), this);

        Multiplikator mp = new Multiplikator(this);
        mp.initialize();
    }

    public void runnable(){
        new BukkitRunnable(){
            @Override
            public void run() {
                p.clear();
            }
        }.runTaskTimerAsynchronously(this, 20*6,20*6);
        new BukkitRunnable(){

            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kill @e");
            }
        }.runTaskLaterAsynchronously(this, 20*10);
    }

    public void startMySQL(){
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();
        MySQL.connect();

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `spielerdaten` ( `UUID` VARCHAR(36) NOT NULL , `cases` INT(11) NOT NULL , PRIMARY KEY (`UUID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `locations` ( `name` VARCHAR(30) NOT NULL , `world` VARCHAR(30) NOT NULL , `x` DOUBLE NOT NULL , `y` DOUBLE NOT NULL , `z` DOUBLE NOT NULL , `yaw` FLOAT NOT NULL , `pitch` FLOAT NOT NULL , PRIMARY KEY (`name`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `bekleidung` ( `UUID` VARCHAR(36) NOT NULL , `daemonen` INT(11) NOT NULL , `drip` INT(11) NOT NULL, `flame` INT(11) NOT NULL, `zauberer` INT(11) NOT NULL, `schnee` INT(11) NOT NULL, `sprungkraft` INT(11) NOT NULL, `speed` INT(11) NOT NULL, `doublejump` INT(11) NOT NULL, PRIMARY KEY (`UUID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `gadgets` ( `UUID` VARCHAR(36) NOT NULL , `tnt` INT(11) NOT NULL , `enterhaken` INT(11) NOT NULL, `iron` INT(11) NOT NULL, `gold` INT(11) NOT NULL, `bannerblue` INT(11) NOT NULL, `bannerred` INT(11) NOT NULL, `bannergreen` INT(11) NOT NULL, `banneryellow` INT(11) NOT NULL, `bannergrey` INT(11) NOT NULL, `bannerblack` INT(11) NOT NULL, `bannerpink` INT(11) NOT NULL, `bannerorange` INT(11) NOT NULL, PRIMARY KEY (`UUID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `emotes` ( `UUID` VARCHAR(36) NOT NULL , `rightright` INT(11) NOT NULL , `leftleft` INT(11) NOT NULL, `rechts` INT(11) NOT NULL, `richtig` INT(11) NOT NULL, `x` INT(11) NOT NULL, `herz` INT(11) NOT NULL, `angry` INT(11) NOT NULL, `eye` INT(11) NOT NULL, `sad` INT(11) NOT NULL, `headphone` INT(11) NOT NULL, `idk` INT(11) NOT NULL,PRIMARY KEY (`UUID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `kopf` ( `UUID` VARCHAR(36) NOT NULL , `gomme` INT(11) NOT NULL , `benx` INT(11) NOT NULL, `palle` INT(11) NOT NULL, `glp` INT(11) NOT NULL, `abge` INT(11) NOT NULL, `logo` INT(11) NOT NULL,PRIMARY KEY (`UUID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `DailyReward` ( `UUID` CHAR(36) NOT NULL , `Belohnung` INT(11) NOT NULL");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public static LobbySystem getInstance() {
        return instance;
    }
}
