/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rex.torg.aa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.io.*;

/**
 * FXML Controller class
 *
 * @author Alina
 */



public class InfoPriceController implements Initializable {
    @FXML
    private TextField NameTovarField;
    @FXML
    private Label PriceLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void switchToBack() throws IOException{
        App.setRoot("Nomenclature");
    }
    
    @FXML
    public void ViewPrice() throws IOException{
        String NameTovar = NameTovarField.getText();
        
        
         try {
				File file = new File("output.txt");
				//создаем объект FileReader для объекта File
				FileReader fr = new FileReader(file);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader reader = new BufferedReader(fr);
				// считаем сначала первую строку
				String line = reader.readLine();

				while (line != null) {
                                //Получаем строку и разбиваем на 2 подстроки   
                                String strMain = line;
				String[] arrSplit = strMain.split(";");
				String NameTovarF = arrSplit[0];
                                int PriceTovar =  Integer.parseInt(arrSplit[1]);
                                if (NameTovar == NameTovarF){
                                    PriceLabel.setText(String.valueOf(PriceTovar));
                                    System.out.println(PriceTovar);
                                    return;
                                } else {
                                   PriceLabel.setText("Не найден"); 
                                }

				// считываем остальные строки в цикле
				line = reader.readLine();
				}
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
		}
        
        
    }


}
