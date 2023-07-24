package xyz.favelamc.engine.bukkit.account.ranks;

public enum Rank {

    DONO(100,"Dono"),

    ADMIN(101, "Admin"),
    MODPLUS(102, "Mod+"),
    MOD(103, "Mod"),
    TRIAL(104, "Trial"),
    HELPER(105, "Helper"),

    YOUTUBERPLUS(200, "YT+"),
    YOUTUBER(201, "YT"),
    STREAMER(202, "Streamer"),

    BETA(203, "Beta"),
    GOD(204, "God"),
    VIP(205, "Vip"),

    MEMBRO(300, "Vip");

    private final Integer id;
    private final String name;

    Rank(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static boolean hasRank(String name) {
        for (Rank rank : values()) {
            if (rank.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}