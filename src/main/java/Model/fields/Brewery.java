package Model.fields;

import Model.Player;
import View.GameView;

public class Brewery extends Ownable {


    public Brewery(String name, int position, int price, int[] rent) {
        super(name, position, price, rent);
    }
    public void fieldAction(Player player,GameView gameView){
        int numberOfBrewery = 0;
        Player owner = getOwner();
        if (owner != null && player!=owner &&!owner.isJailed()){
            for (Ownable property:owner.getProperties()){
                if (property instanceof Brewery){
                    numberOfBrewery = numberOfBrewery+1;
                }
            }
            player.changeBalance(-player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
            owner.changeBalance(player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
            gameView.updatePlayerBalance(owner);
        } else if(owner==null) {
            //Brewery has no owner
            buyProperty(player,gameView);
        }
        gameView.updatePlayerBalance(player);
    }
}

