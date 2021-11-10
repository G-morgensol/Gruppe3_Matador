package View;

import gui_fields.GUI_Board;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.*;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static gui_fields.GUI_Car.Type.*;

public class GameView {

    final public GUI gui;

    public GameView(@NotNull GUI gui){
        this.gui = gui;
    }


    /**
     * This method takes User input for number of players, and their choice of type and color for their vehicle.
     *
     */
    public void addPlayers(){

        int playerAmount = Integer.parseInt(gui.getUserSelection(
                "Welcome to Matador! Pick number of players!",
                "2", "3","4","5","6"));

        for (int i=1;i<=playerAmount;i++) {

            String playerString = "Player"+ i;
            String carChoice = gui.getUserButtonPressed(
                    "%s, pick a vehicle type".formatted(playerString),
                    "CAR", "RACECAR", "TRACTOR","UFO");

            GUI_Car car = new GUI_Car(Color.red,Color.red, Type.getTypeFromString(carChoice),Pattern.FILL);
            GUI_Player player = new GUI_Player("Player " +i,30000,car);

            String colorChoice = gui.getUserSelection(
                    "%s, pick a color for your car!".formatted(playerString),
                    "blue", "red","orange","white","pink");

            switch (colorChoice) {
                case "blue" -> car.setPrimaryColor(Color.blue);
                case "red" -> car.setPrimaryColor(Color.red);
                case "orange" -> car.setPrimaryColor(Color.orange);
                case "white" -> car.setPrimaryColor(Color.white);
                case "pink" -> car.setPrimaryColor(Color.pink);
            }

            /*
            Code to set playername to userinput. not functional.

            String playerName= gui.getUserString("Vælg et navn!");
            player.setName(playerName);
            player.setBalance(10);
            System.out.println(player.setName(playerName));
*/
            gui.addPlayer(player);


        }
    }




}
