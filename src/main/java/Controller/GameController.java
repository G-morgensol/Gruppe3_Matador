package Controller;


import Model.*;
import Model.fields.Ownable;
import Model.fields.Street;
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
            if(currentPlayer.isJailed()){
                jailTurn(currentPlayer);
            } else{
                gameView.updateCenterFieldListOfProperties(currentPlayer);
                movePlayer(currentPlayer);
                currentPlayer.getPlayerField().fieldAction(currentPlayer,gameView);
                isPlayerBankrupt(currentPlayer);
            }
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
        gameView.showText(player.getName()+" throw your dice");
        player.getRaffleCup().rollDice();
        int currentRoll = player.getRaffleCup().getDiceSum();
        int die1 = player.getRaffleCup().getDie1Eyes();
        int die2 = player.getRaffleCup().getDie2Eyes();
        int oldPosition = player.getPlayerField().getPosition();
        int newPosition = (oldPosition+currentRoll-1)%40;
        player.setPlayerField(Board.getFields()[newPosition]);
        gameView.showDice(die1,die2);
        if(oldPosition>newPosition){
            player.changeBalance(4000);
            gameView.showText("You pass start, you get 4000 from the bank!");
            gameView.updatePlayerBalance(player);
        }
        gameView.setGUIPlayerField(player,(newPosition));
    }
    public void isPlayerBankrupt(Player player){
        if(player.getBalance()<0){
            for(Ownable property:player.getProperties()){
                property.setOwner(null);
                gameView.updateFieldOwner(null,property.getPosition());
                if(property instanceof Street streetProperty){
                    streetProperty.setHouses(0);
                }
            }
            gameView.getGuiPlayers().get(board.getPlayers().indexOf(player)).getCar().setPosition(null);
            gameView.getGuiPlayers().get(board.getPlayers().indexOf(player)).setBalance(0);
            board.removePlayer(player);


        }
    }
    public void jailTurn(Player player){
        if(!player.getJailCard()){
            String userSelection = gameView.getGui().getUserSelection("You are in jail, you have 2 options:","Pay 1000","Roll a pair");
            switch(userSelection){
                case "Pay 1000":
                    player.setJailed(false);
                    player.setBalance(-1000);
                    gameView.updatePlayerBalance(player);
                    break;
                case "Roll a pair":
                    player.getRaffleCup().rollDice();
                    if(player.getRaffleCup().getIsPair()){
                        player.setJailed(false);
                    }
                    break;
            }
        } else {
            //player has a get out of jail card
            gameView.showText("You use your get out of Jail card. How lucky for you!");
            player.setJailCard(false);
            player.setJailed(false);
        }
    }
}
