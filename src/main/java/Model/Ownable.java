package Model;

public abstract class Ownable extends Field{

    protected Player owner;
    protected int[] rent;
    protected int price;
    public Ownable(String name,int position,int price, int[] rent) {
        super(name,position);
        this.rent = rent;
        this.price = price;

    }

    int getRent(int i){return rent[i];}
    public void setOwner(Player owner){this.owner = owner;
    }
    Player getOwner() {return owner;}
}

