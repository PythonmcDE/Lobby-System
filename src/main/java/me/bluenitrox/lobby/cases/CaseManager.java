package me.bluenitrox.lobby.cases;

import me.bluenitrox.all.Database;
import me.bluenitrox.lobby.manager.MessageManager;
import me.bluenitrox.lobby.mysql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CaseManager {

    public static void givePlayerWin(Player p, ItemStack win){
        UUID uuid = p.getUniqueId();
        if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLobby-Coins")){
            /*

            LOBBYCOINS

             */
            String[] amount = win.getItemMeta().getLore().get(0).split(" ");
            int wert = Integer.parseInt(amount[2]);
            Database.update(p.getUniqueId(), wert, false);
            p.sendMessage(MessageManager.PREFIX + "§7Du hast §6§l" + wert + " Coins §7gewonnen!");
        }else if(win.getItemMeta().getDisplayName().startsWith("§8» §7Emote:")){
            /*

            EMOTES

             */
            if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "rightright","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b «")){
                updateItems(uuid, 1, false, "leftleft","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b ➡")){
                updateItems(uuid, 1, false, "rechts","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b ✔")){
                updateItems(uuid, 1, false, "richtig","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b ✘")){
                updateItems(uuid, 1, false, "x","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b ❤")){
                updateItems(uuid, 1, false, "herz","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "angry","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "eye","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "sad","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "headphone","emotes");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Emote:§b »")){
                updateItems(uuid, 1, false, "idk","emotes");
            }
        }else if(win.getItemMeta().getDisplayName().startsWith("§8» §7Fähigkeit:§6")){
            /*

            FÄHIGKEITEN

             */
            if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Fähigkeit:§6 Doublejump")){
                updateItems(uuid,1, false, "doublejump","bekleidung");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Fähigkeit:§6 Speed")){
                updateItems(uuid,1, false, "speed","bekleidung");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Fähigkeit:§6 Sprungkraft")){
                updateItems(uuid,1, false, "sprungkraft","bekleidung");
            }

            /*

            GADGETS

             */
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lBombe")){
            updateItems(uuid, 1, false, "tnt", "gadgets");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lEnterhaken")){
            updateItems(uuid, 1, false, "enterhaken", "gadgets");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSchneeballwerfer")){
            updateItems(uuid, 1, false, "iron", "gadgets");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lEierwerfer")){
            updateItems(uuid, 1, false, "gold", "gadgets");
        }else if(win.getItemMeta().getDisplayName().startsWith("§7Banner")){
            /*

            BANNER

             */
            if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §1Blau")){
                updateItems(uuid, 1, false, "bannerblue", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §4Rot")){
                updateItems(uuid, 1, false, "bannerred", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §2Grün")){
                updateItems(uuid, 1, false, "bannergreen", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §eGeld")){
                updateItems(uuid, 1, false, "banneryellow", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §7Grau")){
                updateItems(uuid, 1, false, "bannergrey", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §0Schwarz")){
                updateItems(uuid, 1, false, "bannerblack", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §dPink")){
                updateItems(uuid, 1, false, "bannerpink", "gadgets");
            }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§7Banner §6Orange")){
                updateItems(uuid, 1, false, "bannerorange", "gadgets");
            }

            /*

            KÖPFE

             */
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cGommeHD")){
            updateItems(uuid, 1, false, "gomme", "kopf");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cBenx")){
            updateItems(uuid, 1, false, "benx", "kopf");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cPaluten")){
            updateItems(uuid, 1, false, "palle", "kopf");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cGermanLetsPlay")){
            updateItems(uuid, 1, false, "glp", "kopf");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cAbgegrieftHD")){
            updateItems(uuid, 1, false, "abge", "kopf");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§cLogo")){
            updateItems(uuid, 1, false, "logo", "kopf");
            /*

            BEKLEIDUNG

             */
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVolle Dämonen Brustplatte")){
            updateItems(uuid, 1, false, "daemonen", "bekleidung");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§9§lDrip Boots")){
            updateItems(uuid, 1, false, "drip", "bekleidung");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lFlame Boots")){
            updateItems(uuid, 1, false, "flame", "bekleidung");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§5§lZauberer Schuhe")){
            updateItems(uuid, 1, false, "zauberer", "bekleidung");
        }else if(win.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSchnee Schuhe")){
            updateItems(uuid, 1, false, "schnee", "bekleidung");
        }
    }

    public static void cachPlayerData(UUID uuid){
        if(!isUserExists(uuid)) {
            configuratePlayer(uuid);
        }
        if(!isUserExistsEm(uuid)) {
            configuratePlayerEm(uuid);
        }
        if(!isUserExistsBek(uuid)) {
            configuratePlayerBek(uuid);
        }
        if(!isUserExistsGad(uuid)) {
            configuratePlayerGad(uuid);
        }
    }

    public static int get(UUID uuid,String get) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + get +" FROM spielerdaten WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt(get);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public static int getItems(UUID uuid,String get, String table) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + get +" FROM " + table +" WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt(get);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public static void updateItems(UUID uuid, float amount, boolean remove, String get, String table) {
        float currMoney = getItems(uuid,get, table);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + table +" SET " + get +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(UUID uuid, float amount, boolean remove, String get) {
        float currMoney = get(uuid,get);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET " + get +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configuratePlayer(UUID uuid) {
        if(!isUserExists(uuid)) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO spielerdaten (UUID, cases) VALUES (?, ?)")) {
                ps.setString(1, uuid.toString());
                ps.setInt(2, 0);
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void configuratePlayerEm(UUID uuid) {
        if(!isUserExistsEm(uuid)) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO emotes (UUID, rightright, leftleft, rechts, richtig, x, herz, angry, eye, sad, headphone, idk) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)")) {
                ps.setString(1, uuid.toString());
                ps.setInt(2, 0);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setInt(9, 0);
                ps.setInt(10, 0);
                ps.setInt(11, 0);
                ps.setInt(12, 0);
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void configuratePlayerBek(UUID uuid) {
        if(!isUserExistsBek(uuid)) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO bekleidung (UUID, daemonen, drip,flame,zauberer,schnee,sprungkraft,speed,doublejump) VALUES (?, ?,?,?,?,?,?,?,?)")) {
                ps.setString(1, uuid.toString());
                ps.setInt(2, 0);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setInt(9, 0);
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void configuratePlayerGad(UUID uuid) {
        if(!isUserExistsGad(uuid)) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO gadgets (UUID, tnt, enterhaken,iron,gold,bannerblue,bannerred,bannergreen,banneryellow,bannergrey, bannerblack,bannerpink,bannerorange) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?)")) {
                ps.setString(1, uuid.toString());
                ps.setInt(2, 0);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setInt(9, 0);
                ps.setInt(10, 0);
                ps.setInt(11, 0);
                ps.setInt(12, 0);
                ps.setInt(13, 0);
                ps.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM spielerdaten WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isUserExistsEm(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM emotes WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isUserExistsBek(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM bekleidung WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isUserExistsGad(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM gadgets WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
