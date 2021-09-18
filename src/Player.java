import java.util.Scanner;

public class Player extends DiceCup {
    public final String name;
    private final Guess guess;

    Player(String name, int amountOfDice){
        super(amountOfDice);
        this.name = name;
        guess = new Guess();
    }

    public Boolean believe(){
        Scanner in = new Scanner(System.in);
        print(name + " - Do you believe? y/n ");
        String s = in.nextLine();
        return s.equalsIgnoreCase("y");
    }

    private void print(String s){
        System.out.print(s);
    }

    public void seeDice(){
        Scanner in = new Scanner(System.in);
        print(name + " see your dice [tap enter]");
        in.nextLine();
        print(name + " - " + this);
        print(name + " hide your dice [tap enter]");
        in.nextLine();
        Main.clearConsole();
    }

    public Guess getGuess() {
        return guess;
    }

    public void setGuessComparedToPrevious(Guess prevGuess) {
        print("\nThe previous guess was - " + prevGuess);
        this.guess.newGuess(this.name, prevGuess);
    }
    public void newTurn(boolean mayRemove){
        if(mayRemove){removeDie();}
        if(size() != 0){shake(); seeDice();}
        this.guess.reset();
    }
}