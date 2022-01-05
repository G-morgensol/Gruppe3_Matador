package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Player> players= new ArrayList<>();

    public Board(){
    }

    //Field Factory based on GUI implementation. GUI_FieldFactory.java
    public static Field[] makeFields(){
        //TODO finish typing data for fields.
        Field[] fields = new Field[40];
        int i = 0;
        fields[i++] = new Start("Start",1);
        fields[i++] = new Street("Rødovrevej",2,1200,new int[]{50,250,750,2250,4000,6000} ,1000,"blue");
        fields[i++] = new Chance("Chance",3);
        fields[i++] = new Street("Hvidovrevej",4,1200,new int[]{50,250,750,2250,4000,6000},1000,"blue");
        fields[i++] = new Tax("Tax",5);





        return fields;

    }


    public void addPlayer(Player player){
        try {
            players.add(player);
        }
        catch(Exception e){
            System.out.println("Could not add player");
        }
    }
    public int getTotalPlayers(){return players.size();}

    public Player getPlayer(int playerNumber){
        return players.get(playerNumber);
    }



}
