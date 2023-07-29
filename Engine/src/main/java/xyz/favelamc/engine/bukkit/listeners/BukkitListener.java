package xyz.favelamc.engine.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void asyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent asyncPlayerPreLoginEvent) {
        String name = asyncPlayerPreLoginEvent.getName();

        if (name.length() > 16) {
            asyncPlayerPreLoginEvent.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST
                    , "\n§cOcorreu um erro ao conectar!\nseu nick possui mais de 16 caracters.");
        }
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage(null);
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
    }
}