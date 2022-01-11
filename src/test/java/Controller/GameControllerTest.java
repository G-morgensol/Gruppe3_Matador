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
        int currentRoll = currentPlayer.getRaffleCup().getDiceSum();
        int playerPosition = currentPlayer.getPlayerField().getPosition();
        Assertions.assertEquals(currentRoll,playerPosition,"Dice roll was: "+ currentRoll+" Player " +currentPlayer.getPlayerNumber()+" landed ended at position: "+playerPosition);
    }
}