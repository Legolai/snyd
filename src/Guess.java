import java.util.Scanner;
public class Guess {
    private int number;
    private int amount;

    Guess(){
        reset();
    }

    public boolean compare(Guess otherGuess){
        int current = this.number == 1 ? 7 : this.number;
        int previous = otherGuess.number == 1 ? 7 : otherGuess.number;
        return this.amount > otherGuess.amount || current > previous && this.amount == otherGuess.amount;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public void setNumber(String name) {
        print(name + " - What number do you think there are " + this.amount + " of: ");
        this.number = getInput();
        if(!(this.number <= 6 && this.number > 0)) {
            print("\nYou must choose a number between 1-6!\n");
            setNumber(name);
        }
    }

    public void setAmount(String name) {
        print(name + " - How many of dice: ");
        this.amount = getInput();
    }

    private Integer getInput(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            print("You must giv a number not a string!: ");
            return getInput();
        }
    }

    public void reset(){
        number = 0;
        amount = 0;
    }

    private void print(String s){
        System.out.print(s);
    }

    public String toString() {
        return  "Amount: " + this.amount + ", " + "Number: " + this.number+ "\n";
    }

    public void newGuess(String name, Guess prevGuess){
        setAmount(name);
        setNumber(name);
        if(!compare(prevGuess)){
            print(name + " your guess is to low compare precious guess! try again\n");
            newGuess(name, prevGuess);
        }
    }
}