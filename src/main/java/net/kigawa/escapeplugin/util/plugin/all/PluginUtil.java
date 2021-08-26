package net.kigawa.escapeplugin.util.plugin.all;

import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PluginUtil {
    public static World getWorld(CommandSender sender) {
        World world = null;
        if (sender instanceof Player | sender instanceof BlockCommandSender) {

            if (sender instanceof Player) {
                world = ((Player) sender).getWorld();
            }
            if (sender instanceof BlockCommandSender) {
                world = ((BlockCommandSender) sender).getBlock().getWorld();
            }
        } else {
            sender.sendMessage("this command can use by player or commandBlock");
        }
        return world;
    }

    public static Player isPlayer(CommandSender sender) {
        if (sender instanceof Player) {
            return (Player) sender;
        } else {
            sender.sendMessage("you are not player");
            return null;
        }
    }
    public static String createString(List<Player> players){
            StringBuilder str= new StringBuilder(players.get(0).getName());
            for (int i=1;i<players.size();i++){
                str.append(", ").append(players.get(i).getName());
            }
            return str.toString();
    }
    public static void playSound(List<Player> players, Sound sound,float volume,float pitch){
        for (Player player:players){
            player.playSound(player.getLocation(),sound,volume,pitch);
        }
    }
}
