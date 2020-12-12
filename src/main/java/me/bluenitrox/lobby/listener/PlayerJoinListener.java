package me.bluenitrox.lobby.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.lobby.manager.LocationManager;
import me.bluenitrox.lobby.manager.ScoreboardManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.bluenitrox.lobby.utils.KopfUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e){
        Player p = (Player)e.getPlayer();
        e.setJoinMessage(null);
        p.teleport(new LocationManager("spawn").getLocation());
        ScoreboardManager.setBoard(p);
        TTA_Methods.sendActionBar(p, "§8» §bDu kannst gut Supporten? §4§l-> §cBewirb dich jetzt als Supporter!");
        p.getInventory().clear();
        givePlayerItems(p);
    }

    private void givePlayerItems(Player p){
        p.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setDisplayname("§6Navigator").build());
        p.getInventory().setItem(1, KopfUtil.createSkull(p.getName(), "§6Mein Profil"));
        p.getInventory().setItem(7, new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§6Gadgets").build());
        p.getInventory().setItem(8, new ItemBuilder(Material.BLAZE_ROD).setDisplayname("§6Spieler-Sichtbarkeit").build());
    }

}
