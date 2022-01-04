package Model;

public class Player {
    private final int startBalance = 30000;
    private int balance;
    private Field playerField;
    String name;
    int Number;



    public Player(String name,int Number) {
        balance = startBalance;
        this.name = name;
        this.Number = Number;
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
    public int getPlayerNumber(){return Number;}
}
