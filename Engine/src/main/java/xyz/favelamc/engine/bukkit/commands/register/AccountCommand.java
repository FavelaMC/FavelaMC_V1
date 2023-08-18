package xyz.favelamc.engine.bukkit.commands.register;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.favelamc.engine.bukkit.commands.BukkitCommand;

public class AccountCommand extends BukkitCommand {

    public boolean onCommand(CommandSender commandSender, Command command, String arg, String[] args) {
        if (this.isPlayer(commandSender)) {

            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("account")) {
                if (args.length == 0) {
                    player.sendMessage("§eInformações de sua conta!");
                    player.sendMessage("");
                    player.sendMessage("§fRank: §c???");
                    player.sendMessage("§fNick: §e" + player.getName());
                    player.sendMessage("");
                    player.sendMessage("§fUniqueId: §e" + player.getUniqueId());
                    player.sendMessage("§7(Deseja vincular sua conta ao §9Discord§8?");
                    player.sendMessage("§7Será necessário obter esse código!)");
                }
            }
        }
        return false;
    }
}