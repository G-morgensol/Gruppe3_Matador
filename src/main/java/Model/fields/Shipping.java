package Model.fields;

import Model.Player;
import Model.fields.Ownable;
import View.GameView;

public class Shipping extends Ownable {

    public Shipping(String name, int position, int price, int[] rent) {super(name, position, price, rent);}


    public void fieldAction(Player player, GameView gameView) {
        int numberOfShipping = 1;
        Player owner = getOwner();
        if (owner != null) {
            for (int i = 0; i <= owner.getProperties().size(); i++) {
                if (owner.getProperties().get(i) instanceof Shipping){
                    numberOfShipping = numberOfShipping+1;
                }
            }
            player.changeBalance(-getRent(numberOfShipping));
            owner.changeBalance(getRent(numberOfShipping));
            gameView.updatePlayerBalance(owner,owner.getBalance());
        } else {
            buyProperty(player,gameView);
        }
        gameView.updatePlayerBalance(player,player.getBalance());
    }
}
