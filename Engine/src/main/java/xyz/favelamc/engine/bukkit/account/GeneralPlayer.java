package xyz.favelamc.engine.bukkit.account;

import java.util.UUID;

public class GeneralPlayer {

    public static FavelaPlayer getPlayer(UUID uuid) {
        return new FavelaPlayer(uuid);
    }
}