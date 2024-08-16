package me.bluenitrox.lobby.coins;


import me.bluenitrox.lobby.manager.ScoreboardManager;
import me.bluenitrox.lobby.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.jline.reader.Buffer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Databaseconnector {

    public void addCoinsToDatabase(UUID uuid, int addCoins) {
        if (!this.isUserExists(uuid)) {
            return;
        }
        int newCoins = getCoins(uuid) + addCoins;
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
    }

    public void setCoinsToDatabase(UUID uuid, int coins) {
        if (!this.isUserExists(uuid)) {
            return;
        }
        int newCoins = coins;
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));

    }

    public void removeCoinsToDatabase(UUID uuid, int removeCoins) {
        if (!this.isUserExists(uuid)) {
            return;
        }
        int newCoins = getCoins(uuid) - removeCoins;
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));

    }

    public int getCoins(UUID uuid) {
        if (!isUserExists(uuid)) {
            return 0;
        }
        int i = 0;
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT coins from coinmanager WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                i = resultSet.getInt("coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void setInDatabase(UUID uuid) {
        if (this.isUserExists(uuid)) {
            return;
        }
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("INSERT INTO coinmanager (uuid,coins) VALUES (?,?)");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setInt(2, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));

    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean isUserExists(UUID uuid) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT uuid from coinmanager WHERE uuid = ?");
            preparedStatement.setString(1, uuid.toString());
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                if (!resultSet.next()) return false;
                boolean bl = true;
                return bl;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
