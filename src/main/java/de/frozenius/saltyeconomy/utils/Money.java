package de.frozenius.saltyeconomy.utils;

public class Money {
    private int money;

    public Money(int money){
        this.money = money;
    }

    public Money() {

    }

    public void setMoney(int value){
        this.money = value;
    }

    public int getMoney() {
        return this.money;
    }

    public void addMoney(int value){
        this.money += value;
    }

    public boolean removeMoney(int value){
        if (this.money < value)
            return false;
        if (this.money > value){
            this.money -= value;
            return true;
        }
        return false;
    }
}
