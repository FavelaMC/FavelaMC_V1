package xyz.favelamc.engine.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCordLoader extends BungeeCordMain {

    protected static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onLoad() {
        loadService();
    }

    @Override
    public void onEnable() {
        enableService();
        enableListener();
    }

    @Override
    public void onDisable() {
        disableService();
    }
}