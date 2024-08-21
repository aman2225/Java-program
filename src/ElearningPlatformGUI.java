import javax.swing.*;

public class ElearningPlatformGUI {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("E-Learning Platform");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JPanel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set JFrame visibility
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create JLabels
        JLabel titleLabel = new JLabel("E-Learning Platform");
        titleLabel.setBounds(140, 10, 200, 25);
        panel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 80, 25);
        panel.add(nameLabel);

        // Create JTextField for name input
        JTextField nameTextField = new JTextField(20);
        nameTextField.setBounds(120, 50, 200, 25);
        panel.add(nameTextField);

        // Create JButton for submitting
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 100, 100, 25);
        panel.add(submitButton);

        // Create JLabel for feedback
        JLabel feedbackLabel = new JLabel("");
        feedbackLabel.setBounds(150, 150, 200, 25);
        panel.add(feedbackLabel);

        // Add ActionListener to submitButton
        submitButton.addActionListener(e -> {
            String name = nameTextField.getText();
            // Perform processing and generate feedback based on name
            String feedback = "Hello, " + name ;
            feedbackLabel.setText(feedback);
        });
    }
}
