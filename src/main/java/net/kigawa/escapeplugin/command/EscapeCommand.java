package net.kigawa.escapeplugin.command;

import net.kigawa.escapeplugin.command.escape.EscapeCreate;
import net.kigawa.escapeplugin.command.escape.StartEscape;
import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.FirstCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class EscapeCommand extends FirstCommand {
    public EscapeCommand(KigawaPlugin plugin, EscapeManager manager) {
        super(plugin);
        addSubcommands(new StartEscape(plugin,manager));
        addSubcommands(new EscapeCreate(plugin,manager));
    }

    @Override
    public String getName() {
        return "escape";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape <sub command>";
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
