package xyz.favelamc.engine.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCordMain extends Plugin {

    protected void loadService() {
        try {
            BungeeCordLoader.plugin = this;
            System.out.print("[Engine] -> Inicializando...");
        } catch (Exception exception) {
            System.out.print("[Engine] -> Ocorreu um erro ao tentar inicializar: (" + exception + ")");
        }
    }

    protected void enableService() {
        try {
            System.out.print("[Engine] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Engine] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void disableService() {
        try {
            System.out.print("[Engine] -> Desligando...");
            BungeeCordLoader.plugin = null;
        } catch (Exception exception) {
            System.out.print("[Engine] -> Ocorreu um erro ao desligar: (" + exception + ")");
        }
    }
}