package xyz.favelamc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import xyz.favelamc.engine.bukkit.api.ItemBuilder;
import xyz.favelamc.lobby.manager.auth.LoginManager;
import java.util.Random;

public class CaptchaInventory implements Listener {

    protected static int randomSword() {
        Random random = new Random();
        int number = random.nextInt(3);

        switch (number) {
            case 0:
                number = 1;
                break;
            case 1:
                number = 12;
                break;
            case 2:
                number = 25;
                break;
        }
        return number;
    }

    public static void inventoryCaptcha(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 3 * 9, "§8Você é humano?");

        inventory.setItem(randomSword(), new ItemBuilder().newItem(Material.DIAMOND_SWORD, "§a-"
                , new String[] {}, 1, (byte) 0));

        for (int number = 0; number < 27; number++) {
            inventory.addItem(new ItemBuilder().newItem(Material.MUSHROOM_SOUP, "§7-"
                    , new String[] {}, 1, (byte) 0));
        }
        player.openInventory(inventory);
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();

        if (inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§8Você é humano?")
                && (inventoryClickEvent.getCurrentItem() != null)
                && (inventoryClickEvent.getCurrentItem().getTypeId() != 0)) {
            inventoryClickEvent.setCancelled(true);

            if (inventoryClickEvent.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) {
                inventoryClickEvent.setCancelled(true);

                LoginManager.removeCaptcha(player.getUniqueId());

                player.closeInventory();
                player.sendMessage("§aVocê acertou o captcha com sucesso!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
            } else if (inventoryClickEvent.getCurrentItem().getType().equals(Material.MUSHROOM_SOUP)) {
                inventoryClickEvent.setCancelled(true);

                player.closeInventory();
                player.sendMessage("§cVocê não acertou o captcha :(");
            }
        }
    }
}