package Controller;


import Model.*;
import View.GameView;

public class GameController {
    final public Board board;
    final public GameView gameView;

    public GameController(Board board, GameView gameView) {
        this.board = board;
        this.gameView = gameView;
    }


    public void startGame(){
        int totalPlayers = gameView.addPlayers();
        System.out.println("total players from gui:"+ totalPlayers);
        for (int i=1;i<=totalPlayers;i++){
            Player player = new Player("Player "+i,i);
            player.setPlayerField(board.getFields()[0]);
            board.addPlayer(player);
        }
    }
    public void playerTurn(){
        System.out.println("total players from backend: "+board.getTotalPlayers());
        for (int i =1;i<=board.getTotalPlayers();i++){
            board.setCurrentPlayer(board.getPlayer(i));
            Player currentPlayer =board.getCurrentPlayer();
            //TODO add additional steps to playerTurn()
            movePlayer(currentPlayer);
        }
    }
    public void movePlayer(Player player){
        gameView.showText("Throw dice");
        player.getRaffleCup().rollDice();
        int currentRoll = player.getRaffleCup().getDiceSum();
        int die1 = player.getRaffleCup().getDie1Eyes();
        int die2 = player.getRaffleCup().getDie2Eyes();
        int newPosition = (player.getPlayerField().getPosition()+currentRoll)%40;
        player.setPlayerField(board.getFields()[newPosition-1]);
        gameView.showDice(die1,die2);
        gameView.setGUIPlayerField(player,(newPosition-1));
    }
}
