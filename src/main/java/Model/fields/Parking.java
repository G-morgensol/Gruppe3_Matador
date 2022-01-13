package Model.fields;

import Model.Player;
import View.GameView;

public class Parking extends Field {
    public Parking(String name, int position) {
        super(name, position);
    }
    public void fieldAction(Player player, GameView gameView){
        gameView.showText("You are taking a break at a free parking spot!");
    }
}
