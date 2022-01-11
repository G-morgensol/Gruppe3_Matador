package Model.fields;

import Model.Player;
import Model.fields.Ownable;

public class Street extends Ownable {
    private int housePrice;
    private String colorGroup;
    private int numberOfHouses;

    public Street(String name, int position, int price, int[] rent, int housePrice, String colorGroup) {
        super(name, position, price, rent);
        this.housePrice = housePrice;
        this.colorGroup = colorGroup;
    }

    public void setHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    public int getHouses() {
        return numberOfHouses;
    }

    private String getColorGroup() {
        return colorGroup;
    }
    //Could use @Overide tag here, if we change getRent() to getRent(int numberOfHouses), then implement it inside fieldAction for prettier code.
    public int getRent() {
            switch (numberOfHouses) {
                case 0:
                    return rent[0];
                case 1:
                    return rent[1];
                case 2:
                    return rent[2];
                case 3:
                    return rent[3];
                case 4:
                    return rent[4];
                case 5:
                    return rent[5];
            }
        return 0;
    }
    public void fieldAction(Player player) {
        Player owner = getOwner();
        String colorGroup = getColorGroup();
        int colorGroupSetMax;
        int currentColorGroupSet = 1;
        Street currentPlayerStreet = (Street) player.getPlayerField();
        if(owner!=null) {
            if (colorGroup.equals("purple") || colorGroup.equals("blue")) {
                colorGroupSetMax = 2;
            } else {
                colorGroupSetMax = 3;
            }
            if (numberOfHouses == 0) {
                for (int i = 0; i < owner.getProperties().size(); i++) {
                    Street ownerStreet = (Street) owner.getProperties().get(i);
                    if (currentPlayerStreet.colorGroup == ownerStreet.getColorGroup()) {
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
                player.changeBalance(-getRent(numberOfHouses));
                owner.changeBalance(getRent(numberOfHouses));
            }
        }
            else {
            //Possibility of buying street
            player.changeBalance(-getPrice());
            player.getProperties().add((Ownable) player.getPlayerField());
        }
    }
}

