package me.bluenitrox.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(final PlayerQuitEvent e){
        Player p = (Player)e.getPlayer();
        e.setQuitMessage(null);
        
    }

}
