package Model.fields;

import Model.Player;

public class Start extends Field {

    public Start(String name, int position) {
        super(name, position);
    }
    public void fieldAction(Player player){
            player.changeBalance(4000); //when you pass start get 4000 kr
        }
    }

