package Model.fields;

import Model.Player;
import Model.fields.Ownable;
import View.GameView;

public class Street extends Ownable {
    private int housePrice;
    private String colorGroup;
    private int numberOfHouses;

    public Street(String name, int position, int price, int[] rent, int housePrice, String colorGroup) {
        super(name, position, price, rent);
        this.housePrice = housePrice;
        this.colorGroup = colorGroup;
    }

    public int getHouses() {
        return numberOfHouses;
    }

    public void setHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    private String getColorGroup() {
        return colorGroup;
    }
    public void fieldAction(Player player, GameView gameView) {
        Player owner = getOwner();
        String colorGroup = getColorGroup();
        int colorGroupSetMax;
        int currentColorGroupSet = 0;
        if(owner!=null && player!=owner) {
            //short form if statement https://stackoverflow.com/questions/8898590/short-form-for-java-if-statement
            colorGroupSetMax = colorGroup.equals("purple") || colorGroup.equals("blue") ? 2 : 3;
            if (numberOfHouses == 0) {
                //Based on: https://stackoverflow.com/questions/4862960/explicit-casting-from-super-class-to-subclass
                for (Ownable property:owner.getProperties()){
                    if(property instanceof Street streetProperty &&
                            this.colorGroup.equals(streetProperty.getColorGroup()) ) {
                        currentColorGroupSet = currentColorGroupSet + 1;
                    }
                }
                if (currentColorGroupSet == colorGroupSetMax) {
                    //Rent is doubled if full colorSet is owned.
                    player.changeBalance(-(getRent(0) * 2));
                    owner.changeBalance(getRent(0) * 2);
                } else {
                    player.changeBalance(-getRent(0));
                    owner.changeBalance(getRent(0));
                }
            } else {
                //numberOfHouses > 0
                player.changeBalance(-getRent(numberOfHouses));
                owner.changeBalance(getRent(numberOfHouses));
            }
        }
        else {
            //Possibility of buying street
            // EVENT
            // WAit for event
            //if true do below else nothing
            player.changeBalance(-getPrice());
            player.getProperties().add((Ownable) player.getPlayerField());
            //TODO add case of not buying, implement GUI prompt here to do so.
        }
    }
}

