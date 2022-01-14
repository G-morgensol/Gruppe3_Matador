package Model.fields;

import Model.Player;
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
        //There is an owner of this street, and the owner is not the player visiting the field.
        if(owner!=null && player!=owner) {
            int rentPaid = 0;
            //short form if statement https://stackoverflow.com/questions/8898590/short-form-for-java-if-statement
            colorGroupSetMax = colorGroup.equals("purple") || colorGroup.equals("blue") ? 2 : 3;
            if (numberOfHouses == 0) {
                //Based on: https://stackoverflow.com/questions/4862960/explicit-casting-from-super-class-to-subclass
                for (Ownable property:owner.getProperties()){
                    //Checks for every property the player has, if that property is a street, and has the matching colorGroup.
                    if(property instanceof Street streetProperty &&
                            this.colorGroup.equals(streetProperty.getColorGroup()) ) {
                        currentColorGroupSet = currentColorGroupSet + 1;
                    }
                }
                if (currentColorGroupSet == colorGroupSetMax) {
                    //Rent is doubled if full colorSet is owned.
                    player.changeBalance(-(getRent(0) * 2));
                    owner.changeBalance(getRent(0) * 2);
                    rentPaid = getRent(0)*2;
                } else {
                    player.changeBalance(-getRent(0));
                    owner.changeBalance(getRent(0));
                    rentPaid = getRent(0);
                }
            } else {
                //numberOfHouses > 0
                player.changeBalance(-getRent(numberOfHouses));
                owner.changeBalance(getRent(numberOfHouses));
                rentPaid = getRent(numberOfHouses);
            }
            //inside (owner!=null)
            gameView.updatePlayerBalance(owner,owner.getBalance());
            gameView.gui.showMessage("You paid: "+rentPaid+" to "+owner.getName());
        }
        else {
            buyProperty(player,gameView);
        }
        gameView.updatePlayerBalance(player,player.getBalance());
    }

}

