package Model;

import Controller.GameController;
import Model.fields.*;

import java.util.ArrayList;
import java.util.List;

public class Board {


    private final List<Player> players= new ArrayList<>();
    private static Field[] fields = new Field[40];


    private Player current;

    public Board(){
        fields = createFields();
    }

    //Field Factory based on GUI implementation. GUI_FieldFactory.java
    public static Field[] createFields(){
        Field[] fields = new Field[40];
        int i = 0;
        fields[i++] = new Start("Start",0);
        fields[i++] = new Street("Rødovrevej",1,1200,new int[]{50,250,750,2250,4000,6000} ,1000,"blue");
        fields[i++] = new Chance("Chance",2);
        fields[i++] = new Street("Hvidovrevej",3,1200,new int[]{50,250,750,2250,4000,6000},1000,"blue");
        fields[i++] = new Tax("Tax",4);
        fields[i++] = new Shipping("Helsingør-Helsingborg",5,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Roskildevej",6,2000,new int[]{100,600,1800,5400,8000,11000},1000,"orange");
        fields[i++] = new Chance("Chance",7);
        fields[i++] = new Street("Valby Langgade",8,2000,new int[]{100,600,1800,5400,8000,11000},1000,"orange");
        fields[i++] = new Street("Allégade",9,2400,new int[]{150,800,2000,6000,9000,12000},1000,"orange");
        fields[i++] = new Jail("Visting jail",10);
        fields[i++] = new Street("Frederiksberg Allé",11,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"green");
        fields[i++] = new Brewery("Tuborg Squash",12,3000,new int[]{100,200});
        fields[i++] = new Street("Bülowsvej",13,2800,new int[]{200,1000,3000,9000,12500,15000},2000,"green");
        fields[i++] = new Street("Gl. Kongevej",14,3200,new int[]{250,1250,3750,10000,14000,18000},2000,"green");
        fields[i++] = new Shipping("Mols-linjen",15,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Bernstorrfsvej",16,3600,new int[]{300,1400,4000,11000,15000,19000},2000,"gray");
        fields[i++] = new Chance("Chance",17);
        fields[i++] = new Street("Hellerupvej",18,3600, new int[]{300,1400,4000,11000,15000,19000},2000,"gray");
        fields[i++] = new Street("Strandvejen",19,4000, new int[]{350,1600,4400,12000,16000,20000},2000,"gray");
        fields[i++] = new Parking("Parking",20);
        fields[i++] = new Street("Trianglen",21,4400,new int[]{350,1800,5000,14000,17500,21000},3000,"red");
        fields[i++] = new Chance("Chance",22);
        fields[i++] = new Street("Østerbrogade",23,4400,new int[]{350,1800,5000,14000,17500,21000},3000,"red");
        fields[i++] = new Street("Grønningen",24,4800,new int[]{400,2000,6000,15000,18500,22000},3000,"red");
        fields[i++] = new Shipping("Gedser-Rostock",25,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Street("Bredgade",26,5200,new int[]{450,2200,6600,16000,19500,23000},3000,"white");
        fields[i++] = new Street("Kgs. Nytorv",27,5200,new int[]{450,2200,6600,16000,19500,23000},3000,"white");
        fields[i++] = new Brewery("Coca-Cola",28,3000,new int[]{100,200});
        fields[i++] = new Street("Østergade",29,5600,new int[]{500,2400,7200,17000,20500,24000},3000,"white");
        fields[i++] = new ToJail("Go to Jail",30,fields[10]);
        fields[i++] = new Street("Amagertorv",31,6000,new int[]{550,2600,7800,18000,22000,25000},4000,"yellow");
        fields[i++] = new Street("Vimmelskaftet",32,6000,new int[]{550,2600,7800,18000,22000,25000},4000,"yellow");
        fields[i++] = new Chance("Chance",33);
        fields[i++] = new Street("Nygade",34,6400,new int[]{600,3000,9000,20000,24000,28000},4000,"yellow");
        fields[i++] = new Shipping("Rødby-Puttgarden",35,4000,new int[]{500,1000,2000,4000});
        fields[i++] = new Chance("Chance",36);
        fields[i++] = new Street("Frederiksberggade",37,7000,new int[]{700,3500,10000,22000,26000,30000},4000,"purple");
        fields[i++] = new Tax("Tax",38);
        fields[i++] = new Street("Rådhuspladsen",39,8000,new int[]{1000,4000,12000,28000,34000,40000},4000,"purple");
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
    public void removePlayer(Player player){
        players.remove(getPlayers().indexOf(player));
    }
    public List<Player> getPlayers(){return players;}

    public Player getPlayer(int playerNumber){
        return players.get(playerNumber-1);
    }

    public Player getCurrentPlayer() {
        return current;
    }
    public void setCurrentPlayer(Player current) {
        this.current = current;
    }
    public static Field[] getFields(){
        if(fields==null){
            fields=createFields();
        }
        return fields;
    }
}

