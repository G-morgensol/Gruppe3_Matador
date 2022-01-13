import Controller.GameController;
import Model.Board;
import View.GameView;
import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        Board board = new Board();
        GameController gamecontroller = new GameController(board,gameView);
        gamecontroller.startGame();
        gamecontroller.playerTurn();
    }

}
