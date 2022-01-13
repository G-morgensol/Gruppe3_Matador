package Model.fields;

import Model.Player;
import View.GameView;

public class Jail extends Field {

    public Jail(String name, int position) {
        super(name, position);
    }

    public void fieldAction(Player player, GameView gameView){gameView.showText("You are visiting the local jail");
        player.setJailCard(true);
    }
}
