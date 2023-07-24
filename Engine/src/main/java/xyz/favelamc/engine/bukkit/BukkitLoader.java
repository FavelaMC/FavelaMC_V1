package xyz.favelamc.engine.bukkit;

import org.bukkit.plugin.Plugin;

public class BukkitLoader extends BukkitMain {

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
        enableInventorys();
        enableCommands();
    }

    @Override
    public void onDisable() {
        disableService();
    }
}