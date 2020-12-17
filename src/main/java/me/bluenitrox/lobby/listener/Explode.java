package me.bluenitrox.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class Explode implements Listener {

    @EventHandler
    public void onExplo(final BlockExplodeEvent e){
        e.setCancelled(true);
    }

}
