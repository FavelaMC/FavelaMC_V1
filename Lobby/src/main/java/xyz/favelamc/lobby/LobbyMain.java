package xyz.favelamc.lobby;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.favelamc.lobby.commands.RegisterCommand;
import xyz.favelamc.lobby.inventorys.CaptchaInventory;
import xyz.favelamc.lobby.inventorys.CollectionsInventory;
import xyz.favelamc.lobby.inventorys.ServerInventory;
import xyz.favelamc.lobby.listeners.LobbyListener;

public class LobbyMain extends JavaPlugin {

    protected void loadService() {
        try {
            LobbyLoader.plugin = this;
            System.out.print("[Lobby] -> Inicializando...");
        } catch (Exception exception) {
            System.out.print("[Lobby] -> Ocorreu um erro ao tentar inicializar: (" + exception + ")");
        }
    }

    protected void loadWorld() {
        try {
            Bukkit.createWorld(WorldCreator.name("lobby"));
            System.out.print("[World] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[World] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void enableService() {
        try {
            System.out.print("[Lobby] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Lobby] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void enableListener() {
        try {
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(new LobbyListener(), this);

            System.out.print("[Listener] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Listener] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void enableInventorys() {
        try {
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(new CaptchaInventory(), this);
            pluginManager.registerEvents(new CollectionsInventory(), this);
            pluginManager.registerEvents(new ServerInventory(), this);

            System.out.print("[Inventorys] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Inventorys] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void enableCommands() {
        try {
            getCommand("register").setExecutor(new RegisterCommand());
            System.out.print("[Commands] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Commands] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void disableService() {
        try {
            System.out.print("[Lobby] -> Desligando...");
            LobbyLoader.plugin = null;
        } catch (Exception exception) {
            System.out.print("[Lobby] -> Ocorreu um erro ao desligar: (" + exception + ")");
        }
    }
}