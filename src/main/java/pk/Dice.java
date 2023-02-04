package pk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static pk.Faces.*;

public class Dice {
    // Create a list to store 8 rolls
    private List<Faces> currentRollList = new ArrayList<>();

    // number of faces types = 6
    private final int numFaces = Faces.values().length;

    // fill a currentRollList with 8 random dices
    public void roll() {
        for( int i = 0; i<8; i++) {
            Random bag = new Random();
            currentRollList.add(Faces.values()[bag.nextInt(numFaces)]);
        }
    }

    // return the roll as a list
    public List<Faces> getRoll() {
        return currentRollList;
    }

    // for random strategy, reroll all non-skull elements once
    public void randomReroll(){
        for(int i = 0; i< currentRollList.size(); i++){
            if(currentRollList.get(i) !=SKULL) {
                Random bag = new Random();
                currentRollList.set(i,Faces.values()[bag.nextInt(numFaces)]);
            }
        }
    }

    // for combo strategy, reroll only drop list
    public void comboReroll(List<Faces> drop, List<Faces> Hold) {
        for(int i = 0; i<drop.size(); i++){
            if(drop.get(i) !=SKULL) {
                Random bag = new Random();
                drop.set(i,Faces.values()[bag.nextInt(numFaces)]);
            }
        }
        Hold.addAll(drop);
        currentRollList = Hold;
    }


    //build HashMap to count faces for a single roll
    public HashMap<Faces, Integer> faceCounter(){
        HashMap<Faces, Integer> mapTemp = new HashMap<>();
        int numSkull = 0;
        int numDiamond = 0;
        int numGold = 0;
        int numParrot = 0;
        int numMonkey = 0;
        int numSaber = 0;


        for(Faces i: currentRollList){
            if(i.equals(SKULL)){
                numSkull+=1;
            }
            else if(i.equals(DIAMOND)){
                numDiamond+=1;
            }
            else if(i.equals(GOLD)){
                numGold+=1;
            }
            else if(i.equals(PARROT)){
                numParrot+=1;
            }
            else if(i.equals(MONKEY)){
                numMonkey+=1;
            }
            else if(i.equals(SABER)){
                numSaber+=1;
            }
        }

        // add the result to the map1
        mapTemp.put(SKULL, numSkull);
        mapTemp.put(DIAMOND, numDiamond);
        mapTemp.put(GOLD, numGold);
        mapTemp.put(PARROT, numParrot);
        mapTemp.put(MONKEY, numMonkey);
        mapTemp.put(SABER, numSaber);

        return mapTemp;
    }
}
