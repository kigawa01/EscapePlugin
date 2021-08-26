package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.util.plugin.all.recorder.RecorderData;

public class EscapeData extends RecorderData {
String world;

    public void setWorld(String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }
}
