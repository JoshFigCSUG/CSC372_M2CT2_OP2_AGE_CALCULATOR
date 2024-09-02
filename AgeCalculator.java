import java.awt.*;
import javax.swing.*;

public class AgeCalculator extends JFrame {

    private JPanel mainPanel;

    public AgeCalculator() {
        setTitle("Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 200)); // Set minimum size
        setSize(500, 200);
        setLocationRelativeTo(null); // Center the window

        add(mainPanel);
        setVisible(true);
    }
}