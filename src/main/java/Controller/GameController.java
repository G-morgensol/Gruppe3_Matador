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
        turnLoop();
    }
    public void playerTurn(){
        System.out.println("total players from backend: "+board.getPlayers().size());
        for (int i =1;i<=board.getPlayers().size();i++){
            board.setCurrentPlayer(board.getPlayer(i));
            Player currentPlayer =board.getCurrentPlayer();
            //TODO add additional steps to playerTurn()
            gameView.updateCenterFieldListOfProperties(currentPlayer);
            movePlayer(currentPlayer);
            currentPlayer.getPlayerField().fieldAction(currentPlayer,gameView);
            isPlayerBankrupt(currentPlayer);
        }
    }
    public void turnLoop(){
        while(board.getPlayers().size() != 1){
            playerTurn();
        }
        gameView.gui.showMessage("Game is over! "+board.getPlayer(1).getName()+" won the game");
        gameView.gui.close();
    }
    public void movePlayer(Player player){
        gameView.showText("Throw dice");
        player.getRaffleCup().rollDice();
        int currentRoll = player.getRaffleCup().getDiceSum();
        int die1 = player.getRaffleCup().getDie1Eyes();
        int die2 = player.getRaffleCup().getDie2Eyes();
        int newPosition = (player.getPlayerField().getPosition()+currentRoll)%40;
        if(newPosition==0){
            newPosition=40;
        }
        player.setPlayerField(board.getFields()[newPosition-1]);
        gameView.showDice(die1,die2);
        gameView.setGUIPlayerField(player,(newPosition-1));
    }
    public void isPlayerBankrupt(Player player){
        if(player.getBalance()<0){
            board.removePlayer(player);
            gameView.getGuiPlayers().get(player.getPlayerNumber()-1).getCar().setPosition(null);
            gameView.getGuiPlayers().get(player.getPlayerNumber()-1).setName("Out of game");
            gameView.getGuiPlayers().get(player.getPlayerNumber()-1).setBalance(0);
        }
    }
}
