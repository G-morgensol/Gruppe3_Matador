package Model;

import Model.fields.Field;
import Model.fields.Ownable;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int startBalance = 30000;
    private int balance;
    private Field playerField;
    private final List<Ownable> properties = new ArrayList<>();
    private boolean isJailed = false;
    private int number;
    private String name;
    private final RaffleCup rafflecup;
    public RaffleCup getRaffleCup() {
        return rafflecup;
    }




    public Player(String name, int number) {
        balance = startBalance;
        this.rafflecup = new RaffleCup();
        this.number = number;
        this.name = name;
    }


    public void setPlayerField(Field field) {
        this.playerField = field;
    }

    public Field getPlayerField() {
        return playerField;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void changeBalance(int changeBalance) {
        this.balance = balance + changeBalance;
    }

    public int getBalance() {
        return balance;
    }

    public int getPlayerNumber() {
        return number;
    }


    public void addProperty(Ownable property) {
        properties.add(property);
    }

    public boolean checkOwnership(Ownable property) {
        for (int i = 0; i < properties.size(); i++) {
            if(property==properties.get(i)){
                return true;
            }
        }
        return false;
    }
    public List<Ownable> getProperties(){return properties;}

    public void setJailed(boolean jailed) {
        isJailed = jailed;
    }

    public boolean isJailed() {
        return isJailed;
    }
    public String getName(){return name;}
}
