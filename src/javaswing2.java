import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class javaswing2 extends JFrame {
    private JTextField cityField;
    private JTextArea resultArea;

    public javaswing2() {
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
                    fetchWeather(city);
                } else {
                    JOptionPane.showMessageDialog(javaswing2.this, "Please enter a city name.");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
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
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parsing manually
                String data = response.toString();

                int nameStart = data.indexOf("\"name\":\"");
                int nameEnd = data.indexOf("\",", nameStart);
                String cityName = data.substring(nameStart + 8, nameEnd);

                int tempStart = data.indexOf("\"temp\":");
                int tempEnd = data.indexOf(",", tempStart);
                double temperature = Double.parseDouble(data.substring(tempStart + 7, tempEnd));

                int humidityStart = data.indexOf("\"humidity\":");
                int humidityEnd = data.indexOf(",", humidityStart);
                double humidity = Double.parseDouble(data.substring(humidityStart + 11, humidityEnd));

                int pressureStart = data.indexOf("\"pressure\":");
                int pressureEnd = data.indexOf(",", pressureStart);
                double pressure = Double.parseDouble(data.substring(pressureStart + 11, pressureEnd));

                int speedStart = data.indexOf("\"speed\":");
                int speedEnd = data.indexOf(",", speedStart);
                double windSpeed = Double.parseDouble(data.substring(speedStart + 8, speedEnd));

                displayWeatherData(cityName, temperature, humidity, pressure, windSpeed);
            } else {
                resultArea.setText("Error: Unable to fetch weather data. Please try again later.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void displayWeatherData(String cityName, double temperature, double humidity, double pressure, double windSpeed) {
        resultArea.setText("City: " + cityName + "\n");
        resultArea.append("Temperature: " + temperature + "°C\n");
        resultArea.append("Humidity: " + humidity + "%\n");
        resultArea.append("Pressure: " + pressure + " hPa\n");
        resultArea.append("Wind Speed: " + windSpeed + " m/s\n");

        if (temperature > 25) {
            resultArea.append("Weather: Sunny\n");
        } else if (temperature < 10) {
            resultArea.append("Weather: Cold\n");
        } else {
            resultArea.append("Weather: Moderate\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new javaswing2().setVisible(true);
            }
        });
    }
}
