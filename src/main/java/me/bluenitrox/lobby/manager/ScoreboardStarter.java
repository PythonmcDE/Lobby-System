package me.bluenitrox.lobby.manager;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardStarter {

    public void startScoreboard() {
        LuckPerms luckPerms = LuckPermsProvider.get();
        TablistManager tablistManager = new TablistManager(luckPerms);

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        tablistManager.updateTablist(scoreboard);
    }

}
