package me.bluenitrox.lobby.cases;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.permission.IPermissionUser;
import me.bluenitrox.lobby.manager.MessageManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.pythonmc.coins.api.CoinsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CoinShop {

    public static void onClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6§lCoin-Shop") && e.getCurrentItem() != null){
            UUID uuid = e.getWhoClicked().getUniqueId();
            Player p = (Player)e.getWhoClicked();
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lLobby Case")){
                /*if(Database.getCoins(uuid) > 10000){
                    CaseManager.update(uuid, 1, false, "cases");
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast gerade eine §6§lLobby-Case §7gekauft!");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    Database.update(uuid, 10000, true);
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.PREFIX + "§7Dazu hast du §cnicht §7genug Geld!");
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lCoinmaster Kit")){
                if(Database.getCoins(uuid) > 15000){
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast gerade das §6§lCoinmaster-Kit §7gekauft!");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    Database.update(uuid, 15000, true);
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.PREFIX + "§7Dazu hast du §cnicht §7genug Geld!");
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lPrime Rang §8(§77Tage§8)")){
                if(Database.getCoins(uuid) > 40000){
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast gerade den §6§lPrime-Rang §7gekauft. Joine erneut auf den Server um ihn §afreizuschalten§7!");
                    IPermissionUser permissionUser = CloudNetDriver.getInstance().getPermissionManagement().getUser(uuid);
                    assert permissionUser != null;
                    permissionUser.addGroup("Prime", 7, TimeUnit.DAYS);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    new CoinsAPI().removeCoins(uuid, 40000,);
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.PREFIX + "§7Dazu hast du §cnicht §7genug Geld!");
                }*/
            }
        }
    }

    public Inventory coinshop(){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§8» §6§lCoin-Shop");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCoins").setLore("§6§l▶ §7Du kannst §eCoins §7aus §6Lobby Cases§7,", "§6§l▶ §7oder in §6School §7erhalten.").build();

        ItemStack egg = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§6§lLobby Case").setLore("§8» §7Kaufen: §610 Tsd Coins").build();
        ItemStack flower = new ItemBuilder(Material.DOUBLE_PLANT,(short)0).setDisplayname("§6§lCoinmaster Kit").setLore("§8» §7Kaufen: §615 Tsd Coins").build();
        ItemStack helm = new ItemBuilder(Material.GOLD_HELMET).setDisplayname("§6§lPrime Rang §8(§77Tage§8)").setLore("§8» §7Kaufen: §640 Tsd Coins").build();

        for(int i = 0; i<= 8 ; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<= 44 ; i++){
            inv.setItem(i, glas);
        }
        for(int i = 45; i<= 53 ; i++){
            inv.setItem(i, glasblack);
        }
        inv.setItem(49, sign);

        inv.setItem(20,egg);
        inv.setItem(22,flower);
        inv.setItem(24,helm);

        return inv;
    }

}
