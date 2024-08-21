import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestDistributionSystemApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating labels and text areas for input and output
        Label lineImpedanceLabel = new Label("Line Impedance (in ohms):");
        TextArea lineImpedanceInput = new TextArea();
        lineImpedanceInput.setWrapText(true);

        Label loadCharacteristicsLabel = new Label("Load Characteristics (V, A):");
        TextArea loadCharacteristicsInput = new TextArea();
        loadCharacteristicsInput.setWrapText(true);

        Label outputLabel = new Label();

        // Creating a button to display the entered information and plot the graph
        Button displayButton = new Button("Display Info & Plot Graph");
        displayButton.setOnAction(e -> {
            String lineImpedanceText = lineImpedanceInput.getText().trim();
            String loadCharacteristicsText = loadCharacteristicsInput.getText().trim();

            if (!lineImpedanceText.isEmpty() && !loadCharacteristicsText.isEmpty()) {
                double lineImpedance = Double.parseDouble(lineImpedanceText);
                String[] loadCharacteristics = loadCharacteristicsText.split(",");
                double voltage = Double.parseDouble(loadCharacteristics[0].trim());
                double current = voltage / lineImpedance;

                outputLabel.setText("Test Distribution System Parameters:\n" +
                        "Line Impedance: " + lineImpedanceText + " ohms\n" +
                        "Load Characteristics: " + loadCharacteristicsText + "\n" +
                        "Current (I): " + current + " Amps");

                // Plotting the graph
                plotGraph(lineImpedance, voltage, current);
            } else {
                outputLabel.setText("Please enter all network parameters.");
            }
        });

        // Creating a VBox to hold the input fields, button, and output label
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(lineImpedanceLabel, lineImpedanceInput, loadCharacteristicsLabel,
                loadCharacteristicsInput, displayButton, outputLabel);

        // Creating the scene
        Scene scene = new Scene(root, 600, 400);

        // Setting the stage title and scene
        primaryStage.setTitle("Test Distribution System");
        primaryStage.setScene(scene);

        // Showing the stage
        primaryStage.show();
    }

    @SuppressWarnings("unchecked")
    private void plotGraph(double lineImpedance, double voltage, double current) {
        // Creating the X and Y axes
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Impedance (ohms)");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");

        // Creating the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Impedance vs Voltage/Current");

        // Creating data series for voltage and current
        XYChart.Series<Number, Number> voltageSeries = new XYChart.Series<>();
        voltageSeries.setName("Voltage (V)");
        voltageSeries.getData().add(new XYChart.Data<>(lineImpedance, voltage));
        voltageSeries.getData().add(new XYChart.Data<>(0, 0)); // Add an extra point to connect lines

        XYChart.Series<Number, Number> currentSeries = new XYChart.Series<>();
        currentSeries.setName("Current (A)");
        currentSeries.getData().add(new XYChart.Data<>(lineImpedance, current));
        currentSeries.getData().add(new XYChart.Data<>(0, 0)); // Add an extra point to connect lines

        // Adding data series to the line chart
        lineChart.getData().addAll(voltageSeries, currentSeries);

        // Creating the scene
        Scene scene = new Scene(lineChart, 600, 400);

        // Creating a new stage for the graph and setting the scene
        Stage graphStage = new Stage();
        graphStage.setTitle("Graph - Impedance vs Voltage/Current");
        graphStage.setScene(scene);

        // Showing the graph stage
        graphStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}