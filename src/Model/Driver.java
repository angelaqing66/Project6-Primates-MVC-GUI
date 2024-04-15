package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * driver class to manipulate the sanctuary
 */
public class Driver {
    public static void main(String[] args) {
        // Create a sanctuary
        Sanctuary sanctuary = new Sanctuary();

        // Create some monkeys
        Monkey monkey1 = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        Monkey monkey2 = new Monkey("Jill", "guereza", Sex.FEMALE, "medium", 7.2, 4, Food.FRUITS);

        // Add monkeys to isolation
        sanctuary.addMonkeyToIsolation(monkey1);
        sanctuary.addMonkeyToIsolation(monkey2);

        // Move monkey1 to enclosure
        sanctuary.moveMonkeyToEnclosure(monkey1, "squirrel");

        // Move monkeys from isolation to enclosures
        sanctuary.moveMonkeysFromIsolationToEnclosure();


        //get list of the sanctuary
        List<Monkey> list =  sanctuary.getAlphabeticalListOfMonkeys();
        System.out.println(list.get(0).name);
        System.out.println(list.get(1).name);
    }
}
