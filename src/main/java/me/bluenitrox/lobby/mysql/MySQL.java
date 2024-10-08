package me.bluenitrox.lobby.mysql;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * -------------------------------------------
 *          © Copyright ©
 *
 * This Code is written by Felix Hennerich
 * Github: https://github.com/FelixHennerich
 *
 * You may not edit or use it without access
 *
 * -------------------------------------------
 */
public class MySQL {
    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;
    public static Connection con;

    public static void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=UTF-8", username, password);
                Bukkit.getConsoleSender().sendMessage("§4Verbunden §4mit §4MySQL! (3/8)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void disconnect() {
        if(isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage("§eVerbindung §7mit §eMySQL §cgeschlossen");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        return (con == null ? false : true);
    }

    public static Connection getConnection() {
        if(isConnected()) return con;
        else connect();
        return con;
    }
}