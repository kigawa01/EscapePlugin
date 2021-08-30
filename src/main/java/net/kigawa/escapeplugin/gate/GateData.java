package net.kigawa.escapeplugin.gate;

import net.kigawa.escapeplugin.util.plugin.all.recorder.RecorderData;
import net.kigawa.escapeplugin.util.plugin.all.world.PlayerRegion;

import java.util.List;

public class GateData extends RecorderData {
    String world;
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

    public void setSize(double[] size) {
        this.size = size;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }

    public double[] getSize() {
        return size;
    }

    public double[] getCenter() {
        return center;
    }
}
