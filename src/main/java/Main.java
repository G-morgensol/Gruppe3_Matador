import Model.*;
import Model.RaffleCup;

public class Main {
    public static void main(String[] args) {
        RaffleCup rafflecup = new RaffleCup();
        System.out.println("Result of roll: "+rafflecup.rollDice());
        System.out.println("Using getDie for die1 and die2: "+ rafflecup.getDie1Eyes()+" and "+ rafflecup.getDie2Eyes());
        System.out.println("Verifying result of rollDice(): "+ rafflecup.getDiceSum());
        System.out.println("Was it a pair? " + rafflecup.getIsPair());

        Player player = new Player();
        player.changeBalance(-100);
        System.out.println("Balance of player: " + player.getBalance());
    }

}
