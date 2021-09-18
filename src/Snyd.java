import java.util.ArrayList;
import java.util.Scanner;

public class Snyd {
    private final ArrayList<Player> players;
    private ArrayList<Die> allDice;
    private int currentIndex;

    Snyd(int dicePerCup, String[] names){
        this.players = new ArrayList<>();
        for (String name : names) {
            this.players.add(new Player(name, dicePerCup));
        }
    }
    public void begin() {
        currentIndex = 0;
        for(Player player : players){
            player.newTurn(false);
        }
        collectAllDice();
    }

    public void play(){
        while (true){
            beginTurn();
            if(players.size() == 1){
                println(players.get(0).name + " is the big loser!");
                break;
            }
            System.out.printf("Amount of dice left: %d\n",allDice.size());
        }
    }

    public void beginTurn(){
        for (;currentIndex <= players.size();currentIndex = nextPlayer(currentIndex)) {
            players.get(currentIndex).setGuessComparedToPrevious(players.get(previousPlayer(currentIndex)).getGuess());
            if(players.get(nextPlayer(currentIndex)).believe()){
                continue;
            }
            if(!validateGuess(players.get(currentIndex).getGuess())) {
                currentIndex = previousPlayer(currentIndex);
            }
            newTurn();
            break;
        }
    }

    public void newTurn(){
        Scanner in = new Scanner(System.in);
        println("All players have removed one die except " + players.get(currentIndex).name);
        println("To begin new turn [Tap enter]");
        in.nextLine();
        Main.clearConsole();
        println("A new turn begins");
        for (Player player : players) {
            if(player != players.get(currentIndex) ){
                player.newTurn(true);
                if (player.size() == 0){
                    println(player.name + " you are done!");
                    players.remove(player);
                }
            } else player.newTurn(false);
        }
        collectAllDice();
    }

    private boolean validateGuess(Guess guess){
        int number = guess.getNumber();
        long diceAmount = allDice.stream().filter(c -> c.getValue() == number).count();
        if(guess.getNumber() != 1){diceAmount += allDice.stream().filter(c -> c.getValue() == 1).count();}
        println("There where " + diceAmount + " of the value " + number + (number != 1 ? " including ones." : ""));
        return diceAmount >= guess.getAmount();
    }

    private void collectAllDice(){
        allDice = DiceCup.merge(players);
    }

    private int nextPlayer(int index){
        if(index == players.size()-1){return 0;}
        return index += 1;
    }

    private int previousPlayer(int index){
        if(index == 0){return players.size()-1;}
        return index -= 1;
    }

    private void println(String s){
        System.out.println(s);
    }
}