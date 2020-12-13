package me.bluenitrox.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EatEvent implements Listener {

    @EventHandler
    public void onEat(final FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

}
