package net.kigawa.escapeplugin.util.plugin.all.command;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public abstract class FirstCommand extends Command implements CommandExecutor, TabCompleter {
    KigawaPlugin plugin;

    public FirstCommand(KigawaPlugin plugin) {
        super(plugin);
        this.plugin = plugin;

        plugin.getCommand(getName()).setExecutor(this);
        plugin.getCommand(getName()).setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return tabComplete(commandSender, command, s, strings);
    }
    @Override
    public void addSubcommands(Command subCommand) {
        getSubCommands().add(subCommand);
        addTabLists(subCommand);
    }

    @Override
    public boolean onCommand(
            CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        plugin.logger(getName() + " onAlways");
        if (strings.length > 0) {

            plugin.logger(getName() + " onIsContain");

            if (getSubCommands() != null) {
                if (getSubCommands().contains(new EqualsCommand(strings[0]))) {
                    plugin.logger(getName() + " onGetSubCommand");
                    Command subCommand = getSubCommands().get(getSubCommands().indexOf(new EqualsCommand(strings[0])));
                    return subCommand.onCommand(commandSender, command, s, strings);
                }
            }
        }
        //check permission
        if (checkPermission(commandSender)) {
            plugin.logger(getName() + " onNotFound");
            return onThisCommand(commandSender, command, s, strings);
        }else {
            commandSender.sendMessage("need permission");
            return true;
        }
    }


    @Override
    public int getWordNumber() {
        return 0;
    }
}
