package pk;

import java.util.HashMap;

import static pk.Faces.SKULL;

public class Player {
    private final Dice rollList = new Dice();
    private final Points points = new Points();
    private final Strategy generalStrategy = new Strategy(rollList);

    private final String strategy;
    private final Card playerCard;
    public Player(String playerStrategy, Card playerCard) {
        this.strategy = playerStrategy;
        this.playerCard = playerCard;
    }



    public void Action(Boolean traceActivated) {
        // roll a list of 8 dice
        rollList.roll();

        if(traceActivated) {
            Game.logger.info("Initial roll: " + rollList.getRoll());
        }

        HashMap<Faces, Integer> map1 = rollList.faceCounter();

        // Gain no points if 3 SKULL rolled
        if (map1.get(SKULL) >= 3) {
            return;
        }

        // threeSKULL: Keep reroll until 3 SKULL
        if (strategy.equals("threeSKULL")) {
            generalStrategy.threeSKULL();
            Game.logger.info("After reroll" + rollList.getRoll());
        }
        // random: reroll once
        else if (strategy.equals("random")) {
            generalStrategy.random();
            Game.logger.info("After reroll: " + rollList.getRoll());
        }
        // combo: decide hold and drop, reroll once
        else if (strategy.equals("combo")) {
            generalStrategy.combo(playerCard);
            Game.logger.info("After reroll: " + rollList.getRoll());
        }
    }
    // return the score base on combo points and cards
    public int getPoints() {
        return points.calculate(rollList, playerCard);}
}

