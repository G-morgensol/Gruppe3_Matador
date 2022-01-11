package Model.fields;

import Model.Player;
import Model.fields.Field;
import View.GameView;

public class Parking extends Field {
    public Parking(String name, int position) {
        super(name, position);
    }
    public void fieldAction(Player player, GameView gameView){
        //TODO write method here

        //Some GUI message like: "You are taking a break at the free parking spot!"
    }
}
