package me.pcelmao.main;

import me.pcelmao.main.listeners.MultiListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerConfig();
        Bukkit.getPluginManager().registerEvents(new MultiListeners(), INSTANCE);
    }

    @Override
    public void onDisable() {
    }
    private void registerConfig(){
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            getLogger().info("Creating new config.yml file...");
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }
}
