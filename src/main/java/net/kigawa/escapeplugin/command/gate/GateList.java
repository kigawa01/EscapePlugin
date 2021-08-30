package net.kigawa.escapeplugin.command.gate;

import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GateList extends GateCommandBase{
    public GateList(KigawaPlugin kigawaPlugin, GateManager gate) {
        super(kigawaPlugin, gate);
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==1){
            Player player=PluginUtil.getPlayer(commandSender);
            if (player!=null) {
                getManager().sendGates(player);
            }
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/gate list";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
