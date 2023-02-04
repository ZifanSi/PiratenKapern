package pk;

import java.util.HashMap;

import static pk.Cards.*;
import static pk.Faces.*;

public class Points {
    private int comboPoint = 0;

    public int SEABATTLE(Card newCard, int Sabers){
        if(newCard.getCard() == SEABATTLE_2){
            if(Sabers >= 2){
                return 300;
            } else {
                return -300;
            }
        } else if (newCard.getCard() == SEABATTLE_3) {
            if(Sabers >= 3){
                return 500;
            } else {
                return -500;
            }
        } else if (newCard.getCard() == SEABATTLE_4) {
            if(Sabers >= 4){
                return 1000;
            } else {
                return -1000;
            }
        } else{
            return 0;
        }
    }

    public int calculate(Dice playerDiceList, Card playerCard) {
        int totalPoints;
        HashMap<Faces, Integer> countFaces = playerDiceList.faceCounter();
        int seabattlePoints = SEABATTLE(playerCard, countFaces.get(SABER));

        // if a roll contains SKULL>=3 and SABERS = seabattle's requirement
        if( countFaces.get(SKULL) >= 3 && seabattlePoints > 0){
            return seabattlePoints*(-1);
        }
        // if a roll contains SABERS < seabattle's requirement
        else if (seabattlePoints < 0) {
            return seabattlePoints;
        }

        if (countFaces.get(SKULL) >= 3) {
            return 0;
        }
        //MONKEYBUSINESS
        if(playerCard.getCard() == MONKEYBUSINESS){
            int numMonkeyParrot = countFaces.get(MONKEY) + countFaces.get(PARROT);

            // set MONKEY rolls to 0
            countFaces.replace(MONKEY,0);

            // add MONKEY+PARROT as one combo, and merge into PARROT's face counter
            countFaces.replace(PARROT,numMonkeyParrot);
        }


        for (Faces i : countFaces.keySet()) {
            if(countFaces.get(i)==3){
                comboPoint += 100;

            } else if (countFaces.get(i)==4) {
                comboPoint += 200;

            } else if (countFaces.get(i)==5) {
                comboPoint += 500;

            } else if (countFaces.get(i)==6) {
                comboPoint += 1000;

            } else if (countFaces.get(i)==7) {
                comboPoint += 2000;

            } else if (countFaces.get(i)==8) {
                comboPoint += 4000;
            }
        }
        totalPoints = countFaces.get(GOLD) * 100 + countFaces.get(DIAMOND) *100 + comboPoint;
        return totalPoints;
    }
}
