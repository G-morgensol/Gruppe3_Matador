package Model.fields;

import Model.Player;
import View.GameView;

public abstract class Field {
    protected String name;
    protected int position;



    public Field(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public void fieldAction(Player player, GameView gameView){

    }
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

