package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.util.plugin.all.recorder.RecorderData;

import java.util.List;

public class GateData extends RecorderData {
    String world;
    List<String> players;

    public void setWorld(String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return players;
    }
}
