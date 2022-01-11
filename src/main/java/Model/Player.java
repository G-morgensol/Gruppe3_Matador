package Model;

import Model.fields.Field;
import Model.fields.Ownable;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int startBalance = 30000;
    private int balance;
    private Field playerField;
    private int number;
    private int currentRoll;
    private final List<Ownable> properties = new ArrayList<>();


    public Player(String name, int number) {
        balance = startBalance;
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

    public void setCurrentRoll(int currentRoll) {
        this.currentRoll = currentRoll;
    }

    public int getCurrentRoll() {
        return currentRoll;
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
}
