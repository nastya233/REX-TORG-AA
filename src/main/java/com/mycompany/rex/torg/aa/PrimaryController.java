package com.mycompany.rex.torg.aa;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import mycompany.database.*;



public class PrimaryController {
public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_REX-TORG-AA_jar_1.0-SNAPSHOTPU");
 public static EntityManager em = emf.createEntityManager();

    @FXML
    private Label messageArea;

    @FXML
    private TextField loginTextField;
    
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void switchToSecondary() throws IOException {
     
        //Parent parent = App.getRoot();


       // String login = loginTextField.getText();
      //  String password = passwordTextField.getPassword();
        
      //  if (login.equals("1") && password.equals("1")){
        
      //  } else {
     //  System.out.println("Неверный логин или пароль"); 

        

        /* Query q = em.createNamedQuery("User.findByLogin");

       q.setParameter("login",loginTextField.getText());
      
try {
            User u = (User) q.getSingleResult();
            System.out.println("Debug user:  " + u);
             if (u.getPassword().equals(passwordTextField.getText())) {
              App.setRoot("secondary");
                
} else {
               messageArea.setText("Неверный логин или пароль");
            }

 } catch (NoResultException e) {
            messageArea.setText("Неверный логин или пароль");
        }*/
    }
@FXML
    private void switchRegistration() throws IOException {
    App.setRoot("reegistration");
    }
    
    }
   
    


