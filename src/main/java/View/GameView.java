package View;

import Model.Player;
import gui_fields.*;
import gui_fields.GUI_Car.Pattern;
import gui_fields.GUI_Car.Type;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameView {

    public List<GUI_Player> getGuiPlayers() {
        return guiPlayers;
    }

    private final List<GUI_Player> guiPlayers= new ArrayList<>();

    public GameView() {
    }


    GUI_Field[] guifields = {
    new GUI_Start("Start", "Receive 4000", "Receive kr. 4000,-\nwhen you pass start", Color.RED, Color.BLACK),
    new GUI_Street("Rødovrevej", "Price:  1200", "Rødovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Hvidovrevej", "Price:  1200", "Hvidovrevej", "Rent:  50", new Color(75, 155, 225), Color.BLACK),
    new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 200", "Betal indkomstskat\n10% eller kr. 200,-", Color.GRAY, Color.BLACK),
    new GUI_Shipping("default", "Øresund", "Pris:  200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK),
    new GUI_Street("Roskildevej", "Pris:  100", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Valby\nLanggade", "Pris:  100", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK),
    new GUI_Street("Allégade", "Pris:  120", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK),
    new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK),
    new GUI_Street("Frederiks-\nberg Allé", "Pris:  140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
    new GUI_Brewery("default", "Tuborg", "Pris:  150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE),
    new GUI_Street("Bülowsvej", "Pris:  140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
    new GUI_Street("Gammel Kongevej", "Pris:  140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK),
    new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK),
    new GUI_Street("Bernstorffsvej", "Pris:  180", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Hellerupvej", "Pris:  180", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
    new GUI_Street("Strandvejen", "Pris:  180", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK),
    new GUI_Refuge("default", "Helle", "Helle", "Ta' en pause", Color.WHITE, Color.BLACK),
    new GUI_Street("Trianglen", "Pris:  220", "Trianglen", "Leje:  70", Color.RED, Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Østerbro-\ngade", "Pris:  220", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK),
    new GUI_Street("Grønningen", "Pris:  240", "Grønningen", "Leje:  80", Color.RED, Color.BLACK),
    new GUI_Shipping("default", "Ø.S.", "Pris:  200", "Ø.S. redderiet", "Leje:  75", Color.WHITE, Color.BLACK),
    new GUI_Street("Bredgade", "Pris:  260", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK),
    new GUI_Street("Kgs. Nytorv", "Pris:  260", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK),
    new GUI_Brewery("default", "Carlsberg", "Pris:  150", "Carlsberg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE),
    new GUI_Street("Østergade", "Pris:  280", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK),
    new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK),
    new GUI_Street("Amagertorv", "Pris:  300", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK),
    new GUI_Street("Vimmel-\nskaftet", "Pris:  300", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Nygade", "Pris:  320", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK),
    new GUI_Shipping("default", "Bornholm", "Pris:  200", "Bornholms redderi", "Leje:  75", Color.WHITE, Color.BLACK),
    new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK),
    new GUI_Street("Frederiks-\nberggade", "Pris:  350", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.WHITE),
    new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 100", "Betal ekstraordinær\nstatsskat: kr. 100,-", Color.GRAY, Color.BLACK),
    new GUI_Street("Rådhuspladsen", "Pris:  400", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.WHITE),
    };

    GUI gui = new GUI(guifields);

    public GUI getGui() {
        return gui;
    }

    /**
     * This method takes User input for number of players, and their choice of type and color for their vehicle.
     * @return total players added are returned.
     */
    public int addPlayers(){

        int totalPlayers = 0;
        int playerAmount = Integer.parseInt(gui.getUserSelection(
                "Welcome to Matador! Pick number of players!",
                "2", "3","4","5","6"));

        for (int i=1;i<=playerAmount;i++) {

            String playerString = "Player"+ i;
            String carChoice = gui.getUserButtonPressed(
                    "%s, pick a vehicle type".formatted(playerString),
                    "CAR", "RACECAR", "TRACTOR","UFO");

            GUI_Car car = new GUI_Car(Color.red,Color.red, Type.getTypeFromString(carChoice),Pattern.FILL);
            GUI_Player guiPlayer = new GUI_Player("Player " +i,30000,car);

            String colorChoice = gui.getUserSelection(
                    "%s, pick a color for your car!".formatted(playerString),
                    "blue", "red","orange","white","pink");

            switch (colorChoice) {
                case "blue" -> car.setPrimaryColor(Color.blue);
                case "red" -> car.setPrimaryColor(Color.red);
                case "orange" -> car.setPrimaryColor(Color.orange);
                case "white" -> car.setPrimaryColor(Color.white);
                case "pink" -> car.setPrimaryColor(Color.pink);
            }

            /*
            Code to set playername to user input. not functional.

            String playerName= gui.getUserString("Type your name!");
            player.setName(playerName);
            player.setBalance(10);
            System.out.println(player.setName(playerName));
*/
            gui.addPlayer(guiPlayer);
            guiPlayers.add(guiPlayer);
            guiPlayer.getCar().setPosition(gui.getFields()[0]);
            totalPlayers = i;
        }
        return totalPlayers;
    }
    public void showDice(int die1,int die2){
        gui.setDice(die1,die2);
    }



    public void setGUIPlayerField(Player player, int fieldPosition){
        System.out.println("Setting GUIPlayer"+player.getPlayerNumber()+" to position: "+ fieldPosition);
        GUI_Player guiPlayer = guiPlayers.get(player.getPlayerNumber()-1);
        guiPlayer.getCar().setPosition(gui.getFields()[fieldPosition]);
    }
    public int getPlayerField(Player player){
        System.out.println(player.getPlayerNumber());
        GUI_Player guiPlayer = guiPlayers.get(player.getPlayerNumber());
        for (int i =0;i<40;i++){
            if (guiPlayer.getCar().getPosition()==gui.getFields()[i]) {
                return i;
            }
        }
        return 0;
    }
    public void showText(String text){
        gui.showMessage(text);
    }




}
