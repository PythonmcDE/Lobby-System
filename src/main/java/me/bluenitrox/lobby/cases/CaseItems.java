package me.bluenitrox.lobby.cases;

import me.bluenitrox.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CaseItems {

    public static ArrayList<ItemStack> cases = new ArrayList<>();;

    public static ArrayList<ItemStack> casepot = new ArrayList<>();


    void registerCases(){

        ItemStack rd = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 10000").build();
        ItemStack rd1 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 1000").build();
        ItemStack rd2 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 2000").build();
        ItemStack rd3 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 5000").build();
        ItemStack rd4 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 15000").build();
        ItemStack rd5 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 25000").build();
        ItemStack rd6 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 1000").build();
        ItemStack rd7 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 1000").build();
        ItemStack rd8 = new ItemBuilder(Material.DOUBLE_PLANT).setDisplayname("§e§lLobby-Coins").setLore("§8» §7Anzahl:§6 1000").build();

        ItemStack rd9 = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§c§lVolle Dämonen Brustplatte").setLore("§8» §7Gegenbogen Effekt").build();
        ItemStack rd10 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9§lDrip Boots").setLore("§8» §7Wasser Partikel").build();
        ItemStack rd11 = new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§6§lFlame Boots").setLore("§8» §7Feuer Partikel").build();
        ItemStack rd12 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§5§lZauberer Schuhe").setLore("§8» §7Magie Partikel").build();
        ItemStack rd13 = new ItemBuilder(Material.CHAINMAIL_BOOTS).setDisplayname("§b§lSchnee Schuhe").setLore("§8» §7Schnee Partikel").build();

        ItemStack rd14 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Doublejump").setLore("§8● §7Du kannst Doppelsprünge machen!").build();
        ItemStack rd15 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Speed").setLore("§8● §7Du hast Permanent Speed I").build();
        ItemStack rd16 = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Fähigkeit:§6 Sprungkraft").setLore("§8● §7Du hast Permanent Sprungkraft II").build();

        ItemStack rd17 = new ItemBuilder(Material.TNT).setDisplayname("§6§lBombe").setLore("§8» §7Eine Explosion erwartet dich!").build();
        ItemStack rd18 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§6§lEnterhaken").setLore("§8» §7Bewege dich schneller fort!").build();
        ItemStack rd19 = new ItemBuilder(Material.IRON_BARDING).setDisplayname("§6§lSchneeballwerfer").setLore("§8» §7Werfe unendlich Schneebälle").build();
        ItemStack rd20 = new ItemBuilder(Material.GOLD_BARDING).setDisplayname("§6§lEierwerfer").setLore("§8» §7Werfe unendlich Eier").build();

        ItemStack emote1 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§b »").setLore("§8● §7Schreibe: §8\">>§8\"").build();
        ItemStack emote2 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§b «").setLore("§8● §7Schreibe: §8\"<<§8\"").build();
        ItemStack emote3 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§f ➡").setLore("§8● §7Schreibe: §8\"->§8\"").build();
        ItemStack emote4 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§a ✔").setLore("§8● §7Schreibe: §8\":right:§8\"").build();
        ItemStack emote5 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§c ✘").setLore("§8● §7Schreibe: §8\":x:§8\"").build();
        ItemStack emote6 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:§c ❤").setLore("§8● §7Schreibe: §8\"<3§8\"").build();
        ItemStack emote7 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\":angry:§8\"").build();
        ItemStack emote8 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\":eye:§8\"").build();
        ItemStack emote9 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\":sad:§8\"").build();
        ItemStack emote10 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\":headphone:§8\"").build();
        ItemStack emote11 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\":idk§8\"").build();
        ItemStack emote12 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §7Emote:").setLore("§8● §7Schreibe: §8\"§8\"").build();

        cases.add(rd);
        cases.add(rd1);
        cases.add(rd2);
        cases.add(rd3);
        cases.add(rd4);
        cases.add(rd5);
        cases.add(rd6);
        cases.add(rd7);
        cases.add(rd8);
        cases.add(rd9);
        cases.add(rd10);
        cases.add(rd11);
        cases.add(rd12);
        cases.add(rd13);
        cases.add(rd14);
        cases.add(rd15);
        cases.add(rd16);
        cases.add(rd17);
        cases.add(rd18);
        cases.add(rd19);
        cases.add(rd20);
        cases.add(emote1);
        cases.add(emote2);
        cases.add(emote3);
        cases.add(emote4);
        cases.add(emote5);
        cases.add(emote6);
        cases.add(emote7);
        cases.add(emote8);
        cases.add(emote9);
        cases.add(emote10);
        cases.add(emote11);
        cases.add(emote12);



    }


}

