package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.manager.MessageManager;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropitemEvent implements Listener {

    @EventHandler
    public void onDrop(final PlayerDropItemEvent e){
        e.setCancelled(true);
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        e.getPlayer().sendMessage(MessageManager.PREFIX + "§7Du kannst §ckeine §7Items in der Lobby §cdroppen§7!");
    }

}
