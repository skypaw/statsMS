import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));

        Scene sceneRectangle = new Scene(root);

        primaryStage.setTitle("statsMS");
        primaryStage.setScene(sceneRectangle);
        primaryStage.show();
    }
}
