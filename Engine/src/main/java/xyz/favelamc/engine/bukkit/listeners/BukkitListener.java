package xyz.favelamc.engine.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage(null);
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
    }
}