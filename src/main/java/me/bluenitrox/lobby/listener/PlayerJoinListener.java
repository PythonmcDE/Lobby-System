package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.manager.LocationManager;
import me.bluenitrox.lobby.manager.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e){
        Player p = (Player)e.getPlayer();
        e.setJoinMessage(null);
        p.teleport(new LocationManager("spawn").getLocation());
        ScoreboardManager.setBoard(p);
    }

}
