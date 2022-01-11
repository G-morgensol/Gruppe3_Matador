package Model.fields;

import Model.Player;
import Model.fields.Ownable;

public class Shipping extends Ownable {


    public Shipping(String name, int position, int price, int[] rent) {
        super(name, position, price, rent);
    }

    public void fieldAction(Player player) {
        int numberOfShipping = 1;
        Player owner = getOwner();
        if (owner != null) {
            for (int i = 0; i < owner.getProperties().size(); i++) {
                if (owner.getProperties().get(i).position == 6 ||
                        owner.getProperties().get(i).position == 16 ||
                        owner.getProperties().get(i).position == 26 ||
                        owner.getProperties().get(i).position == 36) {
                    numberOfShipping = numberOfShipping+1;
                }
            }
            player.changeBalance(-getRent(numberOfShipping));
            owner.changeBalance(getRent(numberOfShipping));
        } else {
            //Possibility of buying the Shipping
            //In case of buying
            player.setBalance(-getPrice());
            player.addProperty((Ownable) player.getPlayerField());
            //TODO add case of not buying, implement GUI prompt here to do so.
        }
    }
}
