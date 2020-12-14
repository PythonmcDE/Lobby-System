package me.bluenitrox.lobby.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.manager.CosmeticManager;
import me.bluenitrox.lobby.manager.LocationManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import me.bluenitrox.lobby.utils.KopfUtil;
import me.bluenitrox.lobby.manager.ScoreboardManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e){
        Player p = (Player)e.getPlayer();
        e.setJoinMessage(null);
        CaseManager.cachPlayerData(p.getUniqueId());
        p.teleport(new LocationManager("spawn").getLocation());
        ScoreboardManager.setBoard(p);
        TTA_Methods.sendActionBar(p, "§8» §bDu kannst gut Supporten? §4§l-> §cBewirb dich jetzt als Supporter!", 20*60*24);
        p.getInventory().clear();
        p.setGameMode(GameMode.SURVIVAL);
        givePlayerItems(p);
        if(CaseManager.getItems(p.getUniqueId(), "doublejump", "bekleidung") > 0){
            PlayerToggleFlightEvent.doublejump.add(p);
        }
        fähigkeiten(p);
    }

    private void fähigkeiten(Player p){
        if(CaseManager.getItems(p.getUniqueId(), "sprungkraft", "bekleidung") >0){
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1, 20*60*24));
        }
        if(CaseManager.getItems(p.getUniqueId(), "speed", "bekleidung") >0){
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 0, 20*60*24));
        }
    }

    private void givePlayerItems(Player p){
        ItemStack kopf = KopfUtil.createSkull(p.getName(), "§8» §6Freunde");
        ItemMeta kopfmeta = kopf.getItemMeta();
        kopfmeta.setLore(Arrays.asList("§8● §aKlicke hier§7, um dein Freunde-Menü zu §aöffnen§7!"));
        kopf.setItemMeta(kopfmeta);

        p.getInventory().setItem(3, new ItemBuilder(Material.BARRIER).setDisplayname("§4Nicht ausgewählt").setLore("§8● §7Öffne das Cosmetics-Menü und wähle ein Gadget aus.").build());
        p.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setDisplayname("§8» §6Navigator").setLore("§8● §aKlicke hier§7, um das Teleport-Menü zu §aöffnen§7!").build());
        p.getInventory().setItem(8, kopf);
        p.getInventory().setItem(4, new ItemBuilder(Material.WATCH).setDisplayname("§8» §6Lobby Menü").setLore("§8● §aKlicke hier§7, um das Lobby-Menü zu §aöffnen§7!").build());
        p.getInventory().setItem(1, new ItemBuilder(Material.BLAZE_ROD).setDisplayname("§8» §6Spieler-Sichtbarkeit").setLore("§8● §aKlicke hier§7, um das Sichtbarkeits-Menü zu §aöffnen§7!").build());
        p.getInventory().setItem(7, new ItemBuilder(Material.BANNER,(short) 8).setDisplayname("§8» §6Cosmetics").setLore("§8● §aKlicke hier§7, um dein Cosmetics-Menü zu §aöffnen§7!").build());
    }

}
