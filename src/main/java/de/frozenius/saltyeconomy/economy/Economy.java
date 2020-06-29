package de.frozenius.saltyeconomy.economy;

import org.bukkit.entity.Player;

public class Economy {

    public Economy(){

    }

    public static String getMoney(Player str){
        return Money.getCount(str);
    }

}
