import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class SimpleGUI2 implements ActionListener {
    private JFrame frame; // Changed to JFrame
    private JLabel label;
    private JButton button;

    public SimpleGUI2() {
        // Set up the frame
        frame = new JFrame(); // Create a new JFrame
        frame.setTitle("Simple GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        label = new JLabel("Hello, World!");
        frame.add(label);

        // Create a button
        button = new JButton("Click me!");
        button.addActionListener(this);
        frame.add(button);

        // Set layout to FlowLayout
        frame.setLayout(new FlowLayout());

        frame.setVisible(true); // Set the frame visible
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        if (e.getSource() == button) {
            label.setText("Button clicked!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleGUI2();
            }
        });
    }
}
