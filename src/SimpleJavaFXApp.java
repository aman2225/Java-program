import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleJavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label to display messages
        Label label = new Label("Hello, JavaFX!");

        // Create a button
        Button button = new Button("Click me");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Button Clicked!");
            }
        });

        // Stack the button and label vertically
        StackPane root = new StackPane();
        root.getChildren().add(label);
        root.getChildren().add(button);

        // Create a scene
        Scene scene = new Scene(root, 300, 250);

        // Set the title of the window
        primaryStage.setTitle("Simple JavaFX App");

        // Set the scene to the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
