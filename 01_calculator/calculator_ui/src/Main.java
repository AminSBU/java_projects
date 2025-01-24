import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.add(panel);
        placement(panel);

        frame.setVisible(true);
    }

    public static void placement(JPanel panel) {
        // Specify a preferred size for the JTextField
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(165, 50)); // width of 165, height of 50
        panel.add(textField);

        JButton button = new JButton("Clear");
        button.setPreferredSize(new Dimension(100, 50)); // width of 100, height of 50
        panel.add(button);

        // Use a layout manager to respect preferred sizes
        panel.setLayout(new FlowLayout()); // or any layout manager of your choice
    }
}