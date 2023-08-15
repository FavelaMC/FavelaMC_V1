package xyz.favelamc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import xyz.favelamc.engine.bukkit.BukkitLoader;
import xyz.favelamc.engine.bukkit.api.ItemBuilder;

public class CollectionsInventory implements Listener {

    public static void inventoryCollections(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3 * 9, "§8Colecionáveis");

        Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitLoader.getPlugin(), () -> inventory.setItem(13, new ItemBuilder().newItem(Material.BARRIER, "§c???"
                , new String[] {}, 1, (byte) 0)), 0, 20);
        player.openInventory(inventory);
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();

        if (inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§8Colecionáveis")
                && (inventoryClickEvent.getCurrentItem() != null)
                && (inventoryClickEvent.getCurrentItem().getTypeId() != 0)) {
            inventoryClickEvent.setCancelled(true);

            if (inventoryClickEvent.getCurrentItem().getType().equals(Material.BARRIER)) {
                inventoryClickEvent.setCancelled(true);
            }
        }
    }
}