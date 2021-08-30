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
    private List<String> players;

    public Gate(EscapePlugin plugin, GateData data, PlayerRegion region) {
        this.plugin = plugin;
        this.data = data;
        this.region = region;

        plugin.logger("Gate "+region.getWidth());

        save();

    }

    public Gate(EscapePlugin plugin, GateData data) {
        this.plugin = plugin;
        this.data = data;
        this.region = new PlayerRegion(data.getWorld(), data.getCenter()[0], data.getCenter()[1], data.getCenter()[2], data.getSize()[0], data.getSize()[1], data.getSize()[2]);
        players = new ArrayList<>();

        save();
    }

    public boolean contain(Player player) {
        return region.contain(player);
    }

    public boolean contain(String name) {
        return data.getName().equals(name);
    }

    public boolean containAllowed(String playerName) {
        return players.contains(playerName);
    }

    public String teleport(Player player) {
        if (players.contains(player.getName())) {
            player.teleport(new Location(plugin.getServer().getWorld(data.getWorld()), region.getcX(), region.getcY(), region.getcZ()));
            return "teleport " + getName();
        } else return "you can't teleport " + getName();
    }

    public String resetAllowed() {
        players.clear();
        save();
        return "clear allowed";
    }

    public void addAllowed(String playerName) {
        if (players.contains(playerName)) {
            players.add(playerName);
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
