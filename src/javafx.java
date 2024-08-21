import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javafx extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create labels and input fields
        Label titleLabel = new Label("Football Market Value Estimation");
        Label passingLabel = new Label("Passing Skill:");
        TextField passingField = new TextField();
        Label dribblingLabel = new Label("Dribbling Skill:");
        TextField dribblingField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();

        // Set button action
        calculateButton.setOnAction(event -> {
            try {
                // Get input values
                double passingSkill = Double.parseDouble(passingField.getText());
                double dribblingSkill = Double.parseDouble(dribblingField.getText());

                // Calculate market value (a simple formula for demonstration)
                double marketValue = 5000 + (passingSkill * 1000) + (dribblingSkill * 1500);

                // Display the result
                resultLabel.setText("Estimated Market Value: $" + String.format("%.2f", marketValue));
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers for passing and dribbling skills.");
            }
        });

        // Create a layout to hold the components
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, passingLabel, passingField, dribblingLabel, dribblingField,
                calculateButton, resultLabel);

        // Create the scene
        Scene scene = new Scene(root, 300, 250);

        // Set the stage title and scene, then show the stage
        primaryStage.setTitle("Football Market Value Estimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}