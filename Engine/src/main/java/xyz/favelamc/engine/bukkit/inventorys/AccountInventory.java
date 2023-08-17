package xyz.favelamc.engine.bukkit.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import xyz.favelamc.engine.bukkit.BukkitLoader;
import xyz.favelamc.engine.bukkit.api.ItemBuilder;

public class AccountInventory implements Listener {

    public static void inventoryAccount(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3 * 9, "§8Suas informações");

        Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitLoader.getPlugin(), () -> {
            inventory.setItem(11, new ItemBuilder().newHeadSkull("§8" + player.getName(), player.getName()
                    , new String[] {} ));
        }, 0, 20);
        player.openInventory(inventory);
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();

        if (inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§8Suas informações")
                && (inventoryClickEvent.getCurrentItem() != null)
                && (inventoryClickEvent.getCurrentItem().getTypeId() != 0)) {
            inventoryClickEvent.setCancelled(true);

            if (inventoryClickEvent.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                inventoryClickEvent.setCancelled(true);
            }
        }
    }
}