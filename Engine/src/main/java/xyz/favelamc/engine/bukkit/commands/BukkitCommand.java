package xyz.favelamc.engine.bukkit.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BukkitCommand implements CommandExecutor {

    /**
     * Esta class ainda está inoperante by Piqque
     */

    public boolean isPlayer(CommandSender commandSender)
    {
        return (commandSender instanceof Player);
    }

    public Player getPlayerFromArgs(String player)
    {
        return Bukkit.getPlayer(player);
    }

    public Player getPlayerFromSender(CommandSender commandSender)
    {
        return (Player) commandSender;
    }
}