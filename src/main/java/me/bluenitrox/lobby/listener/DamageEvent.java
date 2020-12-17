package me.bluenitrox.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onDamage(final EntityDamageEvent e){
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

}
