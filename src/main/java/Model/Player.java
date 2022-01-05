package Model;

public class Player {
    private final int startBalance = 30000;
    private int balance;
    private Field playerField;
    private int number;
    private int currentRoll;




    public Player(String name,int Number) {
        balance = startBalance;
    }



    public void setPlayerField(Field field){
        this.playerField = field;
    }
    public Field getPlayerField(){
        return playerField;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void changeBalance(int changeBalance){
        this.balance = balance+changeBalance;
    }
    public int getBalance(){
        return balance;
    }
    public int getPlayerNumber(){return number;}

    public void setCurrentRoll(int currentRoll){this.currentRoll = currentRoll;}
    public int getCurrentRoll(){return currentRoll;}

}
