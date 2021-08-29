package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.util.plugin.all.recorder.RecorderData;
import net.kigawa.escapeplugin.util.plugin.all.world.PlayerRegion;

import java.util.List;

public class GateData extends RecorderData {
    String world;
    List<String> players;
    double[] center;
    double[] size;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public void setRegion(PlayerRegion region) {
        world = region.getWorld();
        center = new double[]{
                region.getcX(), region.getcY(), region.getcZ()
        };
        size = new double[]{
                region.getWidth(), region.getHeight(), region.getLength()
        };
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
