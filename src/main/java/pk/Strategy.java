package pk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static pk.Cards.*;
import static pk.Cards.MONKEYBUSINESS;
import static pk.Faces.*;
import static pk.Game.logger;


public class Strategy {
    private final Dice playerRollList;

    public Strategy(Dice strategyRollList) {
        this.playerRollList = strategyRollList;
    }

    public List<Faces> update() {
        return playerRollList.getRoll();
    }

    // threeSKULL: keep reroll until 3 SKULL
    public void threeSKULL() {
        HashMap<Faces, Integer> map2 = playerRollList.faceCounter();
        while (map2.get(SKULL) < 3) {
            playerRollList.randomReroll();
            map2 = playerRollList.faceCounter();
        }
    }

    // random: reroll non-skull dices 1 time
    public void random() {
        playerRollList.randomReroll();
    }

    // combo: decide hold and drop, reroll once
    public void combo(Card playerCard) {
        HashMap<Faces, Integer> map1 = playerRollList.faceCounter();

        // First, we full both hold and drop list with a same roll (8 dice)
        ArrayList<Faces> hold = new ArrayList<>(playerRollList.getRoll());
        ArrayList<Faces> drop = new ArrayList<>(playerRollList.getRoll());


        //If draw SEABATTLE CARD: drop will remove all SABER -> hold will add all SABER
        if (playerCard.getCard() == SEABATTLE_2 || playerCard.getCard() == SEABATTLE_3 || playerCard.getCard() == SEABATTLE_4) {
            drop.removeAll(Collections.singleton(SABER));
            // Cannot drop SKULL
            drop.removeAll(Collections.singleton(SKULL));


        }
        //If draw MONKEYBUSINESS CARD: drop will remove all MONKEY/PARROT -> hold will add all MONKEY/PARROT
        else if (playerCard.getCard() == MONKEYBUSINESS) {
            drop.removeAll(Collections.singleton(MONKEY));
            drop.removeAll(Collections.singleton(PARROT));
            // Cannot drop SKULL
            drop.removeAll(Collections.singleton(SKULL));

        } else {
            logger.info("The number of skulls is: " + map1.get(SKULL));
            for (Faces i : map1.keySet()) {
                // hold: 2 same dice
                if (i == SKULL || map1.get(i) >= 2) {
                    drop.removeAll(Collections.singleton(i));
                }
            }
        }

        // drop ∪ hold = 8 dice, drop ∩ hold = null
        hold.removeAll(drop);
        logger.info("player decide to Hold: " + hold);
        logger.info("player decide to Reroll: " + drop);
        if (drop.size() >= 2) {
            playerRollList.comboReroll(drop, hold);
        }
    }
}

