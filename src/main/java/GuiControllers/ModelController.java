package GuiControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModelController {

    @FXML
    Button closeButton;
    @FXML
    TextField x1;
    @FXML
    TextField y1;
    @FXML
    TextField x2;
    @FXML
    TextField y2;

    private double x1Value = 0;
    private double x2Value = 0;
    private double y1Value = 0;
    private double y2Value = 0;

    MainWindowController Controller = new MainWindowController();

    public void initialize(){
        System.out.println("Window created");
    }

    public void onOkClose() {
        x1Value = ValidatorStatic.validatorNumber(x1);
        x2Value = ValidatorStatic.validatorNumber(x2);
        y1Value = ValidatorStatic.validatorNumber(y1);
        y2Value = ValidatorStatic.validatorNumber(y2);

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public double[] getData() {
        return new double[]{x1Value, x2Value, y1Value, y2Value};
    }

}
