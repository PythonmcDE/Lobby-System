package me.bluenitrox.lobby.manager;

import me.bluenitrox.lobby.LobbySystem;
import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.bluenitrox.lobby.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class CosmeticManager {

    public static ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
    public static ItemStack glaswhite = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
    public static ItemStack left = KopfUtil.createSkull("lgndryFelix", "§7Zurück");
    public static ItemStack right = KopfUtil.createSkull("DerWahreNitrox", "§7Weiter");
    public static ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCosmetics").setLore("§8● §7Hier findest du alle Cosmetics und Gadgets,", "§8● §7die dir gehören.", " ", "§cInfo:", "§8● §7Cosmetics und Gadgets bekommst du", "§8● §7aus Lobby-Cases.").build();
    public static ItemStack not = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cNoch nicht freigeschalten!").setLore("§8● §7Ziehe dieses Item zuerst aus", "§8● §7einer §6Lobby Case§7.").build();

    public static void onClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase("§8» §6§lCosmetics")){
            Player p = (Player)e.getWhoClicked();
            if(LobbySystem.p.contains(p)){
                p.sendMessage(MessageManager.PREFIX + "§7Warte einen Augenblick bis du das wieder benutzen kannst");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Banner")){
                p.openInventory(getBanner(p.getUniqueId()));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Emotes")){
                p.openInventory(getEmotes(p.getUniqueId()));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Gadget")){
                p.openInventory(getGadgets(p.getUniqueId()));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Köpfe")){
                p.openInventory(getKöpfe(p.getUniqueId()));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Bekleidung")){
                p.openInventory(getBekleidung(p.getUniqueId()));
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Fähigkeiten")){
                p.openInventory(getFähigkeiten(p.getUniqueId()));
            }
        }
    }

    public static Inventory getMainmenu(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 6*9,"§8» §6§lCosmetics");

        ItemStack Banner = new ItemBuilder(Material.BANNER,(short)8).setDisplayname("§8» §6§lCosmetics").setLore("§8● §7Hier findest du alle §6Cosmetics/Gadgets", "§8● §7die du §cfreigeschalten §7hast.").build();

        ItemStack Banner2 = new ItemBuilder(Material.BANNER,(short)11).setDisplayname("§8» §6Banner").setLore("§8● §aKlicke hier§7, um das §6§lBanner GUI §7zu öffnen.").build();
        ItemStack emote = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §6Emotes").setLore("§8● §aKlicke hier§7, um das §6§lEmotes GUI §7zu öffnen.").build();
        ItemStack gadget = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§8» §6Gadget").setLore("§8● §aKlicke hier§7, um das §6§lGadget GUI §7zu öffnen.").build();
        ItemStack head = new ItemBuilder(Material.SKULL_ITEM).setDisplayname("§8» §6Köpfe").setLore("§8● §aKlicke hier§7, um das §6§lKöpfe GUI §7zu öffnen.").build();
        ItemStack armor = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§8» §6Bekleidung").setLore("§8● §aKlicke hier§7, um das §6§lBekleidung GUI §7zu öffnen.").build();
        ItemStack fähigkeit = new ItemBuilder(Material.PAPER).setDisplayname("§8» §6Fähigkeiten").setLore("§8● §aKlicke hier§7, um das §6§lFähigkeiten GUI §7zu öffnen.").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glaswhite);
        }
        for(int i = 36; i<= 44; i++){
            inv.setItem(i, glaswhite);
        }
        for(int i = 45; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(12, Banner2);
        inv.setItem(14, emote);
        inv.setItem(19, gadget);
        inv.setItem(25, head);
        inv.setItem(30, armor);
        inv.setItem(32, fähigkeit);

        inv.setItem(49,Banner);

        return inv;
    }

    public static Inventory getBekleidung(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Bekleidung");

        ItemStack lether = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§cVolle Dämonen Brustplatte").setLore("§8» §7Regenbogen Effekt").build();
        ItemStack drip = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9§lDrip Boots").setLore("§8» §7Wasser Partikel").build();
        ItemStack flame = new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§6§lFlame Boots").setLore("§8» §7Feuer Partikel").build();
        ItemStack zauber = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§5§lZauberer Schuhe").setLore("§8» §7Magie Partikel").build();
        ItemStack schnee = new ItemBuilder(Material.CHAINMAIL_BOOTS).setDisplayname("§b§lSchnee Schuhe").setLore("§8» §7Schnee Partikel").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "daemonen", "bekleidung") >0){
            inv.setItem(10,lether);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "drip", "bekleidung") >0){
            inv.setItem(11,drip);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "flame", "bekleidung") >0){
            inv.setItem(12,flame);
        }else {
            inv.setItem(12,not);
        }

        if(CaseManager.getItems(uuid, "zauberer", "bekleidung") >0){
            inv.setItem(13,zauber);
        }else {
            inv.setItem(13,not);
        }

        if(CaseManager.getItems(uuid, "schnee", "bekleidung") >0){
            inv.setItem(14,schnee);
        }else {
            inv.setItem(14,not);
        }



        return inv;
    }

    public static Inventory getFähigkeiten(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Fähigkeiten");

        ItemStack rd14 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Doublejump").setLore("§8● §7Du kannst Doppelsprünge machen!").build();
        ItemStack rd15 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Speed").setLore("§8● §7Du hast Permanent Speed I").build();
        ItemStack rd16 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Sprungkraft").setLore("§8● §7Du hast Permanent Sprungkraft II").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "doublejump", "bekleidung") >0){
            inv.setItem(10,rd14);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "speed", "bekleidung") >0){
            inv.setItem(11,rd15);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "sprungkraft", "bekleidung") >0){
            inv.setItem(12,rd16);
        }else {
            inv.setItem(12,not);
        }




        return inv;
    }

    public static Inventory getGadgets(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Gadgets");

        ItemStack rd17 = new ItemBuilder(Material.TNT).setDisplayname("§6§lBombe").setLore("§8» §7Eine Explosion erwartet dich!").build();
        ItemStack rd18 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§6§lEnterhaken").setLore("§8» §7Bewege dich schneller fort!").build();
        ItemStack rd19 = new ItemBuilder(Material.IRON_BARDING).setDisplayname("§6§lSchneeballwerfer").setLore("§8» §7Werfe unendlich Schneebälle").build();
        ItemStack rd20 = new ItemBuilder(Material.GOLD_BARDING).setDisplayname("§6§lEierwerfer").setLore("§8» §7Werfe unendlich Eier").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "tnt", "gadgets") >0){
            inv.setItem(10,rd17);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "enterhaken", "gadgets") >0){
            inv.setItem(11,rd18);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "iron", "gadgets") >0){
            inv.setItem(12,rd19);
        }else {
            inv.setItem(12,not);
        }

        if(CaseManager.getItems(uuid, "gold", "gadgets") >0){
            inv.setItem(13,rd20);
        }else {
            inv.setItem(13,not);
        }




        return inv;
    }

    public static Inventory getEmotes(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Emotes");

        ItemStack emote1 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§b »").setLore("§8● §7Schreibe: §8\">>§8\"").build();
        ItemStack emote2 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§b «").setLore("§8● §7Schreibe: §8\"<<§8\"").build();
        ItemStack emote3 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§f ➡").setLore("§8● §7Schreibe: §8\"->§8\"").build();
        ItemStack emote4 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§a ✔").setLore("§8● §7Schreibe: §8\":right:§8\"").build();
        ItemStack emote5 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§c ✘").setLore("§8● §7Schreibe: §8\":x:§8\"").build();
        ItemStack emote6 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§c ❤").setLore("§8● §7Schreibe: §8\"<3§8\"").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "rightright", "emotes") >0){
            inv.setItem(10,emote1);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "leftleft", "emotes") >0){
            inv.setItem(11,emote2);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "rechts", "emotes") >0){
            inv.setItem(12,emote3);
        }else {
            inv.setItem(12,not);
        }

        if(CaseManager.getItems(uuid, "richtig", "emotes") >0){
            inv.setItem(13,emote4);
        }else {
            inv.setItem(13,not);
        }

        if(CaseManager.getItems(uuid, "x", "emotes") >0){
            inv.setItem(14,emote5);
        }else {
            inv.setItem(14,not);
        }

        if(CaseManager.getItems(uuid, "herz", "emotes") >0){
            inv.setItem(15,emote6);
        }else {
            inv.setItem(15,not);
        }





        return inv;
    }

    public static Inventory getBanner(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Banner");

        ItemStack banner1 = new ItemBuilder(Material.BANNER,(short)4).setDisplayname("§7Banner §1Blau").build();
        ItemStack banner2 = new ItemBuilder(Material.BANNER,(short)1).setDisplayname("§7Banner §4Rot").build();
        ItemStack banner3 = new ItemBuilder(Material.BANNER,(short)10).setDisplayname("§7Banner §aGrün").build();
        ItemStack banner4 = new ItemBuilder(Material.BANNER,(short)11).setDisplayname("§7Banner §eGelb").build();
        ItemStack banner5 = new ItemBuilder(Material.BANNER,(short)7).setDisplayname("§7Banner §7Grau").build();
        ItemStack banner6 = new ItemBuilder(Material.BANNER,(short)0).setDisplayname("§7Banner §0Schwarz").build();
        ItemStack banner7 = new ItemBuilder(Material.BANNER,(short)13).setDisplayname("§7Banner §dPink").build();
        ItemStack banner8 = new ItemBuilder(Material.BANNER,(short)14).setDisplayname("§7Banner §6Orange").build();

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "bannerblue", "gadgets") >0){
            inv.setItem(10,banner1);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "bannerred", "gadgets") >0){
            inv.setItem(11,banner2);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "bannergreen", "gadgets") >0){
            inv.setItem(12,banner3);
        }else {
            inv.setItem(12,not);
        }

        if(CaseManager.getItems(uuid, "banneryellow", "gadgets") >0){
            inv.setItem(13,banner4);
        }else {
            inv.setItem(13,not);
        }

        if(CaseManager.getItems(uuid, "bannergrey", "gadgets") >0){
            inv.setItem(14,banner5);
        }else {
            inv.setItem(14,not);
        }

        if(CaseManager.getItems(uuid, "bannerblack", "gadgets") >0){
            inv.setItem(15,banner6);
        }else {
            inv.setItem(15,not);
        }

        if(CaseManager.getItems(uuid, "bannerpink", "gadgets") >0){
            inv.setItem(16,banner7);
        }else {
            inv.setItem(16,not);
        }

        if(CaseManager.getItems(uuid, "bannerorange", "gadgets") >0){
            inv.setItem(19,banner8);
        }else {
            inv.setItem(19,not);
        }





        return inv;
    }

    public static Inventory getKöpfe(UUID uuid){
        Inventory inv = Bukkit.createInventory(null, 9*6,"§8» §6Köpfe");

        ItemStack kopf1 = KopfUtil.createSkull("GommeHD","§cGommeHD");
        ItemStack kopf2 = KopfUtil.createSkull("Benx","§cBenx");
        ItemStack kopf3 = KopfUtil.createSkull("Paluten","§cPaluten");
        ItemStack kopf4 = KopfUtil.createSkull("GermanLetsPlay","§cGermanLetsPlay");
        ItemStack kopf5 = KopfUtil.createSkull("AbgegrieftHD","§cAbgegrieftHD");
        ItemStack kopf6 = KopfUtil.createSkull("Logo","§cLogo");

        for(int i = 0; i<= 9; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(17,glas);
        inv.setItem(18,glas);
        inv.setItem(26,glas);
        inv.setItem(27,glas);
        inv.setItem(35,glas);
        inv.setItem(36,glas);
        for(int i = 44 ; i<= 53; i++){
            inv.setItem(i, glas);
        }

        inv.setItem(48,left);
        inv.setItem(50,right);
        inv.setItem(49,sign);

        if(CaseManager.getItems(uuid, "gomme", "kopf") >0){
            inv.setItem(10,kopf1);
        }else {
            inv.setItem(10,not);
        }

        if(CaseManager.getItems(uuid, "benx", "kopf") >0){
            inv.setItem(11,kopf2);
        }else {
            inv.setItem(11,not);
        }

        if(CaseManager.getItems(uuid, "palle", "kopf") >0){
            inv.setItem(12,kopf3);
        }else {
            inv.setItem(12,not);
        }

        if(CaseManager.getItems(uuid, "glp", "kopf") >0){
            inv.setItem(13,kopf4);
        }else {
            inv.setItem(13,not);
        }

        if(CaseManager.getItems(uuid, "abge", "kopf") >0){
            inv.setItem(14,kopf5);
        }else {
            inv.setItem(14,not);
        }

        if(CaseManager.getItems(uuid, "logo", "kopf") >0){
            inv.setItem(15,kopf6);
        }else {
            inv.setItem(15,not);
        }






        return inv;
    }

}
