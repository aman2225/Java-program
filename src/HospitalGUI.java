import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HospitalGUI extends JFrame implements ActionListener {
    private JTextField nameField, ageField, genderField, contactField, timeField;
    private JComboBox<String> departmentBox;
    private JButton registerButton, showPatientsButton;
    private JTextArea outputArea;

    private String[] departments = {"Cardiology", "Orthopedics", "Neurology", "Gynecology", "Pediatrics"};
    private ArrayList<String> registeredPatients;

    public HospitalGUI() {
        setTitle("Hospital Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel registrationPanel = new JPanel(new GridLayout(7, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Patient registration fields
        registrationPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        registrationPanel.add(nameField);
        registrationPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        registrationPanel.add(ageField);
        registrationPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        registrationPanel.add(genderField);
        registrationPanel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        registrationPanel.add(contactField);
        registrationPanel.add(new JLabel("Department:"));
        departmentBox = new JComboBox<>(departments);
        registrationPanel.add(departmentBox);
        registrationPanel.add(new JLabel("Appointment Time:"));
        timeField = new JTextField();
        registrationPanel.add(timeField);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);

        // Show Patients Button
        showPatientsButton = new JButton("Show Registered Patients");
        showPatientsButton.addActionListener(this);
        buttonPanel.add(showPatientsButton);

        // Output Area
        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(registrationPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        registeredPatients = new ArrayList<>();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            // Perform patient registration
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = genderField.getText();
            String contact = contactField.getText();
            String department = (String) departmentBox.getSelectedItem();
            String time = timeField.getText();

            // Placeholder for actual registration process
            String registrationMessage = "Patient Registered:\nName: " + name + "\nAge: " + age + "\nGender: " + gender + "\nContact: " + contact + "\nDepartment: " + department + "\nAppointment Time: " + time;
            outputArea.setText(registrationMessage);

            // Store registered patient information
            String patientInfo = "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contact + ", Department: " + department + ", Appointment Time: " + time;
            registeredPatients.add(patientInfo);
        } else if (e.getSource() == showPatientsButton) {
            // Show all registered patients
            StringBuilder patientsInfo = new StringBuilder("Registered Patients:\n");
            for (String patient : registeredPatients) {
                patientsInfo.append(patient).append("\n");
            }
            outputArea.setText(patientsInfo.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {


            public void run() {
                new HospitalGUI();
            }
        });
    }
}
