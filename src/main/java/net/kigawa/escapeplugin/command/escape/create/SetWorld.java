package net.kigawa.escapeplugin.command.escape.create;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class SetWorld extends CreateCommandBase{
    public SetWorld(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin, manager);
    }

    @Override
    public String getName() {
        return "setworld";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==4){
            commandSender.sendMessage(getManager().setWorld(strings[2],strings[3]));
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create setworld <game name> <world>";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
