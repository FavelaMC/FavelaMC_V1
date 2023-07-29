package xyz.favelamc.engine.bungeecord.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import xyz.favelamc.engine.FavelaMC;

import java.util.Random;

public class BungeeCordListener implements Listener {

    @EventHandler
    public void proxyPingEvent(ProxyPingEvent proxyPingEvent) {
        ServerPing serverPing = proxyPingEvent.getResponse();

        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                serverPing.setDescription("               §b§lFAVELA §8» §a" + new FavelaMC().getAddress() + "" +
                        "\n                    §6§lVENHA JOGAR");
                break;
            case 1:
                serverPing.setDescription("       §b§lFAVELA §8» §a" + new FavelaMC().getDiscord() + "" +
                        "\n          §9§lACESSE NOSSO DISCORD");
                break;
            case 2:
                serverPing.setDescription("          §b§lFAVELA §8» §a" + new FavelaMC().getStore() + "" +
                        "\n            §e§lADQUIRA O RANK: §1§lBETA");
                break;
        }
    }
}