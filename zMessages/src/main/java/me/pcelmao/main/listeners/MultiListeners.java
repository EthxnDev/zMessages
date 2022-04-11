package me.pcelmao.main.listeners;

import me.pcelmao.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MultiListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(Main.INSTANCE.getConfig().getBoolean("Messages.Join-Messages.Broadcast.Enabled") == true) {
            e.setJoinMessage(null);
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.INSTANCE.getConfig().getString("Messages.Join-Messages.Broadcast.Message").replace("%player%", p.getName())));
        }
        if (Main.INSTANCE.getConfig().getBoolean("Messages.Join-Messages.Personal.Enabled") == true) {
            e.setJoinMessage(null);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.INSTANCE.getConfig().getString("Messages.Join-Messages.Personal.Message").replace("%player%", p.getName())));
            }
        }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if(Main.INSTANCE.getConfig().getBoolean("Messages.Quit-Messages.Broadcast.Enabled") == true) {
            e.setQuitMessage(null);
            Bukkit.broadcastMessage(Main.INSTANCE.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Messages.Quit-Messages.Broadcast.Message").replace("%player%", p.getName())));
        }else{
            return;
        }
    }
}
