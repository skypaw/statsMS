package GuiControllers;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class LoadsController {
    @FXML
    Button closeButton;

    public void onOkClose(){

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
