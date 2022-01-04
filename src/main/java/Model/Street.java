package Model;

public class Street extends Ownable {
    private int housePrice;

    public Street(String name, int position, int price, int[] rent, int housePrice) {
        super(name, position, price, rent);
        this.housePrice = housePrice;
    }
}

