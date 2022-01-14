package Model.fields;

import Controller.GameController;
import Model.Player;
import View.GameView;

import static Model.Board.getFields;

public class Chance extends Field {
    public Chance(String name, int position) {
        super(name, position);
    }
    int ran;
    public void fieldAction(Player player, GameView gameView){
        //TODO write method here
        ran = (int) (Math.random() * 18);
        switch(ran) {
            case 0:
                fullStop(player, gameView);
                //De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde
                break;
            case 1:
                carWash(player,gameView);
                //Betal for vognvask og smøring kr 300
                break;

            case 2:
                beer(player,gameView);
                //Betal kr 200 for levering af 2 kasser øl
                break;

            case 3:
                carCrash(player, gameView);
                //Betal 3000 for reparation af deres vogn
                break;

            case 4:
                carTires(player,gameView);
                //De har købt 4 nye dæk til Deres vogn, betal kr 1000
                break;

            case 5:
                parkingTicket(player,gameView);
                //De har fået en parkeringsbøde, betal kr 200 i bøde
                break;

            case 6:
                dentistBill(player,gameView);
                //Tandlægeregning, betal kr 2000
                break;

            case 7:
                euroJackport(player,gameView);
                //De har vundet i klasselotteriet. Modtag 500 kr.
                break;

            case 8:
                bitcon(player,gameView);
                //De modtager Deres aktieudbytte. Modtag kr 1000 af banken
                break;

            case 9:
                tax(player,gameView);
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr
                break;

            case 10:
                casino(player,gameView);
                //De have en række med elleve rigtige i tipning, modtag kl 1000
                break;

            case 11:
                salary(player,gameView);
                //Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000
                break;

            case 12:
                moveToStart(player,gameView);
                //Ryk frem til START
                break;

            case 13:
                moveThree(player, gameView);
                //Ryk tre felter frem
                break;

            case 14:
                moveThreeBack(player,gameView);
                //Ryk tre felter tilbage
                break;

            case 15:
                moveToFrederiksberg(player, gameView);
                //Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr
                break;

            case 16:
                moveToGrønningen(player,gameView);
                //Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000
                break;


            case 17:
                jailFreeCard(player, gameView);
                //I anledning af dronningens fødselsdag benådes De herved for fængsel. Dette kort kan
                //opbevares indtil De får brug for det
                break;

            default:
                break;

        }
    }

    private void moveToGrønningen(Player player, GameView gameView) {
        player.setPlayerField(getFields()[(24)%40]);
        gameView.setGUIPlayerField(player,(24)%40);
        gameView.gui.showMessage("Chance Card: you moved to Grønningen");
        player.getPlayerField().fieldAction(player,gameView);
        gameView.updatePlayerBalance(player,player.getBalance());
    }

    private void moveThreeBack(Player player, GameView gameView) {
        int newPosition = (player.getPlayerField().getPosition()-3);
        //player.setPlayerField(newPosition);
        player.setPlayerField(getFields()[(newPosition-1)%40]);
        gameView.setGUIPlayerField(player,(newPosition-1)%40);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: Move 3 spaces backward");

        player.getPlayerField().fieldAction(player,gameView);

    }

    private void moveToStart(Player player, GameView gameView) {
        player.setPlayerField(getFields()[(0)%40]);
        gameView.setGUIPlayerField(player,(0)%40);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you moved to Start ");
        player.getPlayerField().fieldAction(player,gameView);

    }

    private void salary(Player player, GameView gameView) {
        player.changeBalance(+1000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You got a rise, you received 1000");
    }

    private void casino(Player player, GameView gameView) {
        player.changeBalance(+1000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you got lucky at the casino and won 1000");
    }

    private void tax(Player player, GameView gameView) {
        player.changeBalance(+3000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card:Tax returned 3000, something feels off");
    }

    private void bitcon(Player player, GameView gameView) {
        player.changeBalance(+1000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you sold some of your bitcon, you got 1000");
    }

    private void euroJackport(Player player, GameView gameView) {
        player.changeBalance(+500);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you won EUROJACKPORT, just 8th place you won 500");
    }

    private void dentistBill(Player player, GameView gameView) {
        player.changeBalance(-2000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you payed a vist to the dentist, you payed 2000");
    }

    private void parkingTicket(Player player, GameView gameView) {
        player.changeBalance(-200);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You forgot to buy a parking ticket and got fined 200");
    }

    private void carCrash(Player player, GameView gameView) {
        player.changeBalance(-3000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: Noob you crashed the car, you payed was 3000");
    }

    private void carTires(Player player, GameView gameView) {
        player.changeBalance(-1000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You changed you'r tires, you cried while paying 1000");
    }

    private void beer(Player player, GameView gameView) {
        player.changeBalance(-200);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You bought beer, it was 200");
    }

    private void moveToFrederiksberg(Player player, GameView gameView) {
        player.setPlayerField(getFields()[(11)%40]);
        gameView.setGUIPlayerField(player,(11)%40);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: you moved to Frederiksberg Allé ");
        player.getPlayerField().fieldAction(player,gameView);
    }

    private void jailFreeCard(Player player, GameView gameView) {
        player.setJailCard(true);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You have graced by the queen." + "\n" + "you got a jailfree card." );
    }

    private void moveThree(Player player, GameView gameView) {
        int newPosition = (player.getPlayerField().getPosition()+3);
        //player.setPlayerField(newPosition);
        player.setPlayerField(getFields()[(newPosition-1)%40]);
        gameView.setGUIPlayerField(player,(newPosition-1)%40);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: Move 3 spaces forward");

        player.getPlayerField().fieldAction(player,gameView);


    }

    private void carWash(Player player, GameView gameView) {
        player.changeBalance(-300);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: You got a expensive car wash - you payed 300");

    }

    private void fullStop(Player player, GameView gameView) {
        player.changeBalance(-1000);
        gameView.updatePlayerBalance(player,player.getBalance());
        gameView.gui.showMessage("Chance Card: Yo this is not USA, you drove past a Stop sign, " +
                "pay 1000");
    }
/*
        player.changeBalance(-1000);
        gameView.gui.showMessage("Chance Card:");// skriv besked
        Gamle int position skal være lavere end den nye int position for at trække 4000.
        if(oldPosition < newPosition) { changebalance(4000); }
*/
}

