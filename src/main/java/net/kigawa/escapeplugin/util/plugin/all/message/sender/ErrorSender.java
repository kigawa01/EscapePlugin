package net.kigawa.escapeplugin.util.plugin.all.message.sender;


import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.all.message.Messenger;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ErrorSender extends net.kigawa.escapeplugin.util.plugin.all.message.sender.Sender {
    public ErrorSender(String title, Player player) {
        super(player);
        player.sendMessage(ChatColor.RED + title);
    }

    public ErrorSender(String title, List<Player> senders) {
        super(PluginUtil.changeListType(senders, CommandSender.class));
        Messenger.sendMessage(senders, title);
    }
}
