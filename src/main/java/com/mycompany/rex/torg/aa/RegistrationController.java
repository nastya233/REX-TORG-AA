package com.mycompany.rex.torg.aa;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
public class RegistrationController {

@FXML
    private TextField loginText;
    
@FXML
    private TextField passwordText;

    @FXML
    public void switchToPrimary() throws IOException {
       App.setRoot("primary");
    }
}