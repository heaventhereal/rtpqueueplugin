package me.yech.rtpqueueplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Rtpqueueplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("rtpqueue")).setExecutor(new RtpQCommand(this));
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
