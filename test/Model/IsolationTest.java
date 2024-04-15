package Model;

import Model.Food;
import Model.Isolation;
import Model.Monkey;
import Model.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Model.Isolation class.
 */
public class IsolationTest {
    private Isolation isolation;

    /**
     * Setup method to initialize the isolation object before each test.
     */
    @BeforeEach
    public void setUp() {
        isolation = new Isolation();
    }

    /**
     * Test to verify that a monkey can be successfully added to an empty isolation cage.
     */
    @Test
    public void testAddMonkeyToEmptyIsolation() {
        Monkey monkey = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        assertTrue(isolation.addMonkey(monkey));
        List<Monkey> monkeys = isolation.getMonkeysInIsolation();
        assertTrue(monkeys.contains(monkey));
    }

    /**
     * Test to verify that a monkey cannot be added to a non-empty isolation cage.
     */
    @Test
    public void testAddMonkeyToNonEmptyIsolation() {
        Monkey monkey1 = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        Monkey monkey2 = new Monkey("Jill", "guereza", Sex.FEMALE, "medium", 7.2, 4, Food.FRUITS);
        assertTrue(isolation.addMonkey(monkey1));
        assertFalse(isolation.addMonkey(monkey2));
    }

    /**
     * Test to verify that a monkey can be successfully removed from the isolation cage.
     */
    @Test
    public void testRemoveMonkeyFromIsolation() {
        Monkey monkey = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        isolation.addMonkey(monkey);
        isolation.removeMonkey(monkey);
        assertFalse(isolation.getMonkeysInIsolation().contains(monkey));
    }

    /**
     * Test to verify that trying to remove a monkey not in the isolation cage produces the correct output.
     */
    @Test
    public void testRemoveNonExistingMonkeyFromIsolation() {
        Monkey monkey = new Monkey("Jack", "squirrel", Sex.MALE, "small", 5.5, 3, Food.NUTS);
        Monkey anotherMonkey = new Monkey("Jill", "guereza", Sex.FEMALE, "medium", 7.2, 4, Food.FRUITS);
        isolation.addMonkey(monkey);
        isolation.removeMonkey(anotherMonkey);
        assertTrue(isolation.getMonkeysInIsolation().contains(monkey));
        assertFalse(isolation.getMonkeysInIsolation().contains(anotherMonkey));
    }
}

