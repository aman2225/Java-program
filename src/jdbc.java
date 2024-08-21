import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.*;

public class jdbc extends JFrame {
    private JTextField cityField;
    private JTextArea resultArea;
    private Connection connection;

    public jdbc() {
        setTitle("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Set modern Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set custom font and colors
        Font font = new Font("Arial", Font.PLAIN, 14);
        Color bgColor = new Color(135, 206, 235);
        Color textColor = new Color(33, 33, 33);
        Color btnColor = new Color(66, 133, 244);

        // Configure components
        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setFont(font);
        cityLabel.setForeground(textColor);

        cityField = new JTextField(20);
        cityField.setFont(font);
        cityField.setBackground(Color.PINK);
        cityField.setForeground(textColor);

        JButton fetchButton = new JButton("Fetch Weather");
        fetchButton.setFont(font);
        fetchButton.setBackground(btnColor);
        fetchButton.setForeground(Color.BLUE);
        fetchButton.setFocusPainted(false);

        resultArea = new JTextArea(15, 40);
        resultArea.setFont(font);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.WHITE);
        resultArea.setForeground(textColor);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBackground(bgColor);

        // Add components to the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(cityLabel, gbc);

        gbc.gridx = 1;
        add(cityField, gbc);

        gbc.gridx = 2;
        add(fetchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    fetchWeather(city);
                } else {
                    JOptionPane.showMessageDialog(jdbc.this, "Please enter a city name.");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);

        // Connect to the database
        try {
//            mysql databse connection.
            String url = "jdbc:mysql://localhost:3306/java";
            String username = "root";
            String password = "Amankumar@22";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jdbc.this, "Failed to connect to the database.");
        }
    }

    private void fetchWeather(String city) {
        try {

            String apiKey = "1523172bd53d053c37abeb791f3c2a57";
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(city, "UTF-8") + "&appid=" + apiKey + "&units=metric";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                parseWeatherData(response.toString());
            } else {
                resultArea.setText("Error: Unable to fetch weather data. Please try again later.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void parseWeatherData(String jsonData) {
        try {
            // Manually parse JSON data
            String cityName = getValueFromJson(jsonData, "name");
            double temperature = Double.parseDouble(getValueFromJson(jsonData, "temp"));
            double humidity = Double.parseDouble(getValueFromJson(jsonData, "humidity"));
            double pressure = Double.parseDouble(getValueFromJson(jsonData, "pressure"));
            double windSpeed = Double.parseDouble(getValueFromJson(jsonData, "speed"));

            resultArea.setText("City: " + cityName + "\n");
            resultArea.append("Temperature: " + temperature + "°C\n");
            resultArea.append("Humidity: " + humidity + "%\n");
            resultArea.append("Pressure: " + pressure + " hPa\n");
            resultArea.append("Wind Speed: " + windSpeed + " m/s\n");

            // Insert data into the database
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO WeatherData (city, temperature, humidity, pressure, wind_speed) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, cityName);
            statement.setDouble(2, temperature);
            statement.setDouble(3, humidity);
            statement.setDouble(4, pressure);
            statement.setDouble(5, windSpeed);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: Failed to insert data into the database.");
        }
    }

    // Helper method to extract value from JSON string
    private String getValueFromJson(String jsonData, String key) {
        int startIndex = jsonData.indexOf("\"" + key + "\":");
        int endIndex = jsonData.indexOf(',', startIndex);
        if (endIndex == -1) {
            endIndex = jsonData.indexOf('}', startIndex);
        }
        return jsonData.substring(startIndex + key.length() + 3, endIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jdbc frame = new jdbc();
                frame.setVisible(true);
            }
        });
    }
}
