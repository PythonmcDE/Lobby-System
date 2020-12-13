package me.bluenitrox.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

public class AchievmentEvent implements Listener {

    @EventHandler
    public void onAchiev(final PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }

}
