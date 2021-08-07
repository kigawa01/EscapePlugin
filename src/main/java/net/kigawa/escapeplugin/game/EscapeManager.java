package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.EscapePlugin;

import java.util.ArrayList;
import java.util.List;

public class EscapeManager {
    private EscapePlugin plugin;
    public List<EscapeGame> games;

    public EscapeManager(EscapePlugin escapePlugin) {
        plugin = escapePlugin;
        games=new ArrayList<>();

        List<EscapeData> escapeData=plugin.getRecorder().loadAll(EscapeData.class,EscapeGame.ESCAPE);

        for (EscapeData data:escapeData){
            games.add(new EscapeGame(plugin,data));
        }
    }
}
