package me.bluenitrox.lobby.utils;

import me.bluenitrox.lobby.LobbySystem;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Multiplikator {
    private File multiplikator;
    private FileConfiguration cfg;

    public Multiplikator(LobbySystem plugin) {
        this.initialize();
    }

    public void initialize() {
        this.multiplikator = new File("plugins/Doppelsprung", "multiplikator.yml");
        this.cfg = YamlConfiguration.loadConfiguration(this.multiplikator);
        this.cfg.options().header("In dieser Datei kannst du einstellen, wie hoch bzw. wie weit\ndie Spieler durch einen Doppelsprung 'fliegen'\nNormalerweise reichen Werte zwischen 1.0 und 2.5 vollkommen aus\nProbiert einfach ein bisschen aus...");
        if (!this.cfg.contains("mulitplikator")) {
            this.cfg.createSection("mulitplikator");
            this.cfg.set("mulitplikator", 1.2D);
            this.cfg.options().copyDefaults(true);

            try {
                this.cfg.save(this.multiplikator);
            } catch (IOException var2) {
                var2.printStackTrace();
            }

        }
    }

    public double getMultiplier() {
        this.initialize();
        return this.cfg.getDouble("mulitplikator");
    }
}