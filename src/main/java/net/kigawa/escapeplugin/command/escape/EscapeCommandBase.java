package net.kigawa.escapeplugin.command.escape;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.SecondCommand;

public abstract class EscapeCommandBase extends SecondCommand {
    private EscapeManager manager;

    public EscapeCommandBase(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin);
        this.manager = manager;
    }

    public EscapeManager getManager() {
        return manager;
    }
}
