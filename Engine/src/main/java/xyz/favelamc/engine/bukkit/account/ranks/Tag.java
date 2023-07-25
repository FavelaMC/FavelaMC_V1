package xyz.favelamc.engine.bukkit.account.ranks;

public enum Tag {

    DONO("§4", "Dono", "§4§lDONO §4"),

    ADMIN("§c", "Admin" ,"§c§lADMIN §c"),
    MODPLUS("§5", "Mod+" ,"§5§lMOD+ §5"),
    MOD("§5", "Mod", "§5§lMOD §5"),
    TRIAL("§5", "Trial", "§5§lTRIAL §5"),
    HELPER("§9", "Helper", "§9§lHELPER §9"),

    YOUTUBERPLUS("§3", "YT+", "§3§lYT+ §3"),
    YOUTUBER("§b", "YT", "§b§lYT §b"),
    STREAMER("§5", "Streamer", "§5§lSTREAMER §5"),

    BETA("§1", "Beta", "§1§lBETA §1"),
    GOD("§6","God", "§6§lGOD §6"),
    VIP("§a","Vip", "§a§lVIP §a"),

    MEMBRO("§7","Membro", "§7* ");

    private final String color, name, preffix;

    Tag(String color, String name, String preffix) {
        this.color = color;
        this.name = name;
        this.preffix = preffix;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getPreffix() {
        return preffix;
    }
}