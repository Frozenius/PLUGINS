package de.frozenius.saltyeconomy.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if(player.getDisplayName().equals("Frozenius")){
            event.setFormat(ChatColor.AQUA + "[%1$s]" + ChatColor.DARK_GRAY + " >> " + ChatColor.YELLOW + "%2$s");
        } else {
            event.setFormat(ChatColor.GREEN + "[%1$s]" + ChatColor.DARK_GRAY + " >> " + ChatColor.YELLOW + "%2$s");
        }

        event.setMessage((player.isOp() ? ChatColor.translateAlternateColorCodes('&', event.getMessage()) : event.getMessage()));
    }
}


