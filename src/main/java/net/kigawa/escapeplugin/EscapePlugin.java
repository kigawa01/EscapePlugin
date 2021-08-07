package net.kigawa.escapeplugin;

import net.kigawa.escapeplugin.game.EscapeManager;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class EscapePlugin extends KigawaPlugin {
    @Override
    public void addConfigDefault(FileConfiguration config) {

    }

    @Override
    public void onStart() {
        EscapeManager escapeManager=new EscapeManager(this);
    }
}
