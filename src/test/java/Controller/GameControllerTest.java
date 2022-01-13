
/*

package Controller;

import Model.Board;
import Model.Player;
import View.GameView;
import Model.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;

public class GameControllerTest {
    private GameController gameController;
    @BeforeEach
    public void setUp(){
        Board board = new Board();
        GUI gui = new GUI();
        GameView gameView = new GameView(gui);
        gameController = new GameController(board,gameView);
        for (int i=1;i<=4;i++){
            Player player = new Player("Player "+i,i);
            GUI_Car car = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
            GUI_Player guiPlayer = new GUI_Player("Player " +i,30000,car);
            board.addPlayer(player);
            player.setPlayerField(board.getFields()[0]);
            gui.addPlayer(guiPlayer);
            gameView.getGuiPlayers().add(guiPlayer);
        }
    }
    @AfterEach
    public void tearDown(){
        gameController = null;
    }
    @Test
    void movePlayer(){
        Board board = gameController.board;
        board.setCurrentPlayer(board.getPlayer(1));
        Player currentPlayer = board.getCurrentPlayer();
        gameController.movePlayer(currentPlayer);

        int firstRoll = currentPlayer.getRaffleCup().getDiceSum();
        int playerPosition = currentPlayer.getPlayerField().getPosition();
        int tempPlayerPosition =1;

        System.out.println("I rolled: "+firstRoll+" and I am now at position: "+currentPlayer.getPlayerField().getPosition());
        System.out.println("Die1: " + currentPlayer.getRaffleCup().getDie1Eyes());
        System.out.println("Die2: "+ currentPlayer.getRaffleCup().getDie2Eyes());

        Assertions.assertEquals(tempPlayerPosition+firstRoll,playerPosition,"Dice roll was: "+ firstRoll+" Player " +currentPlayer.getPlayerNumber()+" landed ended at position: "+playerPosition);

        System.out.println("Moving again");
        gameController.movePlayer(currentPlayer);
        int secondRoll = currentPlayer.getRaffleCup().getDiceSum();
        playerPosition = currentPlayer.getPlayerField().getPosition();
        tempPlayerPosition = tempPlayerPosition+firstRoll;

        System.out.println("I rolled again: "+secondRoll+ " and I am now at position: "+currentPlayer.getPlayerField().getPosition());
        System.out.println("Die1: " + currentPlayer.getRaffleCup().getDie1Eyes());
        System.out.println("Die2: "+ currentPlayer.getRaffleCup().getDie2Eyes());

        Assertions.assertEquals(tempPlayerPosition+secondRoll,playerPosition,"Dice roll was: "+ secondRoll+" Player " +currentPlayer.getPlayerNumber()+" landed ended at position: "+playerPosition);
    }
}

 */