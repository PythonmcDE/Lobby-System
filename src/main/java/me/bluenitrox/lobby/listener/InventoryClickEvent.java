package me.bluenitrox.lobby.listener;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import me.bluenitrox.lobby.cases.CaseAPI;
import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.cases.CoinShop;
import me.bluenitrox.lobby.commands.Build;
import me.bluenitrox.lobby.commands.DailyReward;
import me.bluenitrox.lobby.manager.CosmeticManager;
import me.bluenitrox.lobby.manager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class InventoryClickEvent implements Listener {

    private final IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);

    @EventHandler
    public void onClick(final org.bukkit.event.inventory.InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        DailyReward dr = new DailyReward();
        if(!Build.build.contains(p)) {
            e.setCancelled(true);
        }
        if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6Spieler-Sichtbarkeit") && e.getCurrentItem() != null){
            inventoryClick(e,p);
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6§lCase-Opening") && e.getCurrentItem() != null){
            if(e.getCurrentItem().getType() == Material.DRAGON_EGG) {
                inventoryClickCase(p);
            }
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6Lobby wechseln") && e.getCurrentItem() != null){
            List<? extends ICloudPlayer> cloudPlayers = this.playerManager.getOnlinePlayers(p.getName());
            ICloudPlayer entry = cloudPlayers.get(0);
            String[] Lobby = e.getCurrentItem().getItemMeta().getDisplayName().split(" ");
            this.playerManager.getPlayerExecutor(entry).connect(Lobby[1]);
        }else if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6Navigator") && e.getCurrentItem() != null){
            if(e.getCurrentItem().getType() == Material.DRAGON_EGG){
                p.teleport(new LocationManager("caseopening").getLocation());
            }else if(e.getCurrentItem().getType() == Material.NETHER_STAR){
                p.teleport(new LocationManager("spawn").getLocation());
            }else if(e.getCurrentItem().getType() == Material.ARMOR_STAND){
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }else if(e.getCurrentItem().getType() == Material.BOOK_AND_QUILL){
                p.teleport(new LocationManager("school").getLocation());
            }else if(e.getCurrentItem().getType() == Material.EMERALD){
                p.teleport(new LocationManager("coinshop").getLocation());
            }
        }
        dr.dailyRewardClick(e);
        CosmeticManager.onClickInv(e);
        CosmeticManager.onClick(e);
        CoinShop.onClick(e);
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

    private void inventoryClickCase(Player p){
        CaseAPI api = new CaseAPI();
        CaseManager.update(p.getUniqueId(), 1, true, "cases");
        api.openCase(p, 0);
    }

}
