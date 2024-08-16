package me.bluenitrox.lobby.coins;


import me.bluenitrox.lobby.mysql.MySQL;

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
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");){
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `coinmanager` (`uuid` VARCHAR(255) NOT NULL, `coins` INT)");){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void setCoinsToDatabase(UUID uuid, int coins) {
        if (!this.isUserExists(uuid)) {
            return;
        }
        int newCoins = coins;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");){
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCoinsToDatabase(UUID uuid, int removeCoins) {
        if (!this.isUserExists(uuid)) {
            return;
        }
        int newCoins = getCoins(uuid) - removeCoins;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE coinmanager SET coins = ? WHERE uuid = ?");){
            preparedStatement.setInt(1, newCoins);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCoins(UUID uuid) {
        if (!isUserExists(uuid)) {
            return 1396354654;
        }
        int i = 0;
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins from coinmanager WHERE uuid = ?");){
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
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO coinmanager (uuid,coins) VALUES (?,?)");){
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setInt(2, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean isUserExists(UUID uuid) {
        try (Connection connection = MySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT uuid from coinmanager WHERE uuid = ?");){
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
