package net.kigawa.escapeplugin.command.escape.create;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.PluginUtil;
import net.kigawa.escapeplugin.util.plugin.all.world.BlockRegion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetCommandDoor extends CreateCommandBase{
    public SetCommandDoor(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin, manager);
    }

    @Override
    public String getName() {
        return "setcommanddoor";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==3&&commandSender instanceof Player){
            commandSender.sendMessage(getManager().setCommandDoor(strings[2],new BlockRegion(PluginUtil.getPlayer(commandSender)).getCoordinates()));
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create setcommanddoor <game name>";
    }

    @Override
    public boolean isDefault() {
        return false;
    }


    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
