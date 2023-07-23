package xyz.favelamc.engine.bukkit.account;

import java.util.UUID;

public class FavelaPlayer {

    private UUID uuid;

    public FavelaPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}