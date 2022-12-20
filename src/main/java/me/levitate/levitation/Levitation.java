package me.levitate.levitation;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.levitate.levitation.commands.MainCommand;
import me.levitate.levitation.managers.LevitationManager;

public final class Levitation extends JavaPlugin {

    private static LevitationManager levitationManager;

    @Override
    public void onEnable() {
        levitationManager = new LevitationManager();

        // Registers the levitate command.
        getCommand("levitate").setExecutor(new MainCommand());

        // Spawns the particles around every player that is levitating.
        new BukkitRunnable() {
            @Override
            public void run() {
                levitationManager.spawnParticles();
            }
        }.runTaskTimer(this, 0, 1);
    }

    public static LevitationManager getLevitationManager() {
        return levitationManager;
    }

}
