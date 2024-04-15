package View;

import Controller.SanctuaryController;
import Model.Food;
import Model.Monkey;
import Model.Sanctuary;
import Model.Sex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the graphical user interface for the Primate Sanctuary Management System.
 * It provides a comprehensive view for registering new primates, moving medically cleared primates,
 * and displaying detailed lists of primates in various enclosures or all primates managed by the sanctuary.
 * This class uses Java Swing components to create the user interface.
 */
public class SanctuaryView  extends JFrame {
    private SanctuaryController controller;  // Reference to the controller
    private JTextField monkeyNameField;
    private JTextField monkeySexField;
    private JTextField monkeySpecieField;
    private JTextField monkeySizeField;
    private JTextField monkeyWeightField;
    private JTextField monkeyAgeField;
    private JTextField monkeyFoodField;
    private JButton registerButton;
    private JButton moveMedicallyClearedMonkeysButton;
    private JButton showEnclosureListsButton;
    private JTextArea enclosureListsTextArea;
    private JButton showAllMonkeysButton;
    private JTextArea allMonkeysTextArea;

    /**
     * Constructs the main window of the application, initializing all GUI components,
     * setting up the layout, and wiring event handlers.
     */
    public SanctuaryView(){

         //Initialize and set up UI components
        monkeyNameField = new JTextField(20);
        monkeySexField = new JTextField(20);
        monkeySpecieField = new JTextField(20);
        monkeySizeField = new JTextField(20);
        monkeyWeightField = new JTextField(20);
        monkeyAgeField = new JTextField(20);
        monkeyFoodField = new JTextField(20);
        registerButton = new JButton("Register Monkey");

        // Layout Setup
        setLayout(new FlowLayout()); // Use FlowLayout for simplicity
        add(new JLabel("Name:"));
        add(monkeyNameField);
        add(new JLabel("Sex:"));
        add(monkeySexField);
        add(new JLabel("Specie:"));
        add(monkeySpecieField);
        add(new JLabel("Size:"));
        add(monkeySizeField);
        add(new JLabel("Weight:"));
        add(monkeyWeightField);
        add(new JLabel("Age:"));
        add(monkeyAgeField);
        add(new JLabel("Favorite Food:"));
        add(monkeyFoodField);
        add(registerButton);

        // Set up action listener to directly call the controller
        registerButton.addActionListener(e -> registerMonkey());

        moveCompleteMedicalToEnclosure();
        displayListOfEnclosure();
        displayAllMonkeys();

        // Frame settings
        setTitle("Primate Sanctuary System");
        setSize(500, 1000);  // Adjust size as needed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    /**
     * Registers a new monkey based on input fields when the register button is clicked.
     */
    private void registerMonkey(){
        String name = monkeyNameField.getText();
        Sex sex = Sex.valueOf(monkeySexField.getText().toUpperCase());
        String specie = monkeySpecieField.getText();
        String size = monkeySizeField.getText();
        double weight = Double.parseDouble(monkeyWeightField.getText());
        int age = Integer.parseInt(monkeyAgeField.getText());
        Food food = Food.valueOf(monkeyFoodField.getText().toUpperCase());

        Monkey monkey = new Monkey(name, specie, sex, size, weight, age, food);
        if (controller != null) {
            controller.registerMonkey(monkey);
        }
    }

    /**
     * Sets up the button and action for moving medically cleared monkeys to their appropriate enclosures.
     */
    private void moveCompleteMedicalToEnclosure() {
        moveMedicallyClearedMonkeysButton = new JButton("Move Medically Cleared Monkeys");
        moveMedicallyClearedMonkeysButton.addActionListener(e -> {
            if (controller != null) {
                controller.moveMedicallyClearedMonkeys();
            }
        });
        add(moveMedicallyClearedMonkeysButton);
    }

    /**
     * Sets up the view for displaying a list of enclosures with their respective monkeys.
     */
    private void displayListOfEnclosure() {
        showEnclosureListsButton = new JButton("Show Enclosure Lists");
        showEnclosureListsButton.addActionListener(e -> {
            if (controller != null) {
                controller.displayEnclosureLists();
            }
        });

        enclosureListsTextArea = new JTextArea(15, 20);
        enclosureListsTextArea.setEditable(false);

        add(showEnclosureListsButton);
        add(new JScrollPane(enclosureListsTextArea));
    }

    /**
     * Sets up the view for displaying all monkeys in alphabetical order.
     */
    private void displayAllMonkeys(){
        showAllMonkeysButton = new JButton("Show all monkeys");
        showAllMonkeysButton.addActionListener(e ->{
            if(controller != null){
                controller.displayAllMonkeys();
            }
        });
        allMonkeysTextArea = new JTextArea(15, 20);
        allMonkeysTextArea.setEditable(false);

        add(showAllMonkeysButton);
        add(new JScrollPane(allMonkeysTextArea));
    }

    /**
     * Updates the text of the enclosures list area.
     * @param text The text to display in the enclosure list text area.
     */
    public void setEnclosureListsText(String text) {
        enclosureListsTextArea.setText(text);
    }

    /**
     * set the text of all monkeys
     * @param text
     */
    public void setAllMonkeysText(String text) {
        allMonkeysTextArea.setText(text);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public void setController(SanctuaryController controller) {
        this.controller = controller;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Sanctuary model = new Sanctuary(); // Assume Sanctuary is properly defined
            SanctuaryView view = new SanctuaryView();
            SanctuaryController controller = new SanctuaryController(model, view);
            view.setController(controller);
            view.setVisible(true);
        });
    }
}
