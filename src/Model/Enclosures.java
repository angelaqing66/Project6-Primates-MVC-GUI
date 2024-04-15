package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enclosure in the Jungle Friends Primate Model.Sanctuary.
 */
public class Enclosures {
    private String species;
    private List<Monkey> monkeysInEnclosures;

    /**
     * Constructs an enclosure for a specific species of monkeys.
     *
     * @param species The species of monkeys housed in the enclosure.
     */
    public Enclosures(String species) {
        this.species = species;
        monkeysInEnclosures = new ArrayList<>();
    }

    /**
     * Adds a monkey to the enclosure.
     *
     * @param monkey The monkey to add.
     */
    public void addMonkey(Monkey monkey) {
        if(monkey.specie.equals(species)) {
            monkeysInEnclosures.add(monkey);
            System.out.println("Model.Monkey " + monkey.name + " added to " + species + " enclosure.");
        } else {
            System.out.println(" the monkey cannot add in this enclosure");
        }
    }

    /**
     * Removes a monkey from the enclosure.
     *
     * @param monkey The monkey to remove.
     */
    public void removeMonkey(Monkey monkey) {
        monkeysInEnclosures.remove(monkey);
        System.out.println("Model.Monkey " + monkey.name + " removed from " + species + " enclosure.");
    }

    /**
     * Gets the list of monkeys currently housed in the enclosure.
     *
     * @return The list of monkeys in the enclosure.
     */
    public List<Monkey> getMonkeysInEnclosures() {
        return monkeysInEnclosures;
    }

    /**
     * Gets the species of monkeys housed in the enclosure.
     *
     * @return The species of monkeys.
     */
    public String getSpecies() {
        return species;
    }
}
