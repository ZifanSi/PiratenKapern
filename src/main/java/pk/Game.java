package pk;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Game {


    public static final Logger logger = LogManager.getLogger(Game.class);
    private final String[] args;
    public Game(String[] args) {
        this.args = args;
    }

    // Check if input is valid
    public boolean inputTrigger(){
        boolean Execute = false;
        for(int i=0; i<2; i++){
            if(args[i].equals("combo")||args[i].equals("random")||args[i].equals("threeSKULL")){
                Execute = true;
            }
            else {
                Execute = false;
                break;
            }
        }
        return Execute;
    }

    // Check if simulation is valid based on input
    public void simulationTrigger(){
        if(inputTrigger()){
            simulation(args);
        } else {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Please Type: java -jar target/piraten-karpen-jar-with-dependencies.jar args[0] args[1] args[2](optional)");
            System.out.println("args[0]: select from one of three strategies : threeSKULL, random, combo");
            System.out.println("args[1]: select from one of three strategies : threeSKULL, random, combo");
            System.out.println("args[2](optional): select mode: traceMode ");
            System.out.println("For example:  java -jar target/piraten-karpen-jar-with-dependencies.jar combo random traceMode");
            System.out.println("-----------------------------------------------------------------------------");
        }
    }

    public static void simulation(String[] args) {
        int p1w = 0;
        int p2w = 0;
        float numGames = 42;
        for (int i = 0; i < numGames; i++) {
            boolean traceModeTrigger = false;
            Deck simulationDeck = new Deck();
            simulationDeck.addCards();
            simulationDeck.shuffle();

            if(args[2].equals("traceMode")){
                traceModeTrigger = true;
            }
            if(traceModeTrigger) {
                logger.info("------------------------------ "+"GAME " + (i+1)+" ------------------------------");
                logger.info(" ");
            }

            int p1TotalPoints = 0;
            int p2TotalPoints = 0;
            int round = 1;
            while ((p1TotalPoints < 6000) && (p2TotalPoints < 6000)) {
                logger.info("------------------------------ " + "round " + round + " ------------------------------");
                Card p1Draw = simulationDeck.drawTop();
                Card p2Draw = simulationDeck.drawTop();

                // if deck is empty. add -> shuffle
                if(p1Draw==null||p2Draw==null){
                    simulationDeck.addCards();
                    simulationDeck.shuffle();
                    p1Draw = simulationDeck.drawTop();
                    p2Draw = simulationDeck.drawTop();

                }

                Player player1 = new Player(args[0], p1Draw);
                Player player2 = new Player(args[1], p2Draw);


                if(traceModeTrigger) {
                    // player 1
                    logger.info("Player 1 turn");
                    logger.info("Player 1 draw a card: " + p1Draw.getCard());
                    player1.Action(traceModeTrigger);
                    int p1RoundPoints = player1.getPoints();
                    p1TotalPoints += p1RoundPoints;
                    logger.info("Player 1 round score of round " + round + ": " + p1RoundPoints);
                    logger.info("Player 1 total score: " + p1TotalPoints);
                    logger.info(" ");

                    // player 2
                    logger.info("Player 2 turn");
                    logger.info("Player 2 card: " + p2Draw.getCard());
                    player2.Action(traceModeTrigger);
                    int p2RoundPoints = player2.getPoints();
                    p2TotalPoints += p2RoundPoints;
                    logger.info("Player 2 round score of round " + round + ": " + p2RoundPoints);
                    logger.info("Player 2 total score: " + p2TotalPoints);
                }
                else{
                    player1.Action(traceModeTrigger);
                    int player1RoundPoints = player1.getPoints();
                    p1TotalPoints += player1RoundPoints;

                    player2.Action(traceModeTrigger);
                    int player2RoundPoints = player2.getPoints();
                    p2TotalPoints += player2RoundPoints;
                }
                round += 1;
            }
            if (p1TotalPoints > p2TotalPoints) {
                if(traceModeTrigger) {
                    logger.info("Player 1 win !");
                }
                p1w += 1;

            } else if (p2TotalPoints > p1TotalPoints) {
                if(traceModeTrigger) {
                    logger.info("Player 2 win !");
                }
                p2w += 1;

            } else {
                if(traceModeTrigger){
                    logger.info("Tie");
                }
            }
        }

        float p1WinRate = (p1w/numGames)*100;
        float p2WinRate = (p2w/numGames)*100;

        System.out.println("wins rate after " + numGames + " games:");
        System.out.println("player 1 win rate : " + p1WinRate + "%");
        System.out.println("player 2 win rate : " + p2WinRate + "%");
    }
}
