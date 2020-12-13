package me.bluenitrox.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class PlayerFishEvent implements Listener {
    @EventHandler
    public void onFish(final org.bukkit.event.player.PlayerFishEvent e) {
        Player p = e.getPlayer();
        Fish h = e.getHook();
        if (e.getState() == org.bukkit.event.player.PlayerFishEvent.State.IN_GROUND || (e.getState().equals(org.bukkit.event.player.PlayerFishEvent.State.CAUGHT_ENTITY) || e.getState().equals(org.bukkit.event.player.PlayerFishEvent.State.FAILED_ATTEMPT)) && Bukkit.getWorld(e.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.AIR) {
            Location lc = p.getLocation();
            Location to = e.getHook().getLocation();
            lc.setY(lc.getY() + 0.5D);
            p.teleport(lc);
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
            double g = -0.08D;
            double d = to.distance(lc);
            double v_x = (1.0D + 0.07D * d) * (to.getX() - lc.getX()) / d;
            double v_y = (1.0D + 0.03D * d) * (to.getY() - lc.getY()) / d - 0.5D * g * d;
            double v_z = (1.0D + 0.07D * d) * (to.getZ() - lc.getZ()) / d;
            Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
            p.getItemInHand().setDurability((short)0);
        }

    }
}
