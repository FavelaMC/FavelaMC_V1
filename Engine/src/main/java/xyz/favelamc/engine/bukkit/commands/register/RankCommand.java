package xyz.favelamc.engine.bukkit.commands.register;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
                        TextComponent message = new TextComponent("§aGrupos: ");
                        for (Tag tag : Tag.values()) {
                            if (tag.equals(Tag.MEMBRO))
                                continue;

                            TextComponent component = new TextComponent(tag.getColor() + tag.getName());
                            component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT
                                    , new TextComponent[] {new TextComponent("§fRank: " + tag.getColor() + tag.getName()
                                    + "\n" + "§7/rank <aplicar> <nick> <" + tag.getColor() + tag.getName() + "§7>")}));
                            message.addExtra(component);
                            message.addExtra(tag.equals(Tag.MEMBRO) ? "§f." : "§f, ");
                        }
                        player.spigot().sendMessage(message);
                    }
                }
            }
        }
        return false;
    }
}