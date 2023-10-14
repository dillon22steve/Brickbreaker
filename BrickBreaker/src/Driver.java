
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
            }

            if (newGame) {
                runGame();
                setNewGame(false);
            }
        }
    }

    public static void setNewGame(boolean b) {
        newGame = b;
    }

    public static void runGame() {
        Game game = new Game();
        System.out.println("run game success");
    }

}