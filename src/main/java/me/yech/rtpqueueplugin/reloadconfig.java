package me.yech.rtpqueueplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class reloadconfig implements CommandExecutor {
    private final Rtpqueueplugin plugin;
    FileConfiguration config;
    File cfile;
    public reloadconfig(Rtpqueueplugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("rtpqreload")) {
            if (!(commandSender instanceof Player player)) return false;
            config = YamlConfiguration.loadConfiguration(cfile);
            String configreload = this.plugin.getConfig().getString("config-reloaded");
            assert configreload != null;
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', configreload));
        }
        return true;
    }
}
