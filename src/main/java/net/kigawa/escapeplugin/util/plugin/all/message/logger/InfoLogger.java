package net.kigawa.escapeplugin.util.plugin.all.message.logger;

import org.bukkit.ChatColor;

public class InfoLogger extends Logger {
    public InfoLogger(String title, net.kigawa.escapeplugin.util.all.Logger logger) {
        super(logger);
        logger(ChatColor.GREEN + title);
    }
}
