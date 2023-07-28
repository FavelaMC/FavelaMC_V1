package xyz.favelamc.engine.bukkit.scoreboard;

import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.favelamc.engine.bukkit.account.ranks.Tag;
import xyz.favelamc.engine.bukkit.packet.ReflectionUtils;

import java.util.Collection;

public class Teams {

    private final Scoreboard scoreboard = new Scoreboard();

    public ScoreboardTeam getOrCreateNewTeam(String name) {
        final ScoreboardTeam team = scoreboard.getTeam(name);
        return team != null
                ? team
                : scoreboard.createTeam(name);
    }

    public void updateNmsPlayerTag(Player player) {
        for (Tag tag : Tag.values()) {
            String preffix = tag.getPreffix();
            String name = player.getName();

            name = name.length() > 15 ? name.substring(0, 15) : name;

            final ScoreboardTeam scoreboardTeam = getOrCreateNewTeam(String.format("%s%s",
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", name));

            scoreboardTeam.setPrefix(getSafetyName(preffix));

            final Collection<String> playerNameSet = scoreboardTeam.getPlayerNameSet();
            if (!playerNameSet.contains(player.getName())) {
                playerNameSet.add(player.getName());
            }

            for (Player players : Bukkit.getOnlinePlayers()) {
                ReflectionUtils.sendPacketSync(players, new PacketPlayOutScoreboardTeam(scoreboardTeam, 1),
                        new PacketPlayOutScoreboardTeam(scoreboardTeam, 0));
            }
        }
    }

    public String getSafetyName(String name) {
        return name.length() > 16
                ? name.substring(0, 16)
                : name;
    }
}