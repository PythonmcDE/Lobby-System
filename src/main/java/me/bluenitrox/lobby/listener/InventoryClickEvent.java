package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.commands.Build;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    @EventHandler
    public void onClick(final org.bukkit.event.inventory.InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(!Build.build.contains(p)) {
            e.setCancelled(true);
        }
        if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6Spieler-Sichtbarkeit")){
            inventoryClick(e,p);
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6Cosmetics")){

        }
    }

    private void inventoryClick(final org.bukkit.event.inventory.InventoryClickEvent e, Player p){
        if(e.getCurrentItem().getType() == Material.WOOL){
            if(e.getCurrentItem().getDurability() == 13){
                for(Player all: Bukkit.getOnlinePlayers()){
                    p.showPlayer(all);
                }
            }else if(e.getCurrentItem().getDurability() == 1){
                for(Player all: Bukkit.getOnlinePlayers()){
                    p.showPlayer(all);
                    if(!all.hasPermission("Lobby.show")) {
                        p.hidePlayer(all);
                    }
                }
            }else if(e.getCurrentItem().getDurability() == 14){
                for(Player all: Bukkit.getOnlinePlayers()){
                    p.hidePlayer(all);
                }
            }
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
            p.closeInventory();
        }
    }

}
