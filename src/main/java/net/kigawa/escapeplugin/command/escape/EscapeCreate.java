package net.kigawa.escapeplugin.command.escape;

import net.kigawa.escapeplugin.command.escape.create.SetCommandDoor;
import net.kigawa.escapeplugin.command.escape.create.SetHopper;
import net.kigawa.escapeplugin.command.escape.create.SetWorld;
import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class EscapeCreate extends EscapeCommandBase{
    public EscapeCreate(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin, manager);
        addSubcommands(new net.kigawa.escapeplugin.command.escape.create.EscapeCreate(kigawaPlugin,manager));
        addSubcommands(new SetWorld(kigawaPlugin,manager));
        addSubcommands(new SetHopper(kigawaPlugin,manager));
        addSubcommands(new SetCommandDoor(kigawaPlugin,manager));
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public boolean onThisCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    @Override
    public String errorMessage() {
        return "/escape create ";
    }

    @Override
    public List<String> getTabStrings(CommandSender sender, Command command, String label, String[] strings) {
        return null;
    }
}
