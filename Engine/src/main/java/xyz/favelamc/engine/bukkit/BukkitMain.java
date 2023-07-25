package xyz.favelamc.engine.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.favelamc.engine.bukkit.commands.register.AccountCommand;
import xyz.favelamc.engine.bukkit.commands.register.RankCommand;
import xyz.favelamc.engine.bukkit.inventorys.AccountInventory;

public class BukkitMain extends JavaPlugin {

    protected void loadService() {
        try {
            BukkitLoader.plugin = this;
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

    protected void enableInventorys() {
        try {
            PluginManager pluginManager = Bukkit.getPluginManager();
            pluginManager.registerEvents(new AccountInventory(), this);

            System.out.print("[Inventorys] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Inventorys] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void enableCommands() {
        try {
            getCommand("account").setExecutor(new AccountCommand());
            getCommand("rank").setExecutor(new RankCommand());
            System.out.print("[Commands] -> Iniciado!");
        } catch (Exception exception) {
            System.out.print("[Commands] -> Ocorreu um erro ao inicializar: (" + exception + ")");
        }
    }

    protected void disableService() {
        try {
            System.out.print("[Engine] -> Desligando...");
            BukkitLoader.plugin = null;
        } catch (Exception exception) {
            System.out.print("[Engine] -> Ocorreu um erro ao desligar: (" + exception + ")");
        }
    }
}