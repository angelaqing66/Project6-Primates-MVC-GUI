package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an isolation cage in the Jungle Friends Primate Model.Sanctuary.
 */
public class Isolation {
    private boolean isEmpty;
    private List<Monkey> monkeysInIsolation;

    /**
     * Constructs an empty isolation cage.
     */
    public Isolation() {
        isEmpty = true;
        monkeysInIsolation = new ArrayList<>();
    }

    /**
     * Adds a monkey to the isolation cage.
     *
     * @param monkey The monkey to add.
     */
    public boolean addMonkey(Monkey monkey) {
        if(isEmpty == true) {
            monkeysInIsolation.add(monkey);
            isEmpty = false;
            System.out.println("Model.Monkey " + monkey.name + " added to isolation cage.");
            return true;
        } else {
            return false;
        }
    }
    /**
     * Removes a monkey from the isolation cage.
     */
    public void removeMonkey(Monkey monkey) {
        if (isEmpty) {
            System.out.println("The cage is empty.");
        } else {
            if (monkeysInIsolation.contains(monkey)) {
                monkeysInIsolation.remove(monkey);
                isEmpty = monkeysInIsolation.isEmpty();
                System.out.println("The monkey has been removed from the isolation cage.");
            } else {
                System.out.println("The monkey is not in this cage.");
            }
        }
    }

    /**
     * Gets the list of monkeys currently housed in the isolation cage.
     * @return The list of monkeys in the cage.
     */
    public List<Monkey> getMonkeysInIsolation() {
        return monkeysInIsolation;
    }
}
