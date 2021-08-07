package net.kigawa.escapeplugin.util.plugin.game.stage.command;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.SecondCommand;
import net.kigawa.escapeplugin.util.plugin.game.stage.StageManager;

public abstract class StageCommandBase extends SecondCommand {
    private StageManager manager;

    public StageCommandBase(KigawaPlugin kigawaPlugin, StageManager manager) {
        super(kigawaPlugin);
        this.manager = manager;
    }

    public StageManager getManager() {
        return manager;
    }
}

