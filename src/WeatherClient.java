import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class WeatherClient extends JFrame {
    private JTextField cityField;
    private JTextArea resultArea;

    public WeatherClient() {
        setTitle("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel cityLabel = new JLabel("Enter City:");
        cityField = new JTextField(20);
        JButton fetchButton = new JButton("Fetch Weather");
        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(cityLabel);
        inputPanel.add(cityField);
        inputPanel.add(fetchButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    fetchWeatherFromServer(city);
                } else {
                    JOptionPane.showMessageDialog(WeatherClient.this, "Please enter a city name.");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void fetchWeatherFromServer(String city) {
        try {
            Socket socket = new Socket("localhost", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(city);
            String response = in.readLine();

            if (response.startsWith("{\"error\":")) {
                resultArea.setText("Error: " + response.substring(10, response.length() - 2));
            } else if (response.startsWith("Temperature in ")) {
                resultArea.setText(response);
            } else {
                resultArea.setText("Error: Unexpected response from server.");
            }

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WeatherClient().setVisible(true);
            }
        });
    }
}
