package Model.fields;

import Model.Player;
import View.GameView;

public class Brewery extends Ownable {


    public Brewery(String name, int position, int price, int[] rent) {
        super(name, position, price, rent);
    }
    public void fieldAction(Player player,GameView gameView){
        int numberOfBrewery = 1;
        Player owner = getOwner();
        if (owner != null){
            for (int i = 0; i <= owner.getProperties().size(); i++){
                if (owner.getProperties().get(i) instanceof Brewery){
                    numberOfBrewery = numberOfBrewery+1;
                }
            }
            player.changeBalance(-player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
            owner.changeBalance(player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
        } else {
            //Brewery has no owner
            buyProperty(player,gameView);
        }
    }
}
