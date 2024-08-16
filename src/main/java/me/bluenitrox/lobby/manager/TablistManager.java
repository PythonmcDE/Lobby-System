package me.bluenitrox.lobby.manager;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class TablistManager {

    private final LuckPerms luckPerms;

    public TablistManager(LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    public void updateTablist(Scoreboard scoreboard) {
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

        // Sort players by their rank
        players.sort((p1, p2) -> {
            int rank1 = getRankValue(getPlayerGroup(p1));
            int rank2 = getRankValue(getPlayerGroup(p2));
            return Integer.compare(rank1, rank2);
        });

        // Clear existing teams
        for (Team team : scoreboard.getTeams()) {
            team.unregister();
        }

        // Assign players to teams based on their rank
        for (Player player : players) {
            String prefix = getPlayerGroup(player);
            int rank = getRankValue(prefix);
            String teamName = String.format("%03d", rank);  // Use zero-padded rank as team name

            Team team = scoreboard.getTeam(teamName);
            if (team == null) {
                team = scoreboard.registerNewTeam(teamName);
                team.setPrefix(prefix);
            }

            team.addEntry(player.getName());
        }

        // Weisen Sie das Scoreboard jedem Spieler zu
        for (Player player : players) {
            player.setScoreboard(scoreboard);
        }
    }

    public String getPlayerGroup(Player player) {
        CachedMetaData metaData = this.luckPerms.getPlayerAdapter(Player.class).getMetaData(player);

        String prefix = metaData.getPrefix();
        if (prefix != null) {
            prefix = prefix.replace("&", "§");
        } else {
            prefix = "";
        }
        return prefix;
    }

    private int getRankValue(String prefix) {
        // Define a method to convert the prefix to a rank value
        // This can be based on your own ranking system
        // Example ranking system:
        switch (prefix) {
            case "§4[OWNER] ":
                return 1;
            case "§4[ADMIN] ":
                return 2;
            case "§9[DEV] ":
                return 3;
            case "§c[MOD] ":
                return 4;
            case "§a[SUP] ":
                return 5;
            case "§e[BUILDER] ":
                return 6;
            case "§1[CREATOR] ":
                return 7;
            case "§f[CHAMPION] ":
                return 8;
            case "§5[VALORA+] ":
                return 9;
            case "§5[VALORA] ":
                return 10;
            case "§8[FOUNDER] ":
                return 11;
            case "§b[ULTRA] ":
                return 12;
            case "§6[VIP] ":
                return 13;
            default:
                return 14; // Default rank value for unknown prefixes
        }
    }
}

