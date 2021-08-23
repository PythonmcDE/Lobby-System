package me.bluenitrox.lobby.manager;


import me.bluenitrox.all.Database;
import me.bluenitrox.lobby.utils.GetDisplayColor;
import me.bluenitrox.lobby.utils.GetRankNameByGroup;
import me.clip.placeholderapi.PlaceholderAPI;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ScoreboardManager {

    public static void setBoard(Player p) {
        String color = GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId()));
        String rank = GetDisplayColor.getRankColor(GetRankNameByGroup.getIPermissionPlayer(p.getUniqueId()));
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("TEST", IScoreboardCriteria.b);
        obj.setDisplayName(color + p.getName());
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        String onlinetime1 = "§7➝§6 %dkbans_player_online-time-h%h";
        String onlinetime = PlaceholderAPI.setPlaceholders(p, onlinetime1);
        ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, " ");
        ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§2❤ §7Rang");
        ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, "§7➝ " + color + rank);
        ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "  ");
        ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§2✪ §7Coins");
        ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, "§7➝  §a" + Database.getCoins(p.getUniqueId()));
        ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "           ");
        /*ScoreboardScore a30 = new ScoreboardScore(scoreboard, obj, "§2⚔ §7Clan");
        ScoreboardScore a40 = new ScoreboardScore(scoreboard, obj, "§7➝§a " + ClanAPI.getClanName(p.getUniqueId()));
        ScoreboardScore a41 = new ScoreboardScore(scoreboard, obj, "    ");*/
        ScoreboardScore a31 = new ScoreboardScore(scoreboard, obj, "§2✦ §7Onlinezeit");
        ScoreboardScore a45 = new ScoreboardScore(scoreboard, obj, "§7➝§a " + onlinetime);
        ScoreboardScore a43 = new ScoreboardScore(scoreboard, obj, "    ");
        ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§7§m-------------");
        ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§8» §a§lPythonMC.DE");
        a1.setScore(12);
        a2.setScore(11);
        a11.setScore(10);
        a4.setScore(9);
        a5.setScore(8);
        a12.setScore(7);
        a6.setScore(6);
        /*a30.setScore(8);
        a40.setScore(7);
        a41.setScore(6);*/
        a31.setScore(5);
        a45.setScore(4);
        a43.setScore(3);
        a7.setScore(2);
        a8.setScore(1);
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
        /*PacketPlayOutScoreboardScore pa15 = new PacketPlayOutScoreboardScore(a30);
        PacketPlayOutScoreboardScore pa16 = new PacketPlayOutScoreboardScore(a40);
        PacketPlayOutScoreboardScore pa17 = new PacketPlayOutScoreboardScore(a41);*/
        new PacketPlayOutScoreboardScore(a31);
        new PacketPlayOutScoreboardScore(a45);
        sendPacket(removePacket, p);
        sendPacket(createPacket, p);
        sendPacket(display, p);
        sendPacket(pa1, p);
        sendPacket(pa2, p);
        sendPacket(pa4, p);
        sendPacket(pa5, p);
        sendPacket(pa6, p);
        sendPacket(pa7, p);
        sendPacket(pa8, p);
        sendPacket(pa11, p);
        sendPacket(pa12, p);
        /*sendPacket(pa15, p);
        sendPacket(pa16, p);
        sendPacket(pa17, p);*/
    }

    private static void sendPacket(Packet packet, Player p) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }


}
