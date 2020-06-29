package de.frozenius.saltyeconomy;

import de.frozenius.saltyeconomy.commands.MoneyCommand;
import de.frozenius.saltyeconomy.listeners.JoinListener;
import de.frozenius.saltyeconomy.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().fine("Salty Economy wird hochgefahren...");

        listenerRegistration();
        commandRegistration();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Salty Economy wird runtergefahren...");
    }

    private void listenerRegistration(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
    }

    private void commandRegistration(){
        getCommand("money").setExecutor(new MoneyCommand());
    }
}
