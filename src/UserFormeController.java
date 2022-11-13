import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormeController {

    @FXML
    private JFXTextField txtUName;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXTextField txtPwd;

    @FXML
    private JFXTextField txtRole;

    @FXML
    private Button btnRegister;

    @FXML
    void btnRegOnAction(ActionEvent event) {
        Pattern userNamePattern = Pattern.compile("^[a-z0-9]{4,}$");
        Matcher matcher = userNamePattern.matcher(txtUName.getText());
        boolean isUserNameMatch = matcher.matches();

        Pattern emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)");
        Matcher emailMatcher = emailPattern.matcher(txtEmail.getText());
        boolean isEmailMatch = emailMatcher.matches();

        if(isUserNameMatch) {
            if(isEmailMatch) {
                System.out.println("Email match");
            } else {
                txtEmail.setFocusColor(Paint.valueOf("Red"));
                txtEmail.requestFocus();
            }
        } else {
            txtUName.setFocusColor(Paint.valueOf("Red"));
            txtUName.requestFocus();
        }

    }

}
