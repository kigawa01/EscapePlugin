package net.kigawa.escapeplugin.util.plugin.all.message.logger;

import net.kigawa.escapeplugin.util.all.Logger;
import net.kigawa.escapeplugin.util.plugin.all.KigawaPlugin;

public abstract class PluginLogger implements Logger {
    KigawaPlugin plugin;

    public PluginLogger(KigawaPlugin kigawaPlugin) {
        plugin = kigawaPlugin;
    }

    @Override
    public void logger(String message) {
        plugin.logger(message);
    }
}
