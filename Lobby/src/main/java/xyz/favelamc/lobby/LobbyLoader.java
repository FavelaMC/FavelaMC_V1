package xyz.favelamc.lobby;

import org.bukkit.plugin.Plugin;

public class LobbyLoader extends LobbyMain {

    protected static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onLoad() {
        loadService();
        loadWorld();
    }

    @Override
    public void onEnable() {
        enableService();
        enableListener();
        enableInventorys();
        enableCommands();
    }

    @Override
    public void onDisable() {
        disableService();
    }
}