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
        fields[i++] = new Jail("Visting jail",11);
        fields[i++] = new Street("Frederiksberg Allé",12,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"green");
        fields[i++] = new Brewery("Tuborg Squash",13,3000,new int[]{100,200});
        fields[i++] = new Street("Bülowsvej",14,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"green");
        fields[i++] = new Street("Gl. Kongevej",15,3200,new int[]{250,1250,3750,10000,14000,18000},2000,"green");
        fields[i++] = new Shipping("Mols-linjen",16,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Bernstorrfsvej",17,3600,new int[]{300,1400,4000,11000,15000,19000},2000,"gray");
        fields[i++] = new Chance("Chance",18);
        fields[i++] = new Street("Hellerupvej",19,3600, new int[]{300,1400,4000,11000,15000,19000},2000,"gray");
        fields[i++] = new Street("Strandvejen",20,4000, new int[]{350,1600,4400,12000,16000,20000},2000,"gray");
        fields[i++] = new Parking("Parking",21);
        fields[i++] = new Street("Trianglen",22,4400,new int[]{350,1800,5000,14000,17500,21000},3000,"red");
        fields[i++] = new Chance("Chance",23);
        fields[i++] = new Street("Østerbrogade",24,4400,new int[]{350,1800,5000,14000,17500,21000},3000,"red");
        fields[i++] = new Street("Grønningen",25,4800,new int[]{400,2000,6000,15000,18500,22000},3000,"red");
        fields[i++] = new Shipping("Gedser - Rostock",26,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Bredgade",27,5200,new int[]{450,2200,6600,16000,19500,23000},3000,"white");
        fields[i++] = new Street("Kgs´-nytrov",28,5200,new int[]{450,2200,6600,16000,19500,23000},3000,"white");
        fields[i++] = new Brewery("Coca-Cola",29,3000,new int[]{100,200});
        fields[i++] = new Street("Østergade",30,5600,new int[]{500,2400,7200,17000,20500,24000},3000,"white");
        fields[i++] = new Jail("you got arrested",31);
        fields[i++] = new Street("Amagertorv",32,6000,new int[]{550,2600,7800,18000,22000,25000},4000,"yellow");
        fields[i++] = new Street("Vimmelskaftet",33,6000,new int[]{550,2600,7800,18000,22000,25000},4000,"yellow");
        fields[i++] = new Chance("Chance",34);
        fields[i++] = new Street("Nygade",35,6400,new int[]{600,3000,9000,20000,24000,28000},4000,"yellow");
        fields[i++] = new Shipping("Rødby-Puttgarden",36,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Chance("Chance",37);
        fields[i++] = new Street("Frederiksberggade",38,7000,new int[]{700,3500,10000,22000,26000,30000},4000,"purple");
        fields[i++] = new Tax("Tax",39);
        fields[i++] = new Street("Rådhuspladsen",40,8000,new int[]{1000,4000,12000,28000,34000,40000},4000,"purple");






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
