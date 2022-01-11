package Model.fields;

import Model.Player;
import Model.fields.Ownable;

public class Brewery extends Ownable {


    public Brewery(String name, int position, int price, int[] rent) {
        super(name, position, price, rent);
    }
    public void fieldAction(Player player){
        int numberOfBrewery = 1;
        Player owner = getOwner();
        if (owner != null){
            for (int i = 0; i < owner.getProperties().size(); i++){
                if (owner.getProperties().get(i).position == 13 || owner.getProperties().get(i).position == 29){
                    numberOfBrewery = numberOfBrewery+1;
                }
            }
            player.changeBalance(-player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
            owner.changeBalance(player.getRaffleCup().getDiceSum()*100*numberOfBrewery);
        }
    }
}
