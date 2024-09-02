import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

public class AgeCalculator extends JFrame {

    private JPanel mainPanel;
    private JSpinner birthDateSpinner;
    private JButton calculateAgeButton;

    public AgeCalculator() {
        setTitle("Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 200)); // Set minimum size
        setSize(500, 200);
        setLocationRelativeTo(null); // Center the window

        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Prompt Label
        JLabel promptLabel = new JLabel("Enter your birth date (Month-Day-Year) then hit the button to calculate your age:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center component
        mainPanel.add(promptLabel, gbc);

        // Birth Date Spinner
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateModel.setCalendarField(Calendar.YEAR);
        birthDateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(birthDateSpinner, "MMMM-dd-yyyy");
        birthDateSpinner.setEditor(dateEditor);
        birthDateSpinner.setPreferredSize(new Dimension(150, 30));
        birthDateSpinner.setMinimumSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(birthDateSpinner, gbc);

        // Calculate Age Button
        calculateAgeButton = new JButton("Calculate Age");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(calculateAgeButton, gbc);

        add(mainPanel);
        setVisible(true);
    }
}