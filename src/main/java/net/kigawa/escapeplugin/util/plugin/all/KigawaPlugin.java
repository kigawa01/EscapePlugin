package net.kigawa.escapeplugin.util.plugin.all;

import net.kigawa.escapeplugin.util.all.HasEnd;
import net.kigawa.escapeplugin.util.all.Logger;
import net.kigawa.escapeplugin.util.plugin.all.command.FirstCommand;
import net.kigawa.escapeplugin.util.plugin.all.message.Messenger;
import net.kigawa.escapeplugin.util.plugin.all.player.PlayerGetter;
import net.kigawa.escapeplugin.util.plugin.all.player.Teleporter;
import net.kigawa.escapeplugin.util.plugin.all.recorder.Recorder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class KigawaPlugin extends JavaPlugin implements Logger {
    private boolean debug;
    private Recorder recorder;
    private PlayerGetter playerGetter;
    private Messenger messenger;
    private Teleporter teleporter;
    private List<FirstCommand> commands = new ArrayList<>();
    private List<HasEnd> hasEnds = new ArrayList<>();

    public abstract void addConfigDefault(FileConfiguration config);


    @Override
    public void onLoad() {
        logger("onLoad");
    }

    @Override
    public void onEnable() {
        logger("onEnable");
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("debug", false);
        config.addDefault("useDB", false);
        addConfigDefault(config);
        config.options().copyDefaults(true);
        this.saveConfig();
        debug = config.getBoolean("debug");

        recorder = new Recorder(this);
        playerGetter = new PlayerGetter(this);
        messenger = new Messenger(this);
        teleporter = new Teleporter();

        onStart();
    }

    @Override
    public void onDisable() {
        logger("onDisable");
        for (HasEnd hasEnd : hasEnds) {
            hasEnd.end();
        }
    }

    public Teleporter getTeleporter() {
        return teleporter;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public abstract void onStart();

    public void logger(String message) {
        if (debug) {
            this.getLogger().info(message);
        }
    }

    public void logger(int message) {
        if (debug) {
            this.getLogger().info(Integer.toString(message));
        }
    }

    public void logger(boolean message) {
        logger(String.valueOf(message));
    }

    public void logger  (double message){
        logger(Double.toString(message));
    }

    public void addCommand(FirstCommand command) {
        commands.add(command);
        List<String> permission = new ArrayList<>();
        permission.add(getName());
        command.setPermission(permission);
    }

    public void addHasEnd(HasEnd hasEnd) {
        hasEnds.add(hasEnd);
    }

    public Recorder getRecorder() {
        return recorder;
    }

    public PlayerGetter getPlayerGetter() {
        return playerGetter;
    }
}
