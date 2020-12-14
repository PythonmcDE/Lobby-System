package me.bluenitrox.lobby.listener;

import me.bluenitrox.lobby.cases.CaseManager;
import me.bluenitrox.lobby.manager.CosmeticManager;
import me.bluenitrox.lobby.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class EmojiListener {

    public static String replaceDoppelpunkt(String s, UUID uuid) {
        String emotee1 = s;
        if (CaseManager.getItems(uuid, "herz", "emotes") > 0) {
            if(s.contains("<3")) {
                emotee1 = s.replace("<3", "§c❤§7");
            }
        }
        if (CaseManager.getItems(uuid, "rightright", "emotes") > 0) {
            if (s.contains(">>")) {
                emotee1 = s.replace(">>", "§b»§7");
            }
        }
        if (CaseManager.getItems(uuid, "leftleft", "emotes") > 0) {
            if (s.contains("<<")) {
                emotee1 = s.replace("<<", "§b«§7");
            }
        }
        if (CaseManager.getItems(uuid, "rechts", "emotes") > 0) {
            if (s.contains("->")) {
                emotee1 = s.replace("->", "§b➡§7");
            }
        }
        if (CaseManager.getItems(uuid, "richtig", "emotes") > 0) {
            if (s.contains(":right:")) {
                emotee1 = s.replace(":right:", "§a✔§7");
            }
        }
        if (CaseManager.getItems(uuid, "x", "emotes") > 0) {
            if (s.contains(":x:")) {
                emotee1 = s.replace(":x:", "§c✘§7");
            }
        }
        if (CaseManager.getItems(uuid, "headphone", "emotes") > 0) {
            if (s.contains(":headphone:")) {
                emotee1 = s.replace(":headphone:", "♪ d◕‿◕b ♪");
            }
        }
        if (CaseManager.getItems(uuid, "sad", "emotes") > 0) {
            if (s.contains(":sad:")) {
                emotee1 = s.replace(":sad:", "(◕︵◕)");
            }
        }
        if (CaseManager.getItems(uuid, "eye", "emotes") > 0) {
            if (s.contains(":eye:")) {
                emotee1 = s.replace(":eye:", "Ꙭ");
            }
        }
        if (CaseManager.getItems(uuid, "angry", "emotes") > 0) {
            if (s.contains(":angry:")) {
                emotee1 = s.replace(":angry:", "┌∩┐(◣_◢)┌∩┐");
            }
        }
        if (CaseManager.getItems(uuid, "idk", "emotes") > 0) {
            if (s.contains(":idk:")) {
                emotee1 = s.replace(":idk:", "¯\\_(ツ)_/¯");
            }
        }
        return emotee1;
    }

}
