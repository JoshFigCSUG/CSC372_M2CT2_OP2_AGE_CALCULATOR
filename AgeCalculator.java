import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class AgeCalculator extends JFrame {

    private JPanel mainPanel;
    private JSpinner birthDateSpinner;
    private JButton calculateAgeButton;
    private JLabel ageLabel;

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

        // Age Label
        ageLabel = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(ageLabel, gbc);

        calculateAgeButton.addActionListener((ActionEvent e) -> {
            calculateAge();
        });

        add(mainPanel);
        setVisible(true);
    }

    private void calculateAge() {
        Date selectedDate = (Date) birthDateSpinner.getValue();
        LocalDate birthDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);

        int age = period.getYears();
        ageLabel.setText("Your age is: " + age);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgeCalculator());
    }
}