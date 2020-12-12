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
                        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Spieler-Sichtbarkeit")){
                            playerVisibility(p);
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Navigator")){

                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Mein Profil")){

                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Gadgets")){
                            playerGadgets(p);
                        }
                    }
                }
            }
        }
    }

    private void playerVisibility(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*3, "§8Wen möchtest du sehen?");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)7).setDisplayname(" ").build();

        ItemStack jeden = new ItemBuilder(Material.WOOL, (short) 13).setDisplayname("§aJeden").build();
        ItemStack someone = new ItemBuilder(Material.WOOL, (short) 1).setDisplayname("§eNur Prime und Teammitglieder").build();
        ItemStack nobody = new ItemBuilder(Material.WOOL, (short) 14).setDisplayname("§cNiemanden").build();

        for(int i = 0; i<=26; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(10,jeden);
        inv.setItem(13,someone);
        inv.setItem(16,nobody);

        p.openInventory(inv);
    }

    private void playerGadgets(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*3, "§8Welches Gadget möchtest du auswählen?");

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
