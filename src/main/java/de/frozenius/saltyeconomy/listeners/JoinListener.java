package de.frozenius.saltyeconomy.listeners;

import de.frozenius.saltyeconomy.chat.messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.YELLOW + player.getDisplayName());
        player.sendMessage(messages.errorPrefix() + ChatColor.GOLD + "PLUGIN WIP!");
    }

}
