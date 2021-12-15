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
public class NomenclatureController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
   private ObservableList<Tovar> TovarData = FXCollections.observableArrayList();

    @FXML
    private TableView<Tovar> tableTovar;

    @FXML
    private TableColumn<Tovar, Integer> PriceColumn;

    @FXML
    private TableColumn<Tovar, String> TovarColumn;

 



    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // TODO   
    initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        PriceColumn.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("Price"));
        TovarColumn.setCellValueFactory(new PropertyValueFactory<Tovar, String>("Tovar"));
 



        // заполняем таблицу данными
        tableTovar.setItems(TovarData);
                   
    }

    @FXML
    public void switchToInfoPrice() throws IOException{
        App.setRoot("InfoPrice");

    }
    
    @FXML
    public void switchToBack() throws IOException{
        App.setRoot("Tovaroved");
    }
    @FXML
    public void switchToCreate() throws IOException{
        App.setRoot("ElementNom");
    }

    private void initData() {
        
        
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
				//Записываем наименование товара в переменную
                                String NameTovar = arrSplit[0];
                                // Записываем цену товара в переменную
                                int PriceTovar =  Integer.parseInt(arrSplit[1]);
                                //Запись в TableView
                                TovarData.add(new Tovar(PriceTovar, NameTovar));
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
