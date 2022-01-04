package Controller;


import Model.*;
import View.GameView;

public class GameController {
    final public Board board;
    final public GameView gameView;
    public RaffleCup rafflecup = new RaffleCup();

    public GameController(Board board, GameView gameView) {
        this.board = board;
        this.gameView = gameView;
    }


    public void startGame(){
    int totalPlayers = gameView.addPlayers();
    for (int i=1;i<=totalPlayers;i++){
        Player player = new Player("Player "+i,i);
        board.addPlayer(player);
    }


    }

    public void playerTurn(){
        for (int i =0;i<board.getTotalPlayers();i++){
            movePlayer(board.getPlayer(i));

            //Where did the player land?


        }


    }
    public void movePlayer(Player player){
        gameView.showText("Slå med terningen");
        int playerNumber = player.getPlayerNumber();
        int currentRoll = rafflecup.rollDice();
        gameView.showDice(rafflecup.getDie1Eyes(),rafflecup.getDie2Eyes());
        gameView.setPlayerField(playerNumber,(gameView.getPlayerField(playerNumber)+currentRoll)%40);
    }
}
