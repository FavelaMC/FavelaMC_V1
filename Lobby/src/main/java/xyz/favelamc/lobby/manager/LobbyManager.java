package xyz.favelamc.lobby.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import xyz.favelamc.engine.FavelaMC;
import xyz.favelamc.engine.bukkit.api.ItemBuilder;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.UUID;

public class LobbyManager {

    public static ArrayList<UUID> captcha;

    public static boolean getCaptcha(UUID uuid) {
        return LobbyManager.captcha.contains(uuid);
    }

    public static void setCaptcha(UUID uuid) {
        LobbyManager.captcha.add(uuid);
    }

    public static void removeCaptcha(UUID uuid) {
        LobbyManager.captcha.remove(uuid);
    }

    public static void loginPlayer(Player player) {
        setCaptcha(player.getUniqueId());
    }

    public static void loadPlayer(Player player) {
        player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        player.setHealth(20);

        player.getInventory().clear();
        player.getInventory().setItem(0, new ItemBuilder().newItem(Material.COMPASS, "§a§oSelecione um jogo " +
                "§8(Clique para abrir)", new String[] {}, 1, (byte) 0));
        player.getInventory().setItem(1, new ItemBuilder().newHeadSkull("§a§oSeu Perfil " +
                "§8(Clique para abrir)", player.getName(), new String[] {} ));
        player.getInventory().setItem(8, new ItemBuilder().newItem(Material.CHEST, "§a§oColecionáveis " +
                "§8(Clique para abrir)", new String[] {}, 1, (byte) 0));
        player.updateInventory();

        for (int clearchat = 1; clearchat < 100; clearchat++) {
            player.sendMessage("");
        }

        player.sendMessage("§eLoja: §a" + new FavelaMC().getStore());
        player.sendMessage("§eDiscord: §a" + new FavelaMC().getDiscord());
        player.sendMessage("");
        player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
    }
}