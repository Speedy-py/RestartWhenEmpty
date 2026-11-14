package me.restart;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class RestartWhenEmpty extends JavaPlugin {

    // 20 minutes = 24000 ticks. shortcut: hardcoded, move to config.yml if you want to change it often.
    private static final long INTERVAL_TICKS = 20L * 60 * 20;

    @Override
    public void onEnable() {
        // Runs every 20 min; does nothing at all while anyone is online.
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (Bukkit.getOnlinePlayers().isEmpty()) {
                getLogger().info("Server empty, restarting...");
                Bukkit.spigot().restart();
            }
        }, INTERVAL_TICKS, INTERVAL_TICKS);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Restarting server...");
        Bukkit.spigot().restart();
        return true;
    }
}
