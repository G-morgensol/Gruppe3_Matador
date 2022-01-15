package Model;

import Model.fields.Field;
import View.GameView;

public class RaffleCup {
    private int die1Eyes;
    private int die2Eyes;
    private int diceSum;
    private boolean isPair;

    Die die1 = new Die(1,6);
    Die die2 = new Die(1,6);

    /**
     * Rolls dice and updates die1 and die2.
     * @return Sum of rolled dice.
     */
    public int rollDice() {
        die1Eyes = die1.rollDie();
        die2Eyes = die2.rollDie();
        diceSum = die1Eyes + die2Eyes;


        if (die1Eyes == die2Eyes) {
            isPair = true;
            } else{
            isPair = false;
            }
            return diceSum;

    }

    public void setDiceSum(int diceSum){this.diceSum = diceSum;}
    public int getDie1Eyes(){
        return die1Eyes;
    }
    public int getDie2Eyes(){
        return die2Eyes;
    }
    public int getDiceSum(){
        return diceSum;
    }
    public boolean getIsPair(){
        return isPair;
    }
}
