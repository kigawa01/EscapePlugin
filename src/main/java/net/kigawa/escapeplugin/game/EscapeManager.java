package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.gate.GateManager;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class EscapeManager {
    private EscapePlugin plugin;
    private GateManager gateManager;
    private List<EscapeGame> games;

    public EscapeManager(EscapePlugin escapePlugin,GateManager gateManager) {
        plugin = escapePlugin;
        games=new ArrayList<>();
        this.gateManager=gateManager;

        List<EscapeData> escapeData=plugin.getRecorder().loadAll(EscapeData.class,EscapeGame.ESCAPE);

        for (EscapeData data:escapeData){
            games.add(new EscapeGame(plugin,data,gateManager));
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
            games.add(new EscapeGame(plugin,data,gateManager));
            return "game is created";
        }else {
            return "game is exit";
        }
    }

    public void interactEvent(PlayerInteractEvent event){
        for (EscapeGame game:games){
            game.interactEvent(event);
        }
    }

    public void closeEvent(InventoryCloseEvent event){
        plugin.logger("manager close event");
        for (EscapeGame game:games){
            game.closeEvent(event);
        }
    }

    public void pickupEvent(InventoryPickupItemEvent event){
        for (EscapeGame game:games){
            game.pickupEvent(event);
        }
    }

    public String setCommandDoor(String gameName,int[] door){
        EscapeGame game=getGame(gameName);
        if (game!=null){
            return game.setCommandDoor(door);
        }return "game is not exit";
    }

    public String setWorld(String gameName,String world){
        EscapeGame game=getGame(gameName);
        if (game!=null){
            return game.setWorld(world);
        }else {
            return "game is not exit";
        }
    }

    public String setHopper(String gameName,int[] loc){
        EscapeGame game=getGame(gameName);
        if (game!=null){
            return game.setHopper(loc);
        }
        return "game is not exit";
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
