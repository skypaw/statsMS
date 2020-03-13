package GuiControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class MainWindowController {

    public void loadsWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.<Parent>load(LoadsController.class.getResource("/fxml/LoadsFXML.fxml"));
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public void profileWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.<Parent>load(ProfileController.class.getResource("/fxml/ProfileFXML.fxml"));
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }

    public void modelWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.<Parent>load(ModelController.class.getResource("/fxml/modelFXML.fxml"));
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }




}
