package xyz.favelamc.lobby.manager.auth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.favelamc.lobby.LobbyLoader;
import java.util.ArrayList;
import java.util.UUID;

public class LoginManager {

    public static ArrayList<UUID> captcha;

    static {
        LoginManager.captcha = new ArrayList<>();
    }

    public static boolean inCaptcha(UUID uuid) {
        return LoginManager.captcha.contains(uuid);
    }

    public static void addCaptcha(UUID uuid) {
        LoginManager.captcha.add(uuid);
    }

    public static void removeCaptcha(UUID uuid) {
        LoginManager.captcha.remove(uuid);
    }

    public static void startCounting(Player player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LobbyLoader.getPlugin(), () -> {
            if (player.isOnline() && LoginManager.inCaptcha(player.getUniqueId())) {
                player.kickPlayer("§cVocê não conseguiu acertar o captcha a tempo :(");
            }
        }, 600);
    }
}