import java.util.ArrayList;
import java.util.Comparator;

public class DiceCup {
    private final ArrayList<Die> dice;
    DiceCup(int numberOfDice){
        dice = new ArrayList<>();
        for(int i = 0; i < numberOfDice; i++){
            dice.add(new Die());
        }
    }
    public void shake(){
        dice.forEach((Die::roll));
    }

    public Die[] toArray(){
        Die[] result = new Die[dice.size()];
        for (int i = 0; i <  dice.size(); i++) {
            result[i] = dice.get(i);
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        for (Die die : dice) {
            result.append(die.getValue()).append(", ");
        }
        return result.substring(0,result.length()-2) + " ]\n";
    }

    public void print(){
        System.out.println(this);
    }

    public void removeDie(){
        dice.remove(0);
    }

    public void addDie(){
        dice.add(new Die());
    }

    public int size(){
        return dice.size();
    }

    public void sort() {
        dice.sort(Comparator.comparingInt(Die::getValue));
    }

    public ArrayList<Die> getAll() {
        return dice;
    }

    public static ArrayList<Die> merge(ArrayList<? extends DiceCup> lists) {
        ArrayList<Die> result = new ArrayList<>();
        for(DiceCup list : lists){
            result.addAll(list.getAll());
        }
        return result;
    }
}