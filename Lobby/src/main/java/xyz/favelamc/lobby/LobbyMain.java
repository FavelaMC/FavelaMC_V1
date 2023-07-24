package xyz.favelamc.lobby;

import org.bukkit.plugin.java.JavaPlugin;

public class LobbyMain extends JavaPlugin {

    protected void loadService() {
        try {
            LobbyLoader.plugin = this;
            System.out.print("[Lobby] -> Inicializando...");
        } catch (Exception exception) {
            System.out.print("[Lobby] -> Ocorreu um erro ao tentar inicializar: (" + exception + ")");
        }
    }

    protected void enableService() {
        try {
            System.out.print("[Lobby] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Lobby] -> Ocorreu um erro ao inicializar: (" + exception + ")");
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