package xyz.favelamc.lobby.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.favelamc.engine.bukkit.inventorys.AccountInventory;
import xyz.favelamc.lobby.inventorys.CollectionsInventory;
import xyz.favelamc.lobby.inventorys.ServerInventory;
import xyz.favelamc.lobby.manager.LobbyManager;

public class LobbyListener implements Listener {

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.setJoinMessage(null);

        Player player = playerJoinEvent.getPlayer();
        LobbyManager.loadPlayer(player);
    }

    @EventHandler
    public void playerDropItemEvent(PlayerDropItemEvent playerDropItemEvent) {
        playerDropItemEvent.setCancelled(true);
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
    public void playerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        playerQuitEvent.setQuitMessage(null);
    }
}