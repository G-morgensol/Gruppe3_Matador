package View;

import Model.Player;
import gui_fields.*;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameView {
    public final GUI gui;

    public List<GUI_Player> getGuiPlayers() {
        return guiPlayers;
    }

    private final List<GUI_Player> guiPlayers= new ArrayList<>();

    public GameView(GUI gui) {
        this.gui = gui;
    }

    public GUI getGui() {
        return gui;
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
            GUI_Player guiPlayer = new GUI_Player("Player " +i,30000,car);

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
            gui.addPlayer(guiPlayer);
            guiPlayers.add(guiPlayer);
            guiPlayer.getCar().setPosition(gui.getFields()[0]);
            totalPlayers = i;
        }
        return totalPlayers;
    }
    public void showDice(int die1,int die2){
        gui.setDice(die1,die2);
    }

    public void setGUIPlayerField(Player player, int fieldPosition){
        System.out.println("Setting GUIPlayer"+player.getPlayerNumber()+" to position: "+ fieldPosition);
        GUI_Player guiPlayer = guiPlayers.get(player.getPlayerNumber()-1);
        guiPlayer.getCar().setPosition(gui.getFields()[fieldPosition]);
    }
    public void showText(String text){
        gui.showMessage(text);
    }
}
