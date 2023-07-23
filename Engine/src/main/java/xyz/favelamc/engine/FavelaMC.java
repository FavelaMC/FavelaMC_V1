package xyz.favelamc.engine;

public class FavelaMC {

    private final String name, address, store, discord;

    {
        name = "FavelaMC";

        address = name.toLowerCase() + ".xyz";
        store = "loja." + address;
        discord = "discord." + address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStore() {
        return store;
    }

    public String getDiscord() {
        return discord;
    }
}