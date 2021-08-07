package net.kigawa.escapeplugin.util.plugin.all.message.logger;

import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.all.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Logger {
    private net.kigawa.escapeplugin.util.all.Logger logger;

    public Logger(net.kigawa.escapeplugin.util.all.Logger logger) {
        this.logger = logger;
    }

    public void sendItem(String itemName, String description) {
        logger(ChatColor.BLUE + itemName + ChatColor.WHITE + ": " + description);
    }

    public void sendItem(String itemName, int[] description) {
        sendItem(itemName, Util.createString(description));
    }

    public void sendItem(String itemName, int i) {
        sendItem(itemName, Integer.toString(i));
    }
    public void sendItem(String itemName, List<Player> players){
        sendItem(itemName, PluginUtil.createString(players));
    }

    public net.kigawa.escapeplugin.util.all.Logger getLogger() {
        return this.logger;
    }

    public void logger(String message) {
        this.logger.logger(message);
    }
}
