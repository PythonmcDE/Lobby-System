package me.bluenitrox.lobby.listener;

import org.bukkit.WeatherType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChange implements Listener {

    @EventHandler
    public void onChange(final WeatherChangeEvent e){
        e.setCancelled(true);
    }

}
