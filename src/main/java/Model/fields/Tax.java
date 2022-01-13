package Model.fields;

import Model.Player;
import View.GameView;

public class Tax extends Field {
    public Tax(String name, int position) {
        super(name, position);
    }
    public void fieldAction(Player player, GameView gameView){
        if (player.getPlayerField().position==5){
            String userSelection = gameView.getGui().getUserSelection("You got extra taxes! Pay 4000, or 10% of your property value","4000","10%");
            if (userSelection.equals("4000")) {
                player.changeBalance(-4000);
            } else {
                //Gets the total value of property and changes balance accordingly
                int propertyValue = 0;
                for (Ownable property:player.getProperties()){
                    propertyValue = propertyValue +property.price;
                }
                player.changeBalance(propertyValue);
            }
        } else if (player.getPlayerField().position==39){
            gameView.showText("Pay 2000 in taxes!");
            player.changeBalance(-2000);
        }
    }
}
