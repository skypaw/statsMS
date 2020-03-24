package GuiControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;


public class MainWindowController {

    @FXML
    ModelController modelFXML;
    @FXML
    Button calculations;
    @FXML
    AnchorPane scroll;
    int i = 0;
    double[] data;

    public void loadsWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(LoadsController.class.getResource("/fxml/LoadsFXML.fxml"));

        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public void profileWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(ProfileController.class.getResource("/fxml/ProfileFXML.fxml"));
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public void modelWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(ModelController.class.getResource("/fxml/modelFXML.fxml"));
        root.setId("modelFXML");
        System.out.println(root.getId());
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();



    }

    public void drawLine() {
        data = modelFXML.getData();
        System.out.println(Arrays.toString(data));

        Line line = new Line(i,i,i+100,i+100);
        scroll.getChildren().addAll(line);
        i=i+100;


    }

}
