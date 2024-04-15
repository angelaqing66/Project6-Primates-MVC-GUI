package Model;

import Model.Enclosures;
import Model.Food;
import Model.Monkey;
import Model.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Model.Enclosures class.
 */
public class EnclosuresTest {
    private Enclosures enclosures;

    /**
     * Setup method to initialize the Model.Enclosures object before each test.
     */
    @BeforeEach
    public void setUp() {
        enclosures = new Enclosures("squirrel");
    }

    /**
     * Test to verify that a monkey can be successfully added to the enclosure.
     */
    @Test
    public void testAddMonkeyToEnclosure() {
        Monkey monkey = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        enclosures.addMonkey(monkey);
        assertTrue(enclosures.getMonkeysInEnclosures().contains(monkey));
    }

    /**
     * Test to verify that a monkey cannot be added to the enclosure if its species does not match.
     */
    @Test
    public void testAddMonkeyToWrongSpeciesEnclosure() {
        Monkey monkey = new Monkey("Jill", "guereza", Sex.FEMALE, "medium", 7.2, 4, Food.FRUITS);
        enclosures.addMonkey(monkey);
        assertFalse(enclosures.getMonkeysInEnclosures().contains(monkey));
    }

    /**
     * Test to verify that a monkey can be successfully removed from the enclosure.
     */
    @Test
    public void testRemoveMonkeyFromEnclosure() {
        Monkey monkey = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        enclosures.addMonkey(monkey);
        enclosures.removeMonkey(monkey);
        assertFalse(enclosures.getMonkeysInEnclosures().contains(monkey));
    }

    /**
     * Test to verify that the getSpecies method returns the correct species.
     */
    @Test
    public void testGetSpecies() {
        assertEquals("squirrel", enclosures.getSpecies());
    }
}
