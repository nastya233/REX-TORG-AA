АВТОРИЗАЦИЯ ДРОНТАКСИ


package com.example.taxi;

import java.sql.*;

public class Database {
    private Connection connection;
    private String ipDBServer = "localhost:3306";
    private String login = "user";
    private String password = "user";
    private String nameDB = "dronetaxi";
    Database() {
        String url = "jdbc:mysql://" + ipDBServer + "/" + nameDB + "?serverTimezone=Europe/Moscow";
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet login(String login, String password) {
        String select = "select U.*, R.name from user U, role R where login = " +
                "\"" + login + "\" and password = \"" + password + "\" and U.idrole = R.idrole";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.next()) {
                return rs;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}



package com.example.taxi;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.FXPermission;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckBox rememberCheckBox;
    @FXML
    private Text loginText;
    @FXML
    private Text passwordText;

 
 @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

public void toGO(ActionEvent actionEvent) throws IOException{
        if (loginField.getText().isBlank()) {
            loginText.setText("Логин: Заполните поле!");
            loginText.setFill(Color.web("#f29696"));
            passwordText.setText("Пароль");
            passwordText.setFill(Color.web("#eae7e7"));
        } else if (passwordField.getText().isBlank()) {
            loginText.setText("Логин");
            loginText.setFill(Color.web("#eae7e7"));
            passwordText.setText("Пароль: Заполните поле!");
            passwordText.setFill(Color.web("#f29696"));
        } else {
            Database database = new Database();
            ResultSet rs = database.login(loginField.getText(), passwordField.getText());
            if (rs != null) {
                loginText.setText("Логин");
                passwordText.setText("Пароль");
                loginText.setFill(Color.web("#eae7e7"));
                passwordText.setFill(Color.web("#eae7e7"));
                try {
                    User user = new User(rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getInt(4),
                            rs.getString(12));
                    HelloApplication.user = user;
                    HelloApplication.setRoot("prof");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                loginText.setText("Логин: Неверный логин или пароль!");
                passwordText.setText("Пароль: Неверный логин или пароль!");
                loginText.setFill(Color.web("#f29696"));
                passwordText.setFill(Color.web("#f29696"));
            }
        }

    }

   public void toReg(ActionEvent actionEvent) throws IOException{
        HelloApplication.setRoot("reg");

    }
}
