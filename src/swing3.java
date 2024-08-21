import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class swing3 extends JFrame implements ActionListener {
    private JTextField cityField, nwpField, climateModelField;
    private JTextArea resultArea;

    public swing3() {
        setTitle("Weather and Climate Comparison");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Weather panel components
        JLabel cityLabel = new JLabel("Enter City:");
        cityField = new JTextField(20);
        JButton fetchWeatherButton = new JButton("Fetch Weather");

        // Climate comparison panel components
        JLabel nwpLabel = new JLabel("NWP Forecast (e.g., Temperature):");
        nwpField = new JTextField(10);
        JLabel climateModelLabel = new JLabel("Climate Model Projection (e.g., Temperature):");
        climateModelField = new JTextField(10);
        JButton compareButton = new JButton("Compare");

        resultArea = new JTextArea(15, 40);
        resultArea.setEditable(false);

        // Weather panel
        JPanel weatherPanel = new JPanel();
        weatherPanel.add(cityLabel);
        weatherPanel.add(cityField);
        weatherPanel.add(fetchWeatherButton);

        // Climate comparison panel
        JPanel climatePanel = new JPanel(new GridLayout(5, 2));
        climatePanel.add(nwpLabel);
        climatePanel.add(nwpField);
        climatePanel.add(climateModelLabel);
        climatePanel.add(climateModelField);
        climatePanel.add(compareButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add panels to frame
        add(weatherPanel, BorderLayout.NORTH);
        add(climatePanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        fetchWeatherButton.addActionListener(this);
        compareButton.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Fetch Weather")) {
            String city = cityField.getText().trim();
            if (!city.isEmpty()) {
                fetchWeather(city);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a city name.");
            }
        } else if (e.getActionCommand().equals("Compare")) {
            try {
                double nwpData = Double.parseDouble(nwpField.getText());
                double climateModelData = Double.parseDouble(climateModelField.getText());

                String result;
                if (nwpData < climateModelData) {
                    result = "NWP forecast suggests lower " + nwpField.getText() + " than Climate Model Projection.";
                } else if (nwpData > climateModelData) {
                    result = "NWP forecast suggests higher " + nwpField.getText() + " than Climate Model Projection.";
                } else {
                    result = "NWP forecast matches Climate Model Projection for " + nwpField.getText() + ".";
                }
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numerical data for comparison.");
            }
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
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response for debugging
                System.out.println("Response from server: " + response.toString());

                displayWeatherData(response.toString());
            } else {
                resultArea.setText("Error: Unable to fetch weather data. Please try again later. Response Code: " + responseCode);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resultArea.setText("Error: " + ex.getMessage());
        }
    }

    private void displayWeatherData(String response) {
        try {
            String[] lines = response.split("\n");
            String cityName = lines[0].split(": ")[1];
            double temperature = Double.parseDouble(lines[1].split(": ")[1]);
            double humidity = Double.parseDouble(lines[2].split(": ")[1]);
            double pressure = Double.parseDouble(lines[3].split(": ")[1]);
            double windSpeed = Double.parseDouble(lines[4].split(": ")[1]);

            resultArea.setText("City: " + cityName + "\n");
            resultArea.append("Temperature: " + temperature + "°C\n");
            resultArea.append("Humidity: " + humidity + "%\n");
            resultArea.append("Pressure: " + pressure + " hPa\n");
            resultArea.append("Wind Speed: " + windSpeed + " m/s\n");

            // Additional weather conditions analysis
            if (humidity > 70) {
                if (windSpeed > 5) resultArea.append("Weather: Rainy and Windy \nBAD WEATHER QUALITY");
                else resultArea.append("Weather: Rainy \nBAD WEATHER QUALITY");
            } else if (temperature > 25) {
                if (humidity < 30) resultArea.append("Weather: Sunny, Humidity is low \nGOOD WEATHER QUALITY");
                else resultArea.append("Weather: Hot and Humid \nBAD WEATHER QUALITY");
            } else if (temperature < 15) {
                if (windSpeed > 5) resultArea.append("Weather: Cold and Windy \nBAD WEATHER QUALITY");
                else resultArea.append("Weather: Cold\nGOOD WEATHER QUALITY");
            } else {
                if (humidity > 30) resultArea.append("Weather: Warm and Humid\nBAD WEATHER QUALITY");
                else resultArea.append("Weather: Moderate\nGOOD WEATHER QUALITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultArea.setText("Error: Invalid response from server.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new swing3().setVisible(true);
            }
        });
    }
}
