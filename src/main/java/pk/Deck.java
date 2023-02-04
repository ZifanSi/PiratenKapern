package pk;

import java.util.ArrayList;
import java.util.Collections;

import static pk.Cards.*;

public class Deck {

    private final ArrayList<Card> cardSet;
    public Deck() {
        cardSet = new ArrayList<>();
    }

    // shuffle 35 cards
    public void shuffle() {
        Collections.shuffle(cardSet);
    }

    // add 35 cards to the deck
    public void addCards(){
        Card SeaBattle2 = new Card(SEABATTLE_2);
        Card SeaBattle3 = new Card(SEABATTLE_3);
        Card SeaBattle4 = new Card(SEABATTLE_4);
        Card Nop = new Card(NOP);

        // new feature: Monkey Business cards
        Card MonkeyBusiness = new Card(MONKEYBUSINESS);

        // 6 Sea Battle cards: 2 per each
        for(int j=0; j<2; j++){
            cardSet.add(SeaBattle2);
            cardSet.add(SeaBattle3);
            cardSet.add(SeaBattle4);
        }
        // 25 nop cards
        for(int i=0; i<25; i++){
            cardSet.add(Nop);
        }

        // 4 monkey business cards
        for(int k=0; k<4; k++){
            cardSet.add(MonkeyBusiness);
        }
    }

    // draw a random card form top of the deck
    public Card drawTop() {
        if(cardSet.size()>0){
            return cardSet.remove(0);
        }
        else{
            return null;
        }
    }


}

