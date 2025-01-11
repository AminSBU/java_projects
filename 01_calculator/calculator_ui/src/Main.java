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
        JTextField textField = new JTextField(10);
        textField.setBounds(30, 30, 500, 30);
        panel.add(textField);

    }
}