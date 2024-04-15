package Model;

import Model.Enclosures;
import Model.Isolation;
import Model.Monkey;

import java.util.*;

/**
 * Represents the Jungle Friends Primate Model.Sanctuary.
 */
public class Sanctuary {
    public List<Isolation> isolations;
    public Map<String,Enclosures> enclosures;

    /**
     * Constructs a sanctuary with isolation cages and enclosures.
     */
    public Sanctuary() {
        isolations = new ArrayList<>(20);
        enclosures = new HashMap<>();
        initializeEnclosures();
        initializeIsolationCages();
    }

    /**
     * Initializes the isolation cages in the sanctuary.
     */
    private void initializeIsolationCages() {
        // Create and add isolation cages to the list
        for (int i = 0; i < 20; i++) {
            isolations.add(new Isolation());
        }
    }

    /**
     * Initializes the enclosures in the sanctuary.
     */
    private void initializeEnclosures() {
        // Create and add enclosures to the list (one for each species)
        String[] species = {"drill", "guereza", "howler", "mangabey", "saki", "spider", "squirrel", "tamarin"};
        for (String s : species) {
            enclosures.put(s, new Enclosures(s));
        }
    }

    /**
     * Adds a monkey to an available isolation cage.
     * @param monkey The monkey to be added to isolation.
     */
    public boolean addMonkeyToIsolation(Monkey monkey) {
        boolean added = false;
        for (Isolation cage : isolations) {
            if (cage.addMonkey(monkey)) {
                added = true;
                return true;
            }
        }
        System.out.println("Error: No available isolation cage.");
        return added;
    }

    /**
     * Moves a monkey to the specified enclosure.
     * @param monkey The monkey to be moved.
     * @param species The species of the enclosure.
     */
    public void moveMonkeyToEnclosure(Monkey monkey, String species) {
        if (enclosures.containsKey(species)) {
            Enclosures enclosure = enclosures.get(species);
            enclosure.addMonkey(monkey);
        } else {
            System.out.println("Error: No enclosure found for species " + species);
        }
    }

    /**
     * Produces a list for every enclosure that shows each individual monkey currently housed there,
     * including their name, sex, and favorite food.
     * @return Map with enclosure species as keys and lists of monkey details as values.
     */
    public Map<String, List<String>> getMonkeyListForEachEnclosure() {
        Map<String, List<String>> enclosureMonkeyList = new HashMap<>();

        for (String species : enclosures.keySet()) {
            Enclosures enclosure = enclosures.get(species);
            List<Monkey> monkeysInEnclosure = enclosure.getMonkeysInEnclosures();

            List<String> monkeyDetailsList = new ArrayList<>();
            for (Monkey monkey : monkeysInEnclosure) {
                String monkeyDetails = "Name: " + monkey.name + ", Model.Sex: " + monkey.sex + ", Favorite Model.Food: " + monkey.food;
                monkeyDetailsList.add(monkeyDetails);
            }

            enclosureMonkeyList.put(species, monkeyDetailsList);
        }

        return enclosureMonkeyList;
    }

    /**
     * Moves monkeys from isolation to appropriate enclosures based on medical attention received.
     */
    public void moveMonkeysFromIsolationToEnclosure() {
        List<Isolation> isolationsCopy = new ArrayList<>(isolations);

        for (Isolation cage : isolationsCopy) {
            List<Monkey> monkeysInCage = new ArrayList<>(cage.getMonkeysInIsolation());
            for (Monkey monkey : monkeysInCage) {
                if (monkey.completeMedical) {
                    String species = monkey.specie;
                    if (enclosures.containsKey(species)) {
                        Enclosures enclosure = enclosures.get(species);
                        enclosure.addMonkey(monkey);
                        cage.removeMonkey(monkey);
                        System.out.println(monkey.name + " has been moved to the " + species + " enclosure.");
                    } else {
                        System.out.println("Error: No enclosure found for species " + species);
                    }
                }
            }
        }
    }

    /**
     * Produces an alphabetical list of all monkeys housed in the Model.Sanctuary.
     * @return List of monkeys sorted alphabetically by name.
     */
    public List<Monkey> getAlphabeticalListOfMonkeys() {
        ArrayList<Monkey> allMonkeys = new ArrayList<>();
        for (Isolation cage : isolations) {
            allMonkeys.addAll(cage.getMonkeysInIsolation());
        }
        for (Enclosures enclosure : enclosures.values()) {
            allMonkeys.addAll(enclosure.getMonkeysInEnclosures());
        }

        // Sort the list alphabetically by name
        Collections.sort(allMonkeys, Comparator.comparing(m -> m.name));

        return allMonkeys;
    }

}
