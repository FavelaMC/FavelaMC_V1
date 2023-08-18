package xyz.favelamc.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.favelamc.engine.bukkit.commands.BukkitCommand;
import xyz.favelamc.lobby.manager.LobbyManager;

public class RegisterCommand extends BukkitCommand {

    public boolean onCommand(CommandSender commandSender, Command command, String arg, String[] args) {
        if (this.isPlayer(commandSender)) {

            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("register")) {
                if (args.length == 0) {
                    player.sendMessage("§cUtilize: /" + arg + " <senha>");
                } else if (args.length == 1) {
                    if (args[0].length() < 4) {
                        player.sendMessage("§cA senha precisar conter mais de quatro caracters!");
                    } else {
                        player.sendMessage("§aSua conta acaba de ser registrada!");
                        player.sendMessage("§eAbrindo conexão...");
                        LobbyManager.generatePlayer(player);
                    }
                }
            }
        }
        return false;
    }
}