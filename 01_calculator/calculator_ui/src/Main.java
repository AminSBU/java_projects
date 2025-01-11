import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("calculator");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.add(panel);
        placement(panel);

        frame.setVisible(true);
    }

    public static void placement(JPanel panel) {
        JTextField textField = new JTextField(50);
        textField.setBounds(100, 20, 165, 50);
        panel.add(textField);

        JButton button = new JButton("+");
        button.setBounds(20, 10, 100, 50);
        panel.add(button);
    }
}