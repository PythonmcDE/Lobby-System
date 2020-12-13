package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.utils.Multiplikator;
import me.bluenitrox.lobby.LobbySystem;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerToggleFlightEvent implements Listener {


    @EventHandler
    public void onPlayerToggleFlightEvent(org.bukkit.event.player.PlayerToggleFlightEvent ev) {
        Player p = ev.getPlayer();
        if (CaseManager.getItems(p.getUniqueId(), "doublejump", "bekleidung") > 0 && p.getGameMode() == GameMode.SURVIVAL) {
            ev.setCancelled(true);
            p.setFlying(false);
            p.setAllowFlight(false);
            p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1L, 1L);
            p.setVelocity(p.getLocation().getDirection().multiply((new Multiplikator(LobbySystem.getInstance())).getMultiplier()).add(new Vector(0, 1, 0)));
        }

    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent ev) {
        Player p = ev.getPlayer();
        if (CaseManager.getItems(p.getUniqueId(), "doublejump", "bekleidung") > 0 && p.getGameMode() == GameMode.SURVIVAL && p.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType() != Material.AIR) {
            p.setFlying(false);
            p.setAllowFlight(true);
        }

    }

}
