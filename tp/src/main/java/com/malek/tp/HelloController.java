package com.malek.tp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    @FXML
    private Label date;
    @FXML
    private PasswordField password;

    @FXML
    private Label errerPassword;

    @FXML
    private Label errerEmail;

    @FXML
    private TextField email;

    @FXML
    public void initialize(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date.setText("Today is: " +dtf.format(now));
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void submit(ActionEvent event) {
        System.out.println("Email: " + email.getText());
        if(email.getText().equals("")) {
            errerEmail.setText("Email is required");
        }else if (!email.getText().contains("@")) {
            errerEmail.setText("Email is not valid");
        }else if(!email.getText().contains(".")) {
            errerEmail.setText("Email is not valid");
        }
        if(password.getText().equals("")) {
            errerPassword.setText("Password is required");}

        if (email.getText().equals("malek@gmail.com") && password.getText().equals("123")) {
            Stage s = new Stage();
            s.show();
        }
    }

}
