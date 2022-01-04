package View;

import Model.Player;
import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Board;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameView {

    final public GUI gui;
    private final List<GUI_Player> guiPlayers= new ArrayList<>();

    public GameView( GUI gui){
        this.gui = gui;
    }



    /**
     * This method takes User input for number of players, and their choice of type and color for their vehicle.
     * @return total players added are returned.
     */
    public int addPlayers(){

        int totalPlayers = 0;
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
            Code to set playername to user input. not functional.

            String playerName= gui.getUserString("Type your name!");
            player.setName(playerName);
            player.setBalance(10);
            System.out.println(player.setName(playerName));
*/
            gui.addPlayer(player);
            guiPlayers.add(player);
            player.getCar().setPosition(gui.getFields()[0]);
            totalPlayers = i;
        }
        return totalPlayers;
    }
    public void showDice(int die1,int die2){
        gui.setDice(die1,die2);
    }



    public void setPlayerField(int playerNumber, int fieldNumber){
        GUI_Player player = guiPlayers.get(playerNumber-1);
        player.getCar().setPosition(gui.getFields()[fieldNumber]);
    }
    public int getPlayerField(int playerNumber){
        GUI_Player player = guiPlayers.get(playerNumber-1);
        for (int i =0;i<40;i++){
            if (player.getCar().getPosition()==gui.getFields()[i]) {
                return i;
            }
        }
        return 0;
    }
    public void showText(String text){
        gui.showMessage(text);
    }







}
