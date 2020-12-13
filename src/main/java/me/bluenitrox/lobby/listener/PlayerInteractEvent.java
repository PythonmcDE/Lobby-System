package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(final org.bukkit.event.player.PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getPlayer().getItemInHand() != null){
                if(e.getPlayer().getItemInHand().getItemMeta() != null){
                    if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
                        e.setCancelled(true);
                        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Spieler-Sichtbarkeit")){
                            playerVisibility(p);
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Navigator")){

                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Freunde")){
                            p.chat("/friendgui");
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Cosmetics")){
                            playerGadgets(p);
                        }
                    }
                }
            }
        }
    }

    private void playerVisibility(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§8» §6Spieler-Sichtbarkeit");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6Wähle aus..").setLore("§8● §7Wähle aus wen du in der Lobby sehen möchtest.", " ", "§cInfo:", "§8● §7Wenn du §bPrime§7 nimmst siehst du alle Spieler die §bPrime", "§8● §7oder höher haben.").build();

        ItemStack jeden = new ItemBuilder(Material.WOOL, (short) 13).setDisplayname("§aJeden").build();
        ItemStack someone = new ItemBuilder(Material.WOOL, (short) 1).setDisplayname("§eNur Premium und Teammitglieder").build();
        ItemStack nobody = new ItemBuilder(Material.WOOL, (short) 14).setDisplayname("§cNiemanden").build();

        for(int i = 0; i<=8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i<=44; i++){
            inv.setItem(i,glas);
        }
        for(int i = 45; i<=53; i++){
            inv.setItem(i,glasblack);
        }

        inv.setItem(19,jeden);
        inv.setItem(22,someone);
        inv.setItem(25,nobody);
        inv.setItem(49,sign);

        p.openInventory(inv);
    }

    private void playerGadgets(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*3, "§8» §6Cosmetics");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)7).setDisplayname(" ").build();

        ItemStack diamondboots = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§8» §6§lEffektrüstung").build();
        ItemStack emotes = new ItemBuilder(Material.MAP).setDisplayname("§8» §6§lDeine Emotes").build();
        ItemStack banner = new ItemBuilder(Material.BANNER,(short)1).setDisplayname("§8» §6§lDeine Banner").build();
        ItemStack gadgets = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§8» §6§lDeine Gadgets").build();

        for(int i = 0; i<= 26; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(10, diamondboots);
        inv.setItem(12,emotes);
        inv.setItem(14,banner);
        inv.setItem(16,gadgets);

        p.openInventory(inv);
    }

}
