package net.kigawa.escapeplugin.util.plugin.game.stage.command;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.game.stage.StageManager;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetStartLoc extends StageCommandBase {
    KigawaPlugin plugin;

    public SetStartLoc(KigawaPlugin kigawaPlugin, StageManager manager) {
        super(kigawaPlugin,manager);
        plugin = kigawaPlugin;
    }

    @Override
    public String getName() {
        return "setstartloc";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        //check args
        if (strings.length == 5) {
            //set start loc
            getManager().setStartLoc(strings[1], Integer.valueOf(strings[2]), Integer.valueOf(strings[3]), Integer.valueOf(strings[4]),
                    commandSender);
            //send message
            commandSender.sendMessage("set start loc");
        } else {
            commandSender.sendMessage("/stage setstartloc <game name> <x> <y> <z>");
        }
        return true;
    }

    @Override
    public int getWordNumber() {
        return 0;
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, org.bukkit.command.Command command, String label, String[] strings) {
        if (strings.length==2){
            return getManager().getStageNames();
        }
        if (strings.length==3){
            List<String> list=new ArrayList();
            Player player= PluginUtil.isPlayer(sender);
            Location loc=player.getLocation();
            list.add(Integer.toString(loc.getBlockX())+Integer.toString(loc.getBlockY())+Integer.toString(loc.getBlockX()));
            return list;
        }
        return null;
    }
}
