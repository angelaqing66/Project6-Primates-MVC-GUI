package Controller;

import Model.Monkey;
import Model.Sanctuary;
import View.SanctuaryView;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * Controller class for the Sanctuary. It handles the interaction
 * between the view and the model.
 */
public class SanctuaryController {
    private Sanctuary model;
    private SanctuaryView view;

    /**
     * Constructs a controller for the sanctuary.
     *
     * @param model The data model for the sanctuary.
     * @param view  The user interface view for the sanctuary.
     */
    public SanctuaryController(Sanctuary model, SanctuaryView view){
        this.model = model;
        this.view = view;
        this.view.setController(this);  // Link the controller to the view
        this.view.setVisible(true);
    }

    /**
     * Registers a monkey and adds it to an isolation cage.
     *
     * @param monkey The monkey to register and add to isolation.
     */
    public void registerMonkey(Monkey monkey) {
        // Perform registration logic, e.g., update model, handle full capacity etc.
        // Potentially update the view, e.g., show a dialog if the isolation is full
        boolean success = model.addMonkeyToIsolation(monkey);
        if(success){
            String message = "Model.Monkey " + monkey.name + " added to isolation cage.";
            view.showMessage(message,"Information", 1);
        } else {
            String message = "Error: No available isolation cage.";
            view.showMessage(message,"Information", 2);
        }
    }

    /**
     * Moves medically cleared monkeys from isolation to their respective enclosures.
     */
    public void moveMedicallyClearedMonkeys() {
        try {
            model.moveMonkeysFromIsolationToEnclosure();
            view.showMessage("Medically cleared monkeys have been moved to their enclosures.", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            view.showMessage("Failed to move monkeys: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays a list of monkeys in each enclosure in the sanctuary.
     */
    public void displayEnclosureLists() {
        Map<String, List<String>> enclosureLists = model.getMonkeyListForEachEnclosure();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : enclosureLists.entrySet()) {
            sb.append("Enclosure: ").append(entry.getKey()).append("\n");
            for (String details : entry.getValue()) {
                sb.append(details).append("\n");
            }
            sb.append("\n");
        }
        view.setEnclosureListsText(sb.toString());
    }

    /**
     * Displays an alphabetical list of all the monkeys in the sanctuary.
     */
    public void displayAllMonkeys() {
        List<Monkey> allMonkeys = model.getAlphabeticalListOfMonkeys();
        StringBuilder sb = new StringBuilder();
        for(Monkey monkey: allMonkeys){
            sb.append("Name: ").append(monkey.name).append("; ");
        }
        view.setAllMonkeysText(sb.toString());
    }
}
