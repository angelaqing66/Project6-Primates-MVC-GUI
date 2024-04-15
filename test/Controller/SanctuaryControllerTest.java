package Controller;

import Controller.SanctuaryController;
import Model.Monkey;
import Model.Sanctuary;
import Model.Sex;
import Model.Food;
import View.SanctuaryView;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Test class for SanctuaryController.
 * This class uses manual stubs instead of a mocking framework to test the functionality of SanctuaryController.
 */
public class SanctuaryControllerTest {

    private Sanctuary model;
    private SanctuaryView view;
    private SanctuaryController controller;
    private boolean monkeyAdded;
    private String lastMessageDisplayed;
    private int lastMessageType;
    private String lastEnclosureListDisplayed;
    private String lastAllMonkeysDisplayed;

    /**
     * Sets up the test environment and initializes the controller with stubbed model and view.
     */
    @Before
    public void setUp() {
        // Setup stub model and view
        // Initialize flags for assertions
        monkeyAdded = false;
        lastMessageDisplayed = null;
        lastMessageType = -1;

        // Stubbed version of SanctuaryModel
        model = new Sanctuary() {
            @Override
            public boolean addMonkeyToIsolation(Monkey monkey) {
                // Simulate success of adding a monkey to isolation
                monkeyAdded = true;
                return true;
            }
            @Override
            public Map<String, List<String>> getMonkeyListForEachEnclosure() {
                Map<String, List<String>> enclosures = new HashMap<>();
                enclosures.put("Enclosure1", Arrays.asList("Monkey1 - Species1", "Monkey2 - Species1"));
                // Add more entries as needed
                return enclosures;
            }

            @Override
            public List<Monkey> getAlphabeticalListOfMonkeys() {
                List<Monkey> monkeys = new ArrayList<>();
                // Populate the list with dummy monkeys for the test
                monkeys.add(new Monkey("Monkey1", "Species1", Sex.MALE, "Small", 10, 5, Food.FRUITS));
                monkeys.add(new Monkey("Monkey2", "Species2", Sex.FEMALE, "Medium", 12, 6, Food.INSECTS));
                // Add more entries as needed
                return monkeys;
            }

            @Override
            public void moveMonkeysFromIsolationToEnclosure() {
                // Simulate the movement of monkeys
            }
        };

        // Stubbed version of SanctuaryView
        view = new SanctuaryView() {
            @Override
            public void showMessage(String message, String title, int messageType) {
                lastMessageDisplayed = message;
                lastMessageType = messageType;
            }

            @Override
            public void setEnclosureListsText(String text) {
                lastEnclosureListDisplayed = text;
            }

            @Override
            public void setAllMonkeysText(String text) {
                lastAllMonkeysDisplayed = text;
            }
        };

        // Instantiate the controller with the stubbed model and view
        controller = new SanctuaryController(model, view);
    }

    /**
     * Test the registerMonkey method for successful monkey registration.
     */
    @Test
    public void testRegisterMonkey() {
        // Given: a monkey to register
        Monkey monkey = new Monkey("Anna", "Drill", Sex.FEMALE, "small", 5.6, 2, Food.FRUITS);

        // When: the monkey is registered via the controller
        controller.registerMonkey(monkey);

        // Then: the monkey is added to isolation and an informational message is shown
        assertTrue("Model.Monkey Anna added to isolation cage.", monkeyAdded);
        assertEquals("The message displayed should be informational",
                "Model.Monkey Anna added to isolation cage.", lastMessageDisplayed);
        assertEquals("The message type should be INFORMATION_MESSAGE",
                JOptionPane.INFORMATION_MESSAGE, lastMessageType);
    }

    /**
     * Tests that the displayEnclosureLists method correctly retrieves the enclosure lists from the model
     * and updates the view.
     */
    @Test
    public void testDisplayEnclosureLists() {
        controller.displayEnclosureLists();

        assertNotNull("The enclosure list should be displayed", lastEnclosureListDisplayed);
        assertTrue("The enclosure list text should contain the name of the first enclosure",
                lastEnclosureListDisplayed.contains("Enclosure1"));
        assertTrue("The enclosure list text should contain information about monkeys",
                lastEnclosureListDisplayed.contains("Monkey1 - Species1"));
    }

    /**
     * Tests that the displayAllMonkeys method correctly retrieves an alphabetical list of all monkeys
     * from the model and updates the view.
     */
    @Test
    public void testDisplayAllMonkeys() {
        controller.displayAllMonkeys();

        assertNotNull("The list of all monkeys should be displayed", lastAllMonkeysDisplayed);
        assertTrue("The all monkeys text should contain information about monkeys",
                lastAllMonkeysDisplayed.contains("Monkey1"));
        assertTrue("The all monkeys text should be in alphabetical order based on names",
                lastAllMonkeysDisplayed.startsWith("Name: Monkey1; Name: Monkey2; ")); // Assuming the list is sorted in the model
    }

}

