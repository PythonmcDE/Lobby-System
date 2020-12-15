package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.LobbySystem;
import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.manager.CosmeticManager;
import me.bluenitrox.lobby.manager.MessageManager;
import me.bluenitrox.lobby.manager.PermissionsManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.bluenitrox.lobby.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
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
                        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Spieler-Sichtbarkeit")){
                            e.setCancelled(true);
                            playerVisibility(p);
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Navigator")){
                            e.setCancelled(true);
                            navigarInv(p);
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Freunde")){
                            e.setCancelled(true);
                            if(LobbySystem.p.contains(p)){
                                p.sendMessage(MessageManager.PREFIX + "§7Warte einen Augenblick bis du das wieder benutzen kannst");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                return;
                            }
                            LobbySystem.p.add(p);
                            p.chat("/friendgui");
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Cosmetics")){
                            e.setCancelled(true);
                            if(LobbySystem.p.contains(p)){
                                p.sendMessage(MessageManager.PREFIX + "§7Warte einen Augenblick bis du das wieder benutzen kannst");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                return;
                            }
                            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1L, 1L);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 2L ,2L);
                            p.openInventory(CosmeticManager.getMainmenu(p.getUniqueId()));
                            LobbySystem.p.add(p);
                        }else if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Lobby Menü")){
                            e.setCancelled(true);
                            playerLobby(p);
                        }
                    }
                }
            }
        }
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getClickedBlock().getType() == Material.ENDER_CHEST){
                e.setCancelled(true);
                caseopeninv(p);
            }
        }
    }

    private void caseopeninv(Player p){
        Inventory inv = Bukkit.createInventory(null, 6*9, "§8» §6§lCase-Opening");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();
        ItemStack glaswhite = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCase-Opening").setLore("§8● §7Hier kannst du Cases öffnen die du im laufe", "§8● §7des Spiels Sammeln kannst.", " ", "§cInfo:", "§8● §7Du kannst Cases für Lobbycoins kaufen.", "§8● §7Außerdem kannst du die Lobbycases in Minigames finden.").build();

        ItemStack cases = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§6§lLobby Case").setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungem§7.", " ", "§aKlicke hier, um diese Case zu öffnen").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();

        int havecases = CaseManager.get(p.getUniqueId(), "cases");

        for(int i = 0; i<= 8;i++){
            inv.setItem(i, glaswhite);
        }

        for(int i = 36; i<=44; i++){
            inv.setItem(i, glaswhite);
        }
        for(int i = 45; i<=53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(49, sign);
        inv.setItem(48, KopfUtil.createSkull("lgndryFelix", "§7Zurück"));
        inv.setItem(50, KopfUtil.createSkull("DerWahreNitrox", "§7Weiter"));

        if(havecases <= 27) {
            if (havecases > 0) {
                for (int i = 9; i < havecases + 9; i++) {
                    inv.setItem(i, cases);
                }
            }
        }else {
            for(int i = 9; i<= 35; i++){
                inv.setItem(i, cases);
            }
        }

        p.openInventory(inv);
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

    private void navigarInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§8» §6Navigator");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack school = new ItemBuilder(Material.BOOK_AND_QUILL).setDisplayname("§8» §6School").setLore("§8● §aKlicke hier, um dich zu teleportieren...").build();
        ItemStack spawn = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §6Lobby-Spawn").setLore("§8● §aKlicke hier, um dich zu teleportieren...").build();
        ItemStack minigames = new ItemBuilder(Material.ARMOR_STAND).setDisplayname("§8» §6Minigames §8(§7Demnächst verfügbar...§8)").setLore("§8● §cKlicke hier, um dich zu teleportieren...").build();
        ItemStack coinshop = new ItemBuilder(Material.EMERALD).setDisplayname("§8» §6Coinshop").setLore("§8● §aKlicke hier, um dich zu teleportieren...").build();
        ItemStack caseopening = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§8» §6Case-Opening").setLore("§8● §aKlicke hier, um dich zu teleportieren...").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i,glas);
        }
        for(int i = 44; i<= 53; i++){
            inv.setItem(i,glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        inv.setItem(20,school);
        inv.setItem(22,spawn);
        inv.setItem(24,minigames);
        inv.setItem(30,caseopening);
        inv.setItem(32,coinshop);

        p.openInventory(inv);
    }

    public void playerLobby(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*3, "§8» §6Lobby wechseln");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();

        ItemStack lobby1 = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§8»§6 Lobby-1").setLore("§aKlicke hier um in diese Lobby zu wechseln.").build();
        ItemStack lobby2 = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§8»§6 Lobby-2").setLore("§aKlicke hier um in diese Lobby zu wechseln.").build();
        ItemStack premiumlobby1 = new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§8»§6 PremiumLobby-1").setLore("§aKlicke hier um in diese Lobby zu wechseln.").build();
        ItemStack premiumlobbynothere = new ItemBuilder(Material.BARRIER).setDisplayname("§8»§6 PremiumLobby-1").setLore("§aDu hast keinen Zugang um in die PremiumLobby zu gehen!").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        for(int i = 17; i<= 26; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(12,lobby1);
        inv.setItem(13,lobby2);
        if(!p.hasPermission(PermissionsManager.PREMIUMLOBBY)) {
            inv.setItem(14, premiumlobbynothere);
        }else {
            inv.setItem(14,premiumlobby1);
        }

        p.openInventory(inv);
    }

}
