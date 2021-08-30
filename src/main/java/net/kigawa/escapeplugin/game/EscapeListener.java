package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import net.kigawa.escapeplugin.util.plugin.all.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class EscapeListener extends Event {
    EscapeManager manager;

    public EscapeListener(KigawaPlugin kigawaPlugin, EscapeManager manager) {
        super(kigawaPlugin);
        this.manager = manager;
    }

    @EventHandler
    public void closeEvent(InventoryCloseEvent event) {
        manager.closeEvent(event);
    }

    @EventHandler
    public void pickupEvent(InventoryPickupItemEvent event) {
        manager.pickupEvent(event);
    }
}
