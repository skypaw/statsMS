package GuiControllers;

import javafx.scene.control.TextField;

public class ValidatorStatic {
    public static double validatorNumber(TextField textField) {
        double result;

        try {
            String resultString = textField.getText();
            result = Double.parseDouble(resultString);

        } catch (NumberFormatException e) {
            System.out.println("To nie liczba");
            result = 0;
        }

        return result;
    }
}
