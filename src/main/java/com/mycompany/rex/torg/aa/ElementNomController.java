/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rex.torg.aa;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.*;
import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
/**
 * FXML Controller class
 *
 * @author Alina
 */
public class ElementNomController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField NameField;
    
    @FXML
    private TextField PriceField;
    
    @FXML
    private Label ErorLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO

    }    
   @FXML
    public void switchToBack() throws IOException{
        App.setRoot("Nomenclature");
    }
    
    @FXML
    public void CreateElement() throws IOException{
        String name = NameField.getText();
        String price = PriceField.getText();
        String sum = name + ";" + price;
        // здесь мы допишем информацию в конец файла, если он уже существует
        PrintWriter writer2 = new PrintWriter((new FileWriter("output.txt", true)));
        writer2.println(sum);
        writer2.close();
   
        NameField.setText("");
        PriceField.setText("");
        ErorLabel.setText("В базу добавлен новый товар!");
        
        
  
    }
        
        
    }



