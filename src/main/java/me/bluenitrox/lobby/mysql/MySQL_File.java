package me.bluenitrox.lobby.mysql;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MySQL_File {

    public void setdefault() {
        FileConfiguration cfg = getFileConfiguration();

        cfg.options().copyDefaults(true);
        cfg.addDefault("host", "localhost");
        cfg.addDefault("port", "3306");
        cfg.addDefault("database", "Lobby");
        cfg.addDefault("username", "developer");
        cfg.addDefault("password", "8u9Nq6ACGdLYAu5KntjO");


        try {
            cfg.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        return new File("plugins//ValoraMC", "mysql.yml");
    }

    private FileConfiguration getFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void readData() {
        FileConfiguration cfg = getFileConfiguration();
        MySQL.host = cfg.getString("host");
        MySQL.port = cfg.getString("port");
        MySQL.database = cfg.getString("database");
        MySQL.username = cfg.getString("username");
        MySQL.password = cfg.getString("password");
    }
}

