import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class SimpleGUI1 extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button;

    public SimpleGUI1() {
        // Set up the frame
        setTitle("Simple GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        label = new JLabel("Hello, World!");
        add(label);

        // Create a button
        button = new JButton("Click me!");
        button.addActionListener(this);
        add(button);

        // Set layout to FlowLayout
        setLayout(new FlowLayout());

        setVisible(true);
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
                new SimpleGUI1();
            }
        });
    }
}
