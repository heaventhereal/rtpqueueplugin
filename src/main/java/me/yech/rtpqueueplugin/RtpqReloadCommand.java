package me.yech.rtpqueueplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class RtpqReloadCommand implements CommandExecutor {
    private final Rtpqueueplugin plugin;
    private final RtpQCommand rtpQCommand;

    public RtpqReloadCommand(Rtpqueueplugin plugin, RtpQCommand rtpQCommand) {
        this.plugin = plugin;
        this.rtpQCommand = rtpQCommand;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rtpqreload")) {
            plugin.reloadConfig();
            rtpQCommand.updateConfigValues();
            String configreload = this.plugin.getConfig().getString("config-reloaded");
            assert configreload != null;
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configreload));
            return true;
        }
        return false;
    }
}
