package Model;

public class Player {
    private final int startBalance = 30000;
    private int balance;
    private Space playerSpace;


    public Player() {

        balance = startBalance;
    }



    public void setPlayerSpace(Space space){
        this.playerSpace = space;
    }
    public Space getSpace(){
        return playerSpace;
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
}
