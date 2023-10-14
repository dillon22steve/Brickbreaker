
//This class was written by Steve and Chase
public class Driver {
        
    static boolean newGame = false;
    public static void main(String[] args) {

        double timePerCheck = (5_000_000_000.0);
        long now = System.nanoTime();
        long lastCheck = now;
        
        runGame();

        while (true) {
            now = System.nanoTime();
            if (now - lastCheck >= timePerCheck) {
                System.out.println("Checking");
                lastCheck = now;
            } //if

            if (newGame) {
                runGame();
                setNewGame(false);
            } //if
        } //while
    } //main

    public static void setNewGame(boolean b) {
        newGame = b;
    } //setNewGame

    public static void runGame() {
        Game game = new Game();
    } //runGame

} //Driver