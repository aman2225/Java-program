import java.io.*;
import java.net.*;

public class WeatherServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                WeatherHandler handler = new WeatherHandler(clientSocket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WeatherHandler extends Thread {
    private Socket clientSocket;

    public WeatherHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String city = in.readLine();
            System.out.println("Received request for weather in: " + city);

            fetchWeather(city, out);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fetchWeather(String city, PrintWriter out) {
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

                // Manually parse the JSON response to extract temperature
                String jsonResponse = response.toString();
                int startIndex = jsonResponse.indexOf("\"temp\":");
                int endIndex = jsonResponse.indexOf(',', startIndex);
                if (startIndex != -1 && endIndex != -1) {
                    String temperature = jsonResponse.substring(startIndex + 7, endIndex);
                    out.println("Temperature in " + city + ": " + temperature + "°C");
                } else {
                    out.println("{\"error\": \"Unable to fetch weather data. Please try again later.\"}");
                }
            } else {
                out.println("{\"error\": \"Unable to fetch weather data. Please try again later.\"}");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            out.println("{\"error\": \"" + ex.getMessage() + "\"}");
        }
    }
}
