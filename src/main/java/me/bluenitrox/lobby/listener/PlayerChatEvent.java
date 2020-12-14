package me.bluenitrox.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e){
        String newmsg = e.getMessage().replace("%", "%%");
        e.setMessage(newmsg);

        e.setMessage(EmojiListener.replaceDoppelpunkt(newmsg, e.getPlayer().getUniqueId()));
        e.setFormat(e.getPlayer().getDisplayName() + " §8» §7" + e.getMessage());
    }

}
