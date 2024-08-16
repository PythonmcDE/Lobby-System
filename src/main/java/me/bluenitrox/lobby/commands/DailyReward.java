package me.bluenitrox.lobby.commands;

import me.bluenitrox.lobby.manager.MessageManager;
import me.bluenitrox.lobby.mysql.MySQL;
import me.bluenitrox.lobby.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DailyReward implements CommandExecutor {

    public String guiname = "§8» §6Daily-Reward";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        UUID uuid = p.getUniqueId();
        Inventory inv = Bukkit.createInventory(null,9*6,guiname);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lDaily Reward").setLore("§6§l▶ §7Hier kannst du §6jeden Tag §7eine","§6§l▶ §7kostenlose §6Belohnung §7abholen","§cInfos: ","§8● §7Hole den Reward jeden Tag ab, um", "§8● §7täglich Belohnungen zu bekommen.").build();
        ItemStack glowdust = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§8» §6Tägliche Belohnung").setLore("§8● §7Belohnung: §61000 Coins"," ", "§8● §aKlicke hier§7, zum §aAbholen§7.").build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cDiesen Reward hast du heute schon abgeholt!").setLore("§8● §7Du hast deine Belohnung §7bereits abgeholt§7.").build();

        for(int i = 0; i<=8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <=44; i++){
            inv.setItem(i,glas);
        }
        for(int i =45; i<= 53; i++){
            inv.setItem(i,glasblack);
        }
        inv.setItem(49,sign);
        if(getBelohnung(uuid) == 0) {
            inv.setItem(22, glowdust);
        }else {
            inv.setItem(22,barrier);
        }

        p.openInventory(inv);
        return false;
    }

    public void dailyRewardClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
            e.setCancelled(true);
            UUID uuid = e.getWhoClicked().getUniqueId();
            Player p = (Player) e.getWhoClicked();
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Tägliche Belohnung")){
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                //Database.update(uuid, 1000, false); todo
                updateBelohnung(uuid, 1, false);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast den §6Dailyreward §7abgeholt.");
            }
        }
    }

    private int getBelohnung(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Belohnung FROM DailyReward WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Belohnung");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    private void updateBelohnung(UUID uuid, float amount, boolean remove) {
        float currMoney = getBelohnung(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET Belohnung = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
