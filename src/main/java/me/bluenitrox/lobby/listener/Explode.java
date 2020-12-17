package me.bluenitrox.lobby.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public class Explode implements Listener {

    @EventHandler
    public void onExplo(final EntityExplodeEvent e){
        if (!(e.getEntity() instanceof TNTPrimed)) return;
        Entity causer = ((TNTPrimed) e.getEntity()).getSource();
        if (causer != null && causer.hasPermission(new Permission("some.node", PermissionDefault.FALSE))) return;
        e.setCancelled(true);
    }

}
