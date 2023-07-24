package xyz.favelamc.engine.bukkit.account.ranks;

public enum Tag {

    DONO("§4", "§4§lDONO §4"),

    ADMIN("§c", "§c§lADMIN §c"),
    MODPLUS("§5", "§5§lMOD+ §5"),
    MOD("§5", "§5§lMOD §5"),
    TRIAL("§5", "§5§lTRIAL §5"),
    HELPER("§9", "§9§lHELPER §9"),

    YOUTUBERPLUS("§3", "§3§lYT+ §3"),
    YOUTUBER("§b", "§b§lYT §b"),
    STREAMER("§5", "§5§lSTREAMER §5"),

    BETA("§1", "§1§lBETA §1"),
    GOD("§6", "§6§lGOD §6"),
    VIP("§a", "§a§lVIP §a"),

    MEMBRO("§7", "§7* ");

    private String color, preffix;

    Tag(String color, String preffix) {
        this.color = color;
        this.preffix = preffix;
    }

    public String getColor() {
        return color;
    }

    public String getPreffix() {
        return preffix;
    }
}