package Model.fields;

import Model.Player;
import Model.fields.Ownable;

public class Brewery extends Ownable {


    public Brewery(String name, int position, int price, int[] rent) {
        super(name, position, price, rent);
    }
    public void fieldAction(Player player){

        //TODO write method here
        //In case of 1 brewery owned:
        player.changeBalance(-player.getCurrentRoll()*100);
        getOwner().changeBalance(player.getCurrentRoll()*100);
    }
}
