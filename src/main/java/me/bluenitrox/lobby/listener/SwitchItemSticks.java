package me.bluenitrox.lobby.listener;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class SwitchItemSticks implements Listener {

    @EventHandler
    public void onSwitch(final PlayerItemHeldEvent e){
        if(e.getPreviousSlot() != e.getNewSlot()){
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_STICKS, 1L ,1L);
        }
    }

}
