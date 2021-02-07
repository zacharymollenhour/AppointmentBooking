package sample.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Utilities.LoginUser;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Project: QAM1-Software2-ZacharyMollenhour
 * Package: Controller
 * <p>
 * Author: Zachary Mollenhour
 * Date: 2/6/2021
 * Time: 1:27 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public class LoginController implements Initializable {

    //Controller FXML
    @FXML
    private TextField Username;
    @FXML
    private Label loginLabel, passLabel;
    @FXML
    private TextField Password;
    @FXML
    private Button LoginButton;

    private String checkUsrName, checkPssWord;

    private String mainView = "\"/Views/Main.fxml\"";

    @FXML
    private AnchorPane errorPane;
    private String ErrorTitle;
    private String ErrorHeader;
    private String ErrorText;

    public LoginController() {
    }


    public void initialize(){};

    @FXML
    public void Login(ActionEvent actionEvent) throws SQLException {
        checkUsrName = Username.getText();
        checkPssWord = Password.getText();
        System.out.println(checkUsrName);
        if(checkPssWord != null && checkUsrName != null)
        {
            try{
                LoginUser.Login(checkUsrName,checkPssWord);
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/Main.fxml"));
                //Parent root = FXMLLoader.load(getClass().getResource("/Views/Main.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                Alert LoginAlert = new Alert(Alert.AlertType.ERROR);
                LoginAlert.setTitle(ErrorTitle);
                LoginAlert.setHeaderText(ErrorHeader);
                LoginAlert.setContentText(ErrorText);
                LoginAlert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        passLabel.setText("Password");
        LoginButton.setText("Login");

    }



}
