package Model.fields;

import Model.Player;
import Model.fields.Field;
import View.GameView;

public class Tax extends Field {
    public Tax(String name, int position) {
        super(name, position);
    }
    public void fieldAction(Player player, GameView gameView){
        if (player.getPlayerField().position==5){
            //Option 1:
            player.changeBalance(-4000);
            //TODO Write option 2: 10% property inside this statement, need GUI handle
        } else if (player.getPlayerField().position==39){
            player.changeBalance(-2000);
        }
    }
}
