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

    public String start(String gameName){
        EscapeGame game=getGame(gameName);
        if (game!=null){
            return game.start();
        }else {
            return "game is null";
        }
    }

    public String end(String gameName){
        EscapeGame game=getGame(gameName);
        if (game!=null){
            return game.end();
        }else {
            return "game is null";
        }
    }

    public String create(String gameName){
        EscapeGame escapeGame=getGame(gameName);
        if (escapeGame==null){
            EscapeData data=new EscapeData();
            data.setName(gameName);
            games.add(new EscapeGame(plugin,data));
            return "game is created";
        }else {
            return "game is exit";
        }
    }

    public EscapeGame getGame(String name){
        for (EscapeGame game:games){
            if (game.getName().equals(name)){
                return game;
            }
        }
        return null;
    }
}
