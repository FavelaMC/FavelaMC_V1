package xyz.favelamc.engine.bukkit.listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class BukkitListener implements Listener {

    @EventHandler
    public void foodLevelChangeEvent(FoodLevelChangeEvent foodLevelChangeEvent) {
        foodLevelChangeEvent.setCancelled(true);
    }

    @EventHandler
    public void playerAchievementAwardedEvent(PlayerAchievementAwardedEvent playerAchievementAwardedEvent) {
        playerAchievementAwardedEvent.setCancelled(true);
    }

    @EventHandler
    public void weatherChangeEvent(WeatherChangeEvent weatherChangeEvent) {
        weatherChangeEvent.setCancelled(true);
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage(null);
    }

    @EventHandler
    public void asyncPlayerChatEvent(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        Player player = asyncPlayerChatEvent.getPlayer();

        if (player.hasPermission("")) {
            asyncPlayerChatEvent.setFormat(player.getDisplayName() + "§5 » §7" + asyncPlayerChatEvent.getMessage().replace("%", "%%").replace("&", "§"));
        } else {
            asyncPlayerChatEvent.setFormat(player.getDisplayName() + "§5 » §7" + asyncPlayerChatEvent.getMessage().replace("%", "%%"));
        }

        World world = asyncPlayerChatEvent.getPlayer().getWorld();

        asyncPlayerChatEvent.getRecipients().retainAll(world.getPlayers());
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
    }
}