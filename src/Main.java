public class Main {
    public static void main(String[] args) {
        String[] players = {"Michael", "Nicolai", "Jesper"};
        Snyd game = new Snyd(6, players);
        game.begin();
        game.play();
    }
    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}