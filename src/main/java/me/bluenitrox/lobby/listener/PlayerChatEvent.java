package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.manager.ScoreboardManager;
import me.bluenitrox.lobby.manager.TablistManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e){
        String newmsg = e.getMessage().replace("%", "%%");
        e.setMessage(newmsg);

        LuckPerms luckPerms = LuckPermsProvider.get();

        e.setMessage(EmojiListener.replaceDoppelpunkt(newmsg, e.getPlayer().getUniqueId()));
        e.setFormat(new TablistManager(luckPerms).getPlayerGroup(e.getPlayer()) + e.getPlayer().getDisplayName() + " §8» §7" + e.getMessage());
    }

}
