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
        //TODO write method here
    }
}

