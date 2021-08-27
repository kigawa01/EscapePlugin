package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class GateListener extends Event {
    private GateManager gate;

    public GateListener(KigawaPlugin kigawaPlugin, GateManager gate) {
        super(kigawaPlugin);
        this.gate=gate;
    }

    @EventHandler
    public void moveEvent(PlayerMoveEvent event){
        gate.moveEvent(event);
    }
}