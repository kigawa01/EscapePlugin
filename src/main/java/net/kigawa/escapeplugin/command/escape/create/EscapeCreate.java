package net.kigawa.escapeplugin.command.escape.create;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class EscapeCreate extends CreateCommandBase{
    public EscapeCreate(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin, manager);
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==3){
            commandSender.sendMessage(getManager().create(strings[2]));
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create create <game name>";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
