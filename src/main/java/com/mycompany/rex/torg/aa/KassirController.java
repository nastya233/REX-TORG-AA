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
public class KassirController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void switchToRMK() throws IOException {

PrintWriter writer = new PrintWriter("podbor.txt");
writer.print("");
writer.close();
        
        try {
				File file = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader fr = new FileReader(file);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader reader = new BufferedReader(fr);
				
                                String line = reader.readLine();
                                int len = 0;
                                while (line != null){
                                len++;
                                line = reader.readLine();
                                }
                                // считаем сначала первую строку
                                File files = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader frs = new FileReader(files);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader readers = new BufferedReader(frs);
				
                                String lines = readers.readLine();
                                int lenHelp = 1;
                          
				while (lines != null) {
                                    if(len==lenHelp){

                                    if (Integer.parseInt(lines) == 0) {
                                    System.out.println("Смена закрыта!");
                                    return;
                                    } else {
                                       App.setRoot("RMK");
                                
                                    }
                                    }else{lenHelp++;}
                                
                                    
                                
				// считываем остальные строки в цикле
				lines = readers.readLine();
				}
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
		}        
        

    }
    @FXML
    public void OpenSmena() throws IOException {
        
        
        try {
				File file = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader fr = new FileReader(file);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader reader = new BufferedReader(fr);
				
                                String line = reader.readLine();
                                int len = 0;
                                while (line != null){
                                len++;
                                line = reader.readLine();
                                }
                                // считаем сначала первую строку
                                File files = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader frs = new FileReader(files);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader readers = new BufferedReader(frs);
				
                                String lines = readers.readLine();
                                int lenHelp = 1;
                          
				while (lines != null) {
                                    if(len==lenHelp){
                                    if (Integer.parseInt(lines) == 1) {
                                    System.out.println("Смена не закрыта!");
                                    return;
                                    } else {
                                       PrintWriter writer2 = new PrintWriter((new FileWriter("smena.txt", true)));
                                       len = len+2;
                                       len = len / 3;
                                       writer2.println(len);
                                       writer2.println("1");
                                       
                                       writer2.close();
                                       System.out.println("Смена открыта!");
                                       return;
                                
                                    }
                                    }else{lenHelp++;}
                                
                                    
                                
				// считываем остальные строки в цикле
				lines = readers.readLine();
				}
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
		}
    }
    @FXML    
    public void CloseSmena() throws IOException {
        
        
        try {
				File file = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader fr = new FileReader(file);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader reader = new BufferedReader(fr);
				
                                String line = reader.readLine();
                                int len = 0;
                                while (line != null){
                                len++;
                                line = reader.readLine();
                                }
                                // считаем сначала первую строку
                                File files = new File("smena.txt");
				//создаем объект FileReader для объекта File
				FileReader frs = new FileReader(files);
				//создаем BufferedReader с существующего FileReader для построчного считывания
				BufferedReader readers = new BufferedReader(frs);
				
                                String lines = readers.readLine();
                                int lenHelp = 1;
                          
				while (lines != null) {
                                    if(len==lenHelp){

                                    if (Integer.parseInt(lines) == 0) {
                                    System.out.println("Смена уже закрыта!");
                                    return;
                                    } else {
                                       PrintWriter writer2 = new PrintWriter((new FileWriter("smena.txt", true)));
                                       writer2.println("0");
                                       
                                       writer2.close();
                                       System.out.println("Смена закрыта!");
                                       return;
                                
                                    }
                                    }else{lenHelp++;}
                                
                                    
                                
				// считываем остальные строки в цикле
				lines = readers.readLine();
				}
				} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
		}
}
}