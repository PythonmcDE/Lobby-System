package me.bluenitrox.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e){
        e.getMessage().replace("%", "%%");
        e.setFormat(e.getPlayer().getDisplayName() + " §8» §7" + e.getMessage());
    }

}
