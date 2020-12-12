package me.bluenitrox.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    @EventHandler
    public void onClick(final org.bukkit.event.inventory.InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        e.setCancelled(true);
        if(e.getClickedInventory().getName().equalsIgnoreCase("§8Wen möchtest du sehen?")){
            inventoryClick(e,p);
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§8Welches Gadget möchtest du auswählen?")){

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
        }
    }

}
