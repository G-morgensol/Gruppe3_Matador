package Model.fields;

import Model.Player;
import Model.fields.Field;

public abstract class Ownable extends Field {

    protected Player owner;
    protected int[] rent;
    protected int price;
    public Ownable(String name,int position,int price, int[] rent) {
        super(name,position);
        this.rent = rent;
        this.price = price;

    }

    protected int getRent(int i){return rent[i];}
    protected void setOwner(Player owner){this.owner = owner;
    }
    protected Player getOwner() {return owner;}
}

