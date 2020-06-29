package de.frozenius.saltyeconomy.listeners;

import de.frozenius.saltyeconomy.chat.messages;
import de.frozenius.saltyeconomy.commands.MoneyCommand;
import de.frozenius.saltyeconomy.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(messages.pluginPrefix() + ChatColor.GOLD + "Aktueller Kontostand: " + Economy.getMoney(player.getPlayer()) + "$");
        player.sendMessage(messages.errorPrefix() + ChatColor.GOLD + "PLUGIN WIP!");
    }

}
