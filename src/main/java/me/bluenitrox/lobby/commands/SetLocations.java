package me.bluenitrox.lobby.commands;

import me.bluenitrox.lobby.manager.LocationManager;
import me.bluenitrox.lobby.manager.MessageManager;
import me.bluenitrox.lobby.manager.PermissionsManager;
import me.bluenitrox.lobby.manager.PlayerJoinManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLocations implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command c, String s, String[] args) {
        if(!(cs instanceof Player)){
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }

        Player p = (Player) cs;
        if(!p.hasPermission(PermissionsManager.SETLOCATION) || !p.hasPermission(PermissionsManager.ALLPERMS)){
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }

        if(args.length == 1){
            try{
                String name = args[0];
                new LocationManager(name).setLocation(p);
            }catch (Exception e){
                e.printStackTrace();
                p.sendMessage(MessageManager.ERROR);
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }

        return false;
    }
}

