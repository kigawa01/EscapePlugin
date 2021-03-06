package net.kigawa.escapeplugin;

import net.kigawa.escapeplugin.command.EscapeCommand;
import net.kigawa.escapeplugin.command.GateCommand;
import net.kigawa.escapeplugin.game.EscapeListener;
import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.gate.GateListener;
import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class EscapePlugin extends KigawaPlugin {
    @Override
    public void addConfigDefault(FileConfiguration config) {

    }

    @Override
    public void onStart() {
        GateManager gateManager = new GateManager(this);
        EscapeManager escapeManager = new EscapeManager(this, gateManager);
        GateListener gateListener=new GateListener(this,gateManager);
        EscapeListener escapeListener=new EscapeListener(this,escapeManager);
        addCommand(new EscapeCommand(this, escapeManager));
        addCommand(new GateCommand(this,gateManager));
    }
}
