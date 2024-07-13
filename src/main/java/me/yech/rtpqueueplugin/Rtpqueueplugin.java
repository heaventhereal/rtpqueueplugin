package me.yech.rtpqueueplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Rtpqueueplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        RtpQCommand rtpQCommand = new RtpQCommand(this);
        Objects.requireNonNull(getCommand("rtpqueue")).setExecutor(rtpQCommand);
        Objects.requireNonNull(getCommand("rtpqreload")).setExecutor(new RtpqReloadCommand(this, rtpQCommand));
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
