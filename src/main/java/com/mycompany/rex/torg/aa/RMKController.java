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
import java.lang.*;
/**
 * FXML Controller class
 *
 * @author Alina
 */
public class RMKController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
    private ObservableList<TovarRMK> TovarRMKData = FXCollections.observableArrayList();
    @FXML
    private Label NumberSmenaLabel;
    
    @FXML
    private Label NumberCheckLabel;
    
    @FXML
    private Label TovarLabel;
    
    @FXML
    private Label PriceLabel;
    
     @FXML
    private TableView<TovarRMK> tableTovarRMK;

    @FXML
    private TableColumn<TovarRMK, Integer> PriceColumn;

    @FXML
    private TableColumn<TovarRMK, String> TovarRMKColumn;
    
    @FXML
    private TableColumn<TovarRMK, Integer> idColumn;
    
    @FXML
    private TableColumn<TovarRMK, Integer> kolvoColumn;
    
    @FXML
    private TableColumn<TovarRMK, Integer> sumColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberCheckLabel.setText("1");
        //Инцилизация номера смены
        initSmena();
        initTovarPodbor();
        PriceColumn.setCellValueFactory(new PropertyValueFactory<TovarRMK, Integer>("Price"));
        TovarRMKColumn.setCellValueFactory(new PropertyValueFactory<TovarRMK, String>("TovarRMK"));
        idColumn.setCellValueFactory(new PropertyValueFactory<TovarRMK, Integer>("id"));
        kolvoColumn.setCellValueFactory(new PropertyValueFactory<TovarRMK, Integer>("kolvo"));
        sumColumn.setCellValueFactory(new PropertyValueFactory<TovarRMK, Integer>("sum"));
        tableTovarRMK.setItems(TovarRMKData);
    }    
    
    @FXML
      public void switchToPodbor() throws IOException{
        App.setRoot("podbor");
    }
    @FXML
        public void DeleteStroka() throws IOException{
            int selectedIndex = tableTovarRMK.getSelectionModel().getSelectedIndex();
    //        tableTovarRMK.getItems().remove(selectedIndex);
        }
    @FXML
    public void plusKolvoTovar() throws IOException{

        int selectedIndex = tableTovarRMK.getSelectionModel().getSelectedIndex();
        int kolvo = TovarRMKData.get(selectedIndex).getKolvo();
        int price = TovarRMKData.get(selectedIndex).getPrice();
        kolvo++;
        price = price * kolvo;
        TovarRMKData.get(selectedIndex).setKolvo(kolvo);
        TovarRMKData.get(selectedIndex).setSum(price);
         tableTovarRMK.refresh();

    }
        @FXML
    public void minusKolvoTovar() throws IOException{
  
        int selectedIndex = tableTovarRMK.getSelectionModel().getSelectedIndex();
        int kolvo = TovarRMKData.get(selectedIndex).getKolvo();
        int price = TovarRMKData.get(selectedIndex).getPrice();
        kolvo--;
        price = price * kolvo;
        TovarRMKData.get(selectedIndex).setKolvo(kolvo);
        TovarRMKData.get(selectedIndex).setSum(price);
         tableTovarRMK.refresh();
    }
    @FXML
      public void switchToBack() throws IOException{
        App.setRoot("Secondary");
    }
      private void initSmena(){
        try {
				File file = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader fr = new FileReader(file);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader reader = new BufferedReader(fr);
				// считаем сначала первую строку
				String line = reader.readLine();
			
                                int len = 0;
                                while (line != null){
                                len++;
                                line = reader.readLine();
                                }
                                len = len /3;
                                 String str = String.format("%d", len);
                                NumberSmenaLabel.setText(str);
				// считываем остальные строки в цикле
				
				
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
		}
    }
     private void initTovarPodbor() {
        
        
                 try {
				File file = new File("podbor.txt");
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
				String NameTovar = arrSplit[0];
                                int PriceTovar =  Integer.parseInt(arrSplit[1]);
                                //Запись в TableView
                               
                                TovarRMKData.add(new TovarRMK(PriceTovar, NameTovar, 1, 1, PriceTovar));
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

