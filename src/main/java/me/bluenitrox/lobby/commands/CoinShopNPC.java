package me.bluenitrox.lobby.commands;

import me.bluenitrox.lobby.cases.CoinShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinShopNPC implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        CoinShop css = new CoinShop();
        p.openInventory(css.coinshop());
        return false;
    }
}
