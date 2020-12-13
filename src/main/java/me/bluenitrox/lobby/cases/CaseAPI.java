package me.bluenitrox.lobby.cases;

import me.bluenitrox.lobby.utils.Firework;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.bluenitrox.lobby.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CaseAPI {

    public static String casesname = "§6§lLobby Case";

    private int rounds = 0;
    public static HashMap<Player, ArrayList<ItemStack>> caseitemshash = new HashMap<>();
    public static ArrayList<ItemStack> casepot;

    public static ArrayList<Player> caseöffnen = new ArrayList<>();

    public void openCase(Player p, int cases) {
        caseöffnen.add(p);
        clearAllArrays();
        getCasePot(cases, p);

        Inventory inv = Bukkit.getServer().createInventory(null, 9 * 3, toCase(cases));

        ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();

        for (int i = 9; i <= 17; i++) {
            inv.setItem(i, caseitemshash.get(p).get(i));
            inv.setItem(i - 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))
                    .setDisplayname(rareFromShort(rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))).build());
            inv.setItem(i + 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))
                    .setDisplayname(rareFromShort(rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))).build());
        }

        inv.setItem(4, hopper);
        p.openInventory(inv);
        new BukkitRunnable() {
            @Override
            public void run() {
                startAnimation(p, inv, cases);
            }
        }.runTaskLaterAsynchronously(LobbySystem.getInstance(), 5);
    }

    private void startAnimation(Player p, Inventory inv, int cases) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(rounds >= 40){
                    this.cancel();
                    Inventory wininv = Bukkit.getServer().createInventory(null, 9*3, "§e§lCase Gewinn");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP , 1L, 1L);
                    ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE,(short) 15).setDisplayname(" ").build();
                    ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();

                    for(int i = 0; i <= 12; i++){
                        if(i != 4) {
                            wininv.setItem(i, new ItemBuilder(Material.AIR).build());
                            wininv.setItem(i, glas);
                        }
                    }
                    for(int i = 14; i <= 26; i++){
                        wininv.setItem(i, new ItemBuilder(Material.AIR).build());
                        wininv.setItem(i, glas);
                    }
                    wininv.setItem(4, hopper);


                    wininv.setItem(13, inv.getItem(13));

                    Firework.Firework(p);

                    p.openInventory(wininv);
                    CaseManager.givePlayerWin(p, inv.getItem(13));
                    caseöffnen.remove(p);
                    caseitemshash.remove(p);
                    rounds = 0;
                    return;
                }

                for (int i1 = 9; i1 <= 17; i1++) {
                    if (i1 <= 16) {
                        if(i1 == 13){
                            inv.setItem(i1, inv.getItem(i1 + 1));
                            inv.setItem(i1+9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1+1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1+1).getItemMeta().getDisplayName()))).build());
                        }else {
                            inv.setItem(i1, inv.getItem(i1 + 1));
                            inv.setItem(i1 + 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))).build());
                            inv.setItem(i1 - 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))).build());
                        }
                    } else {
                        ItemStack is = caseitemshash.get(p).get(new Random().nextInt(caseitemshash.get(p).size()));
                        inv.setItem(i1, is);
                        inv.setItem(i1-9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(is.getItemMeta().getDisplayName()))
                                .setDisplayname(rareFromShort(rareFromColor(is.getItemMeta().getDisplayName()))).build());
                        inv.setItem(i1+9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(is.getItemMeta().getDisplayName()))
                                .setDisplayname(rareFromShort(rareFromColor(is.getItemMeta().getDisplayName()))).build());

                    }
                }
                ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();
                inv.setItem(4,hopper);
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1L , 1L);
                rounds++;
            }
        }.runTaskTimer(LobbySystem.getInstance(), 5,5);

    }

    public void getCasePot(int cases, Player p) {
        casepot = new ArrayList<>();
        CaseItems caseitems = new CaseItems();
        /*
        0 = cases
         */

        registerAllInRightOrder(cases, caseitems);


        caseitemshash.put(p, casepot);

    }


    private void registerAllInRightOrder(int cases, CaseItems caseitems){
        registerAllCases(caseitems);


        if (cases == 0) {
            for (int i = 0; i <= 128; i++) {
                casepot.add(CaseItems.cases.get(new Random().nextInt(CaseItems.cases.size())));
            }
        }

        clearAllArrays();
    }


    private void registerAllCases(CaseItems caseitems) {
        caseitems.registerCases();
    }

    private void clearAllArrays(){
        if(CaseItems.cases != null) {
            CaseItems.cases.clear();
        }
    }

    private short rareFromColor(String name){
        if(name.startsWith("§6§l")){
            return 10;
        }else if(name.startsWith("§6")){
            return 1;
        }else if(name.startsWith("§5")){
            return 10;
        }else if(name.startsWith("§9")){
            return 3;
        }else {
            return 8;
        }
    }

    private String rareFromShort(short rare){
        if(rare == 1){
            return "§6§lLegendär";
        }else if(rare == 10){
            return "§5§lEpisch";
        }else if(rare == 3){
            return "§b§lSelten";
        }else if(rare == 8){
            return "§7§lGewöhnlich";
        }else {
            return null;
        }
    }

    private String toCase(int cases) {
        if (cases == 0) {
            return casesname;
        }
        return null;
    }

    public int fromCase(String cases){
        return 0;
    }
}
