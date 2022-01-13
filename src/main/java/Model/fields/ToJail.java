package Model.fields;

import Model.Player;
import View.GameView;

public class ToJail extends Field {

    Field jail;
    public ToJail(String name, int position,Field jail) {
        super(name, position);
        this.jail = jail;

    }

    public void fieldAction(Player player, GameView gameView){
        player.setPlayerField(jail);
        player.setJailed(true);
        gameView.getGui().showMessage("You got jailed, sucks to be you");
    }
}
