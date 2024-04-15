package Model;

import Model.Food;
import Model.Monkey;
import Model.Sanctuary;
import Model.Sex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for the Model.Sanctuary class.
 */
public class SanctuaryTest {

    /**
     * Test adding a monkey to isolation.
     */
    @Test
    public void testAddMonkeyToIsolation() {
        Sanctuary sanctuary = new Sanctuary();
        Monkey monkey = new Monkey("Bob", "drill", Sex.MALE, "medium", 10.5, 5, Food.FRUITS);
        sanctuary.addMonkeyToIsolation(monkey);
        List<Monkey> monkeysInIsolation = sanctuary.isolations.get(0).getMonkeysInIsolation();
        assertTrue(monkeysInIsolation.contains(monkey));
    }

    /**
     * Test moving a monkey to an enclosure.
     */
    @Test
    public void testMoveMonkeyToEnclosure() {
        Sanctuary sanctuary = new Sanctuary();
        Monkey monkey = new Monkey("Bob", "drill", Sex.MALE, "medium", 10.5, 5, Food.FRUITS);
        sanctuary.moveMonkeyToEnclosure(monkey, "drill");
        List<Monkey> monkeysInEnclosure = sanctuary.enclosures.get("drill").getMonkeysInEnclosures();
        assertTrue(monkeysInEnclosure.contains(monkey));
    }

    /**
     * Test getting a list of monkeys for each enclosure.
     */
    @Test
    public void testGetMonkeyListForEachEnclosure() {
        Sanctuary sanctuary = new Sanctuary();
        Map<String, List<String>> enclosureMonkeyList = sanctuary.getMonkeyListForEachEnclosure();
        assertNotNull(enclosureMonkeyList);
        assertFalse(enclosureMonkeyList.isEmpty());
    }

    /**
     * Test moving monkeys from isolation to enclosure.
     */
    @Test
    public void testMoveMonkeysFromIsolationToEnclosure() {
        Sanctuary sanctuary = new Sanctuary();
        Monkey monkey = new Monkey("Bob", "drill", Sex.MALE, "medium", 10.5, 5, Food.FRUITS);
        sanctuary.addMonkeyToIsolation(monkey);
        assertTrue(sanctuary.getAlphabeticalListOfMonkeys().contains(monkey));
        monkey.completeMedicalAttention();
        sanctuary.moveMonkeysFromIsolationToEnclosure();
        List<Monkey> monkeysInEnclosure = sanctuary.enclosures.get("drill").getMonkeysInEnclosures();
        assertTrue(monkeysInEnclosure.contains(monkey));
    }

    /**
     * Test getting an alphabetical list of all monkeys.
     */
    @Test
    public void testGetAlphabeticalListOfMonkeys() {
        Sanctuary sanctuary = new Sanctuary();
        List<Monkey> alphabeticalListOfMonkeys = sanctuary.getAlphabeticalListOfMonkeys();
        assertNotNull(alphabeticalListOfMonkeys);
        assertTrue(alphabeticalListOfMonkeys.isEmpty());
    }
}
