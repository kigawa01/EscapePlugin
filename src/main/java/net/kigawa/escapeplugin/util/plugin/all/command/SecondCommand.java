package net.kigawa.escapeplugin.util.plugin.all.command;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;

public abstract class SecondCommand extends Command {
    public SecondCommand(KigawaPlugin kigawaPlugin) {
        super(kigawaPlugin);
    }

    @Override
    public int getWordNumber() {
        return 0;
    }
}
