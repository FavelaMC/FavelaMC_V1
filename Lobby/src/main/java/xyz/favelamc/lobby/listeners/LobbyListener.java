package xyz.favelamc.lobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.*;
import xyz.favelamc.engine.bukkit.inventorys.AccountInventory;
import xyz.favelamc.lobby.LobbyLoader;
import xyz.favelamc.lobby.inventorys.CaptchaInventory;
import xyz.favelamc.lobby.inventorys.CollectionsInventory;
import xyz.favelamc.lobby.inventorys.ServerInventory;
import xyz.favelamc.lobby.manager.LobbyManager;
import xyz.favelamc.lobby.manager.auth.LoginManager;

public class LobbyListener implements Listener {

    @EventHandler
    public void entityDamageEvent(EntityDamageEvent entityDamageEvent) {
        entityDamageEvent.setCancelled(true);
    }

    @EventHandler
    public void blockBreakEvent(BlockBreakEvent blockBreakEvent) {
        blockBreakEvent.setCancelled(true);
    }

    @EventHandler
    public void blockPlaceEvent(BlockPlaceEvent blockPlaceEvent) {
        blockPlaceEvent.setCancelled(true);
    }

    @EventHandler
    public void playerDropItemEvent(PlayerDropItemEvent playerDropItemEvent) {
        playerDropItemEvent.setCancelled(true);
    }

    @EventHandler
    public void playerLoginEvent(PlayerLoginEvent playerLoginEvent) {
        Player player = playerLoginEvent.getPlayer();

        LoginManager.addCaptcha(player.getUniqueId());
        Bukkit.getScheduler().scheduleSyncDelayedTask(LobbyLoader.getPlugin(), () ->
                CaptchaInventory.inventoryCaptcha(player), 5);
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage(null);

        Player player = playerJoinEvent.getPlayer();
        LobbyManager.loadPlayer(player);
    }

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent playerInteractEvent) {
        Player player = playerInteractEvent.getPlayer();

        if (player.getItemInHand().getType().equals(Material.COMPASS)) {
            if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                ServerInventory.inventoryServer(player);
            } else if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                playerInteractEvent.setCancelled(true);
                ServerInventory.inventoryServer(player);
            }
        } else if (player.getItemInHand().getType().equals(Material.SKULL_ITEM)) {
            if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                AccountInventory.inventoryAccount(player);
            } else if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                playerInteractEvent.setCancelled(true);
                AccountInventory.inventoryAccount(player);
            }
        } else if (player.getItemInHand().getType().equals(Material.CHEST)) {
            if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                CollectionsInventory.inventoryCollections(player);
            } else if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                playerInteractEvent.setCancelled(true);
                CollectionsInventory.inventoryCollections(player);
            }
        }
    }

    @EventHandler
    public void inventoryCloseEvent(InventoryCloseEvent inventoryCloseEvent) {
        Player player = (Player) inventoryCloseEvent.getPlayer();

        Bukkit.getScheduler().runTaskLater(LobbyLoader.getPlugin(), () -> {
            if (LoginManager.inCaptcha(player.getUniqueId())) {
                CaptchaInventory.inventoryCaptcha(player);
            }
        }, 5);
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);

        Player player = playerQuitEvent.getPlayer();
        LoginManager.removeCaptcha(player.getUniqueId());
    }
}