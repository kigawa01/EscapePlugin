package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.util.plugin.all.world.PlayerRegion;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Gate {
    private PlayerRegion region;
    private GateData data;
    private EscapePlugin plugin;

    public Gate(EscapePlugin plugin, GateData data, PlayerRegion region) {
        this.plugin = plugin;
        this.data = data;
        this.region = region;

        setup();

    }

    public Gate(EscapePlugin plugin, GateData data) {
        this.plugin = plugin;
        this.data = data;
        this.region = new PlayerRegion(data.getWorld(), data.getCenter()[0], data.getCenter()[1], data.getCenter()[2], data.getSize()[0], data.getSize()[1], data.getSize()[2]);

        setup();
    }

    public void setup() {
        List<String> playerName = data.getPlayers();
        if (playerName == null) {
            playerName = new ArrayList<>();
        }
        save();
    }

    public boolean contain(Player player) {
        return region.contain(player);
    }

    public boolean contain(String name) {
        return data.getName().equals(name);
    }

    public boolean containAllowed(String playerName) {
        return data.getPlayers().contains(playerName);
    }

    public String teleport(Player player) {
        if (data.getPlayers().contains(player.getName())) {
            player.teleport(new Location(plugin.getServer().getWorld(data.getWorld()), region.getcX(), region.getcY(), region.getcZ()));
            return "teleport " + getName();
        } else return "you can't teleport " + getName();
    }

    public String resetAllowed() {
        data.getPlayers().clear();
        save();
        return "clear allowed";
    }

    public void addAllowed(String playerName) {
        if (data.getPlayers().contains(playerName)) {
            data.getPlayers().add(playerName);
            save();
        }
    }

    public void save() {
        data.setRegion(region);
        plugin.getRecorder().save(data, "gate");
    }

    public String getName() {
        return data.getName();
    }
}
