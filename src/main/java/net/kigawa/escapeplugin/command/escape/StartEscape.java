package net.kigawa.escapeplugin.command.escape;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class StartEscape extends EscapeCommandBase {
    public StartEscape(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin,manager);
    }

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length==2){
            getManager().start(strings[1]);
            return true;
        }
        return false;
    }

    @Override
    public String errorMessage() {
        return "/game start <game name>";
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
