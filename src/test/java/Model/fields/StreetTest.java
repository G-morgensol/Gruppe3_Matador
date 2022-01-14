package Model.fields;

import Controller.GameController;
import Model.Board;
import Model.Player;
import View.GameView;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class StreetTest{
    private GameController gameController;
    private GameView gameView;
    private Board board;
    private GUI gui;
    @BeforeEach
    public void setUp(){
        board = new Board();
        gui = new GUI();
        gameView = new GameView(gui);
        gameController = new GameController(board,gameView);
        for (int i=1;i<=4;i++){
            Player player = new Player("Player "+i,i);
            GUI_Car car = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
            GUI_Player guiPlayer = new GUI_Player("Player " +i,30000,car);
            board.addPlayer(player);
            player.setPlayerField(Board.getFields()[0]);
            gui.addPlayer(guiPlayer);
            gameView.getGuiPlayers().add(guiPlayer);
        }
    }
    @AfterEach
    public void tearDown(){
        gameController = null;
    }

    @Test
    public void fieldAction(){
        Player currentPlayer = board.getPlayer(1);
        currentPlayer.setPlayerField(Board.getFields()[1]);
        currentPlayer.getPlayerField().fieldAction(currentPlayer,gameView);


        //Checks of Player1 paid 1200 for Rødovrevej
        Assertions.assertEquals(28800,currentPlayer.getBalance(),"Balance not as expected");

        Street playerStreet = (Street) currentPlayer.getPlayerField();
        //Checks if the owner of the property is named Player 1
        Assertions.assertEquals("Player 1",playerStreet.getOwner().getName());

        Player player2 = board.getPlayers().get(2);
        player2.setPlayerField(Board.getFields()[1]);
        player2.getPlayerField().fieldAction(player2,gameView);

        //Checks if Player 2 paid the 50 from landing on Player 1's property.
        Assertions.assertEquals(29950,player2.getBalance());
    }
}