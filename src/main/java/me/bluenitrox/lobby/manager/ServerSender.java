package me.bluenitrox.lobby.manager;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import org.bukkit.entity.Player;

public class ServerSender {

    public void sendPlayerToServer(Player player, String targetServer) {
        IPlayerManager playerManager = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
        ICloudPlayer cloudPlayer = playerManager.getOnlinePlayer(player.getUniqueId());

        if (cloudPlayer != null) {
            playerManager.getPlayerExecutor(cloudPlayer).connect(targetServer);
        }
    }

}
