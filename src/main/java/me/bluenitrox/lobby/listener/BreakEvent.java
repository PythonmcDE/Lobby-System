package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.commands.Build;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakEvent implements Listener {

    @EventHandler
    public void onBreak(final BlockBreakEvent e){
        Player p = e.getPlayer();
        if(Build.build.contains(p)){

        }else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(Build.build.contains(p)){

        }else {
            e.setCancelled(true);
        }
    }

}
