package net.kigawa.escapeplugin.util.plugin.game.stage.command;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.FirstCommand;
import net.kigawa.escapeplugin.util.plugin.game.stage.StageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class StageCommand extends FirstCommand {
    KigawaPlugin plugin;


    public StageCommand(KigawaPlugin plugin, StageManager manager) {
        super(plugin);
        this.plugin=plugin;
        addSubcommands(new CreateCommand(plugin,manager));
        addSubcommands(new SetStartLoc(plugin,manager));
        addSubcommands(new SetStage(plugin,manager));
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
