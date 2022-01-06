package Model;

import Model.fields.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Player> players= new ArrayList<>();

    public Board(){
        makeFields();
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
        fields[i++] = new Shipping("Helsingør-Helsingborg",6,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Roskildevej",7,2000,new int[]{100,600,1800,5400,8000,11000},1000,"orange");
        fields[i++] = new Chance("Chance",8);
        fields[i++] = new Street("Valby Langgade",9,2000,new int[]{100,600,1800,5400,8000,11000},1000,"orange");
        fields[i++] = new Street("Allégade",10,2400,new int[]{150,800,2000,6000,9000,12000},1000,"orange");
        fields[i++] = new Jail("Jail",11);
        fields[i++] = new Street("Frederiksberg Allé",12,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"yellow");
        fields[i++] = new Brewery("Tuborg Squash",13,3000,new int[]{100,200});
        fields[i++] = new Street("Bülowsvej",14,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"yellow");
        fields[i++] = new Street("Gl. Kongevej",15,3200,new int[]{250,1250,3750,10000,14000,18000},2000,"yellow");
        fields[i++] = new Shipping("Mols-linjen",16,4000,new int[]{500,1000,2000,4000});






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
