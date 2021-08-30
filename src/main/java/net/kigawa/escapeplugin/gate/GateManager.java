package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.util.plugin.all.message.sender.InfoSender;
import net.kigawa.escapeplugin.util.plugin.all.world.PlayerRegion;
import net.kigawa.escapeplugin.util.plugin.worldedit.WorldEditUtil;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class GateManager {
    private EscapePlugin plugin;
    private List<Player> wait;
    private List<Gate> gates;

    public GateManager(EscapePlugin plugin) {
        this.plugin = plugin;
        List<GateData> gateData;
        gateData = plugin.getRecorder().loadAll(GateData.class, "gate");
        gates = new ArrayList<>();
        for (GateData data : gateData) {
            gates.add(new Gate(plugin, data));
        }
    }

    public void moveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        for (Gate gate : gates) {
            if (gate.contain(player)) {
                gate.addAllowed(plugin.getName());
                if (!wait.contains(player)) {
                    sendGates(player);
                    wait.add(player);
                    return;
                }
            }
        }
        wait.remove(player);
    }

    public String sendGates(Player player) {
        new InfoSender("テレポート可能なゲート ", player);

        for (Gate gate : gates) {
            if (gate.containAllowed(player.getName())) {
                TextComponent textComponent = new TextComponent(gate.getName());
                textComponent.setColor(ChatColor.BLUE);
                textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gate teleport " + gate.getName()));
                player.spigot().sendMessage(textComponent);
            }
        }

        return "";
    }

    public String teleport(String toGate, Player player) {
        Gate gate = getGate(toGate);
        if (gate != null) {
            return gate.teleport(player);
        }
        return toGate + " is null";
    }

    public String resetAllowed() {
        for (Gate gate : gates) {
            gate.resetAllowed();
        }
        return "reset allowed";
    }

    public String create(String gateName, Player player) {
        if (contain(gateName)) {
            GateData data = new GateData();
            data.setName(gateName);
            gates.add(new Gate(plugin, data, new PlayerRegion(WorldEditUtil.getRegion(player))));
        }
        return "gate is exit";
    }

    public boolean contain(String gateName) {
        if (gates != null) {
            gates = new ArrayList<>();
        }
        for (Gate gate : gates) {
            if (gate.getName().equals(gateName)) {
                return true;
            }
        }
        return false;
    }

    public Gate getGate(String gateName) {
        for (Gate gate : gates) {
            if (gate.contain(gateName)) {
                return gate;
            }
        }
        return null;
    }
}