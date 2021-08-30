package net.kigawa.escapeplugin.game;

import net.kigawa.escapeplugin.EscapePlugin;
import net.kigawa.escapeplugin.gate.GateManager;
import net.kigawa.escapeplugin.util.plugin.all.message.sender.InfoSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class EscapeGame {
    public static final String ESCAPE = "escape";
    int count;
    private EscapeData data;
    private List<Player> join;
    private EscapePlugin plugin;
    private GateManager gateManager;
    private boolean isStart;

    public EscapeGame(EscapePlugin escapePlugin, EscapeData escapeData, GateManager gateManager) {
        data = escapeData;
        this.plugin = escapePlugin;
        this.gateManager = gateManager;
        save();
    }

    public String start() {
        if (!isStart) {
            join = plugin.getServer().getWorld(data.getWorld()).getPlayers();

            count = 0;
            new BukkitRunnable() {
                @Override
                public void run() {
                    count++;
                    switch (count) {
                        case 1:
                            sendMessage("ある日突然、クラスメイトである小川から連絡が来た。");
                            break;
                        case 2:
                            sendMessage("話によると、何者かにマイクラサーバーを乗っ取られてしまったらしい。");
                            break;
                        case 3:
                            sendMessage("抵抗を試みたが、犯人に存在をバレてしまい、BANされてしまったようだ。");
                            break;
                        case 4:
                            sendMessage("代わりにこんなことをした犯人をBANして欲しいとのこと。");
                            break;
                        case 5:
                            sendMessage("小川は、「存在をバレてから、犯人に見つからないようにヒントを残してきた。」とも言っていた。まずはヒントを探すところから始めよう。");
                    }
                }
            }.runTaskTimer(plugin, 10, 50);

            return "";
        }
        return "game can't start";
    }

    public String end() {
        gateManager.resetAllowed();
        return "";
    }

    public void sendMessage(String message) {
        new InfoSender(message, join);
    }

    public void save() {
        plugin.getRecorder().save(data, ESCAPE);
    }

    public String setWorld(String world) {
        data.setWorld(world);
        save();
        return "set world";
    }

    public String getName() {
        return data.getName();
    }

    public EscapePlugin getPlugin() {
        return plugin;
    }
}
