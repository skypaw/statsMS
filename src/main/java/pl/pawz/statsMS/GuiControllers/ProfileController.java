package pl.pawz.statsMS.GuiControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfileController {

    @FXML
    Button closeButton;

    public void onOkClose(){

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
