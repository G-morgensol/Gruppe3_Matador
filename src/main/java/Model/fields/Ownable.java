package Model.fields;

import Model.Player;
import View.GameView;

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
    public void setOwner(Player owner){this.owner = owner;
    }
    protected Player getOwner() {return owner;}
    protected int getPrice(){return price;}

    protected void buyProperty(Player player, GameView gameView){
        String userSelect = gameView.gui.getUserSelection(
                "Do you want to buy "+this.name+"?","Yes","No");
        if (userSelect.equals("Yes")){
            player.changeBalance(-getPrice());
            player.getProperties().add((Ownable) player.getPlayerField());
            owner = player;
            gameView.updateFieldOwner(player,player.getPlayerField().position);
            gameView.updatePlayerBalance(player);
        }
    }
}

