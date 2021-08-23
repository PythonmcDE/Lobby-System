package me.bluenitrox.lobby.utils;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.IOfflineCloudPlayer;
import eu.thesimplecloud.clientserverapi.lib.promise.ICommunicationPromise;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import eu.thesimplecloud.module.permission.player.PermissionPlayer;

import java.util.UUID;

public class GetRankNameByGroup {

    public static String getRankColor(IPermissionPlayer permissionPlayer) {

        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Admin")) { return "Admin"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Manager")) { return "Manager"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Developer")) { return "Developer"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrModerator")) { return "SrModerator"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Moderator")) { return "Moderator"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrSupporter")) { return "SrSupporter"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Supporter")) { return "Supporter"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrBuilder")) { return "SrBuilder"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Builder")) { return "Builder"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Content")) { return "Content"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("YoutuberPlus")) { return "Youtuber+"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Youtuber")) { return "Youtuber"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("PremiumPlus")) { return "Premium+"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Python")) { return "Python"; }
        if(permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("VIP")) { return "VIP"; }
        else {
            return "§7";
        }
    }

    public static IPermissionPlayer getIPermissionPlayer(UUID uuid) {

        IPermissionPlayer permissionPlayer = null;

        try {

            if (CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(uuid) == null) {

                ICommunicationPromise<IOfflineCloudPlayer> iOfflineCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getOfflineCloudPlayer(uuid);
                permissionPlayer = (IPermissionPlayer) iOfflineCloudPlayer.getBlockingOrNull().getProperty(PermissionPlayer.PROPERTY_NAME).getValue();
            } else {

                permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(uuid);
            }
        } catch (NullPointerException ignored) {

        }

        return permissionPlayer;
    }

}
