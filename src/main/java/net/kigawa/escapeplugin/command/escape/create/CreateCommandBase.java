package net.kigawa.escapeplugin.command.escape.create;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.ThirdCommand;

public abstract class CreateCommandBase extends ThirdCommand {
    private EscapeManager manager;

    public CreateCommandBase(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin);
        this.manager=manager;
    }

    public EscapeManager getManager() {
        return manager;
    }
}
