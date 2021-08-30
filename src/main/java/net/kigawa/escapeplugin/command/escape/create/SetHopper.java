package net.kigawa.escapeplugin.command.escape.create;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

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
        if (strings.length==6){
            commandSender.sendMessage(getManager().setHopper(strings[2],new int[]{
                    Integer.valueOf(strings[3]),Integer.valueOf(strings[4]),Integer.valueOf(strings[5])
            }));
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create <set hopper> <game name> <x> <y> <z>";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
