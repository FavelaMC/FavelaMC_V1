package xyz.favelamc.engine.bukkit.commands.register;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.favelamc.engine.bukkit.account.ranks.Rank;
import xyz.favelamc.engine.bukkit.account.ranks.Tag;
import xyz.favelamc.engine.bukkit.commands.BukkitCommand;

public class RankCommand extends BukkitCommand {

    public boolean onCommand(CommandSender commandSender, Command command, String arg, String[] args) {
        if (this.isPlayer(commandSender)) {

            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("rank")) {
                if (args.length == 0) {
                    player.sendMessage("§cUtilize: /" + arg + " <aplicar, listar>");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("aplicar")) {
                        player.sendMessage("§cUtilize: /" + arg + " aplicar <" + arg +"> <player>");
                    } else if (args[0].equalsIgnoreCase("listar")) {
                        TextComponent message = new TextComponent("§a" + (arg.startsWith("r") ? arg.replace("r"
                                , "R") : arg.replace("g", "G")) + "s: ");
                        for (Tag tag : Tag.values()) {
                            if (tag.equals(Tag.MEMBRO))
                                continue;

                            TextComponent component = new TextComponent(tag.getColor() + tag.getName());
                            component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT
                                    , new TextComponent[] { new TextComponent("§f" + (arg.startsWith("r")
                                    ? arg.replace("r", "R") : arg.replace("g", "G")) + "s: "
                                    + tag.getColor() + tag.getName() + "\n" + "§7/" + arg + " <aplicar> <" + tag.getColor()
                                    + tag.getName() + "§7> <nick>")}));
                            message.addExtra(component);
                            message.addExtra(tag.equals(Tag.MEMBRO) ? "§f." : "§f, ");
                        }
                        player.spigot().sendMessage(message);
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("aplicar")) {
                        if (Rank.hasRank(args[1])) {
                            player.sendMessage("§cUtilize: /" + arg + " aplicar " + args[1] +" <player>");
                        }
                    }
                } else if (args.length == 3) {
                    if (args[0].equalsIgnoreCase("aplicar")) {
                        if (Rank.hasRank(args[1])) {
                            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[2]);

                            player.sendMessage("§aVocê alterou o " + arg + " de: " + args[2] + " para: " + args[1]);

                            if (offlinePlayer.isOnline()) {
                                offlinePlayer.getPlayer().sendMessage("§aSeu " + arg + " foi alterado para: " + args[1]);
                            } else {
                                player.sendMessage("§aO " + arg + " de: " + args[2] + " foi alterado, mas o mesmo " +
                                        "estava offline!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}