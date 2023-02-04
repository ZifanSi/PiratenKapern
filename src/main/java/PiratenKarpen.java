import pk.Game;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Game newGame = new Game(args);
        newGame.simulationTrigger();
    }
}
