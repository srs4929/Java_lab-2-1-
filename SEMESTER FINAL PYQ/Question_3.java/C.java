/* Explain the concept of event triggering with an example related to java graphical interface.
 Analyze the importance and explain how it brings additional improvements to an application.


 Solve :

 Event triggering involves responding to user interactions such as mouse clicks,key presses and other actions triggered by 
 user. 
 Importance :
 - UI more responsive 
 - Dynamic
 - can handle multiple event effectively


 Example :

 Button button =new Button("Click me");
 EventHandler<ActionEvent>eventhandler=new EventHandler<ActionEvent>()
 {
     public void handle(ActionEvent e)
     { 
        System.out.println("Button clicked");
     }
 };

 button.setOnAction(eventHandler);

 */

 import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventExampleFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click Me");

        // Correctly defined event handler
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Button clicked");
            }
        };

        // Assigning the event handler
        button.setOnAction(eventHandler);

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Event Handling Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
