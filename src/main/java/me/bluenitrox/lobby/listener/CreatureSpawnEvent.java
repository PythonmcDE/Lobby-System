package me.bluenitrox.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CreatureSpawnEvent implements Listener {

    @EventHandler
    public void onSpawn(final org.bukkit.event.entity.CreatureSpawnEvent e){
        e.setCancelled(true);
    }

}
