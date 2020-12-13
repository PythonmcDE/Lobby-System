package me.bluenitrox.lobby.listener;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BootsListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS) {
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WATERDRIP, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WATERDRIP, 1);
        }

        if (p.getInventory().getBoots().getType() == Material.GOLD_BOOTS) {
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FLAME, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FLAME, 1);
        }

        if (p.getInventory().getBoots().getType() == Material.IRON_BOOTS) {
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.MAGIC_CRIT, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WITCH_MAGIC, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.MAGIC_CRIT, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.WITCH_MAGIC, 1);
        }

        if (p.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS) {
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.SNOW_SHOVEL, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.SNOWBALL_BREAK, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.SNOW_SHOVEL, 1);
            p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.SNOWBALL_BREAK, 1);
        }

    }
}
