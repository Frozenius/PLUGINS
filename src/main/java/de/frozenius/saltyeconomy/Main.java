package de.frozenius.saltyeconomy;

import de.frozenius.saltyeconomy.chat.messages;
import de.frozenius.saltyeconomy.listeners.ChatListener;
import de.frozenius.saltyeconomy.listeners.JoinListener;
import de.frozenius.saltyeconomy.listeners.QuitListener;
import de.frozenius.saltyeconomy.utils.Config;
import de.frozenius.saltyeconomy.utils.Money;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Main extends JavaPlugin implements Listener {

    public static Map<String, ItemStack[]> menus = new HashMap<String, ItemStack[]>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Salty Economy wird hochgefahren...");

        new Config();

        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();


        if(this.getConfig().contains("data"))
            this.restoreInvs();

        listenerRegistration();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Salty Economy wird runtergefahren...");
        if(!menus.isEmpty()){
            this.saveInvs();
        }
    }

    public void saveInvs() {
        for (Map.Entry<String, ItemStack[]> entry : menus.entrySet()){
            this.getConfig().set("data." + entry.getKey(), entry.getValue());
        }
        this.saveConfig();
    }

    public void restoreInvs(){
        this.getConfig().getConfigurationSection("data").getKeys(false).forEach(key ->{
            @SuppressWarnings("unchecked")
            ItemStack[] content = ((List<ItemStack>) this.getConfig().get("data." + key)).toArray(new ItemStack[0]);
            menus.put(key, content);
        });
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(label.equalsIgnoreCase("bp")){
            if(!(sender instanceof Player)){
                sender.sendMessage(messages.errorPrefix() + "Wrong Command Target!");
                return true;
            }
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 27, player.getName() + "'s Private Vault");

            if (menus.containsKey(player.getUniqueId().toString()))
                inv.setContents(menus.get(player.getUniqueId().toString()));

            player.openInventory(inv);
            return true;
        }
        return false;
    }

    @EventHandler
    public void onGUIClose(InventoryCloseEvent event){
        if (event.getView().getTitle().contains(event.getPlayer().getName() + "'s Private Vault"))
            menus.put(event.getPlayer().getUniqueId().toString(), event.getInventory().getContents());
    }
    private void listenerRegistration(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
    }
}
