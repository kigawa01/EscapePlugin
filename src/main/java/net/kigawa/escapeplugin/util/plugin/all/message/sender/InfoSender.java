package net.kigawa.escapeplugin.util.plugin.all.message.sender;

import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.all.message.Messenger;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class InfoSender extends net.kigawa.escapeplugin.util.plugin.all.message.sender.Sender {

    public InfoSender(String title, CommandSender sender) {
        super(sender);
        sender.sendMessage(ChatColor.GREEN + title);
    }

    public InfoSender(String title, List<Player> players) {
        super(PluginUtil.changeListType(players, CommandSender.class));
        Messenger.sendMessage(players, title);
    }
}
