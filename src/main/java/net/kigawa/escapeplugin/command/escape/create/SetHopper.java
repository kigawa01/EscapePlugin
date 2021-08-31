package net.kigawa.escapeplugin.command.escape.create;

import com.sk89q.worldedit.regions.Region;
import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.all.world.BlockRegion;
import net.kigawa.escapeplugin.util.plugin.worldedit.WorldEditUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetHopper extends CreateCommandBase{
    public SetHopper(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin, manager);
    }

    @Override
    public String getName() {
        return "sethopper";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==3&&commandSender instanceof Player){
            Region region= WorldEditUtil.getRegion(PluginUtil.getPlayer(commandSender));
            commandSender.sendMessage(getManager().setHopper(strings[2],new BlockRegion(region).getIntCenter()));
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create <set hopper> <game name>";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
