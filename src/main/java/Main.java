import Controller.GameController;
import Model.Board;
import View.GameView;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI_Field[] guifields = {
                //TODO Fix fields so they have the correct values! Consider moving declaration out of main
                new GUI_Start("Start", "Receive 4000", "Receive kr. 4000,-\nwhen you pass start", Color.RED, Color.BLACK),
                new GUI_Street("Rødovrevej", "Price:  1200", "Rødovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
                new GUI_Chance("?", "Try your luck!", "Take a chance card.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Hvidovrevej", "Price:  1200", "Hvidovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
                new GUI_Tax("Pay\nincome-\ntax", "10% or 4000", "Pay incometax\n10% or kr. 4000,-", Color.GRAY, Color.BLACK),
                new GUI_Shipping("default", "Øresund", "Pris:  4000", "Øresundsredderiet", "Rent:  500", Color.WHITE, Color.BLACK),
                new GUI_Street("Roskildevej", "Pris:  2000", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK),
                new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Valby\nLanggade", "Pris:  2000", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK),
                new GUI_Street("Allégade", "Pris:  2400", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK),
                new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK),
                new GUI_Street("Frederiks-\nberg Allé", "Pris:  2800", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
                new GUI_Brewery("default", "Tuborg", "Pris:  3000", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE),
                new GUI_Street("Bülowsvej", "Pris:  2800", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
                new GUI_Street("Gammel Kongevej", "Pris:  3200", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
                new GUI_Shipping("default", "D.F.D.S.", "Pris:  4000", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK),
                new GUI_Street("Bernstorffsvej", "Pris:  3600", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
                new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Hellerupvej", "Pris:  3600", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
                new GUI_Street("Strandvejen", "Pris:  4000", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
                new GUI_Refuge("default", "Helle", "Helle", "Ta' en pause", Color.WHITE, Color.BLACK),
                new GUI_Street("Trianglen", "Pris:  4400", "Trianglen", "Leje:  70", Color.RED, Color.BLACK),
                new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Østerbro-\ngade", "Pris:  4400", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK),
                new GUI_Street("Grønningen", "Pris:  4800", "Grønningen", "Leje:  80", Color.RED, Color.BLACK),
                new GUI_Shipping("default", "Ø.S.", "Pris:  4000", "Ø.S. redderiet", "Leje:  75", Color.WHITE, Color.BLACK),
                new GUI_Street("Bredgade", "Pris:  5200", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK),
                new GUI_Street("Kgs. Nytorv", "Pris:  5200", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK),
                new GUI_Brewery("default", "Carlsberg", "Pris:  3000", "Carlsberg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE),
                new GUI_Street("Østergade", "Pris:  5600", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK),
                new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK),
                new GUI_Street("Amagertorv", "Pris:  6000", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK),
                new GUI_Street("Vimmel-\nskaftet", "Pris:  6000", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK),
                new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Nygade", "Pris:  6400", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK),
                new GUI_Shipping("default", "Bornholm", "Pris:  4000", "Bornholms redderi", "Leje:  75", Color.WHITE, Color.BLACK),
                new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
                new GUI_Street("Frederiks-\nberggade", "Pris:  7000", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.WHITE),
                new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 2000", "Betal ekstraordinær\nstatsskat: kr. 100,-", Color.GRAY, Color.BLACK),
                new GUI_Street("Rådhuspladsen", "Pris:  8000", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.WHITE),
        };
        GUI gui = new GUI(guifields);
        GameView gameView = new GameView(gui);
        Board board = new Board();
        GameController gamecontroller = new GameController(board,gameView);
        gamecontroller.startGame();
    }

}
