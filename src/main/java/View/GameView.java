package View;

import gui_fields.GUI_Board;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class GameView {

    final public GUI gui;

    public GameView(@NotNull GUI gui){
        this.gui = gui;
    }

    public String choosePlayerAmount(GUI gui){
        return gui.getUserSelection(
                "Welcome to Matador! Pick number of players!",
                "2", "3","4","5","6");
    }
    public String choosePlayerColor(GUI gui){
        return gui.getUserSelection(
                "Pick a color for your car!",
                "blue", "red","orange","white","pink");
    }

    public void addPlayers(){

        int playerAmount = Integer.parseInt(choosePlayerAmount(gui));

        for (int i=1;i<=playerAmount;i++) {
            GUI_Car car = new GUI_Car();
            GUI_Player player = new GUI_Player("Player " +i,30000,car);
            String color = choosePlayerColor(gui);

            switch (color) {
                case "blue" -> car.setPrimaryColor(Color.blue);
                case "red" -> car.setPrimaryColor(Color.red);
                case "orange" -> car.setPrimaryColor(Color.orange);
                case "white" -> car.setPrimaryColor(Color.white);
                case "pink" -> car.setPrimaryColor(Color.pink);
            }
            gui.addPlayer(player);
        }
    }




}
