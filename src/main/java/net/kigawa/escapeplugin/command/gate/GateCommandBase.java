package net.kigawa.escapeplugin.command.gate;

import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.command.SecondCommand;

public abstract class GateCommandBase extends SecondCommand {
    private GateManager manager;

    public GateCommandBase(KigawaPlugin kigawaPlugin, GateManager gate) {
        super(kigawaPlugin);
        this.manager = gate;
    }

    public GateManager getManager() {
        return manager;
    }
}
