package net.kigawa.escapeplugin.command.escape;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.SecondCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class StartEscape extends SecondCommand {
    public StartEscape(KigawaPlugin kigawaPlugin) {
        super(kigawaPlugin);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
