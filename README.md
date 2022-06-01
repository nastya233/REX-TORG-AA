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
    
    
    
    
    
   РЕГИСТРАЦИЯ ДРОНТАКСИ
    
    package com.mycompany.taxi;

    import com.mycompany.taxi.db.Roles;
    import com.mycompany.taxi.db.User;
    import java.io.IOException;
    import javafx.fxml.FXML;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.TextField;
    import javafx.scene.text.Text;
    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class SecondaryController {
         
         
         public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_taxi_jar_1.0-SNAPSHOTPU");
       public static EntityManager em = emf.createEntityManager();

    @FXML
    Text errorMesField;
    @FXML
    TextField loginField,emailField,phoneField,fioField;
    @FXML
    PasswordField passwordField;
    @FXML
    private void createAccount() throws IOException {
        
        String login = loginField.getText().toString();
        String password = passwordField.getText().toString();
        String email = emailField.getText().toString();
        String phone = phoneField.getText().toString();
        String fio = fioField.getText().toString();
        
        String errorMes = validation(login, password, email, phone, fio);
        if (errorMes != null){
            errorMesField.setText(errorMes);
        } else {
            em.getTransaction().begin();
                em.createNativeQuery("INSERT INTO user ( id_role, login, password, email, fio, phone) "
                    + " VALUES ( :a, :b, :c, :d, :f, :g)")
                    .setParameter("a", 1)
                    .setParameter("b", login)
                    .setParameter("c", password)
                    .setParameter("d", email)
                    .setParameter("f", fio)
                    .setParameter("g", phone).executeUpdate();
                em.getTransaction().commit();
            errorMesField.setText("УСПЕШНАЯ РЕГИСТРАЦИЯ!");

        }
    }
    @FXML
    private void goToLoginPane() throws IOException {
        App.setRoot("primary");
    }

    private String validation(String login, String password, String email, String phone, String fio) {
    if (login.length()<6){
        String mes ="логин должен быть длинее 6 символов";
        return mes;     
    }
    if (email.contains("@")) {

    } else {
        String mes ="введите корректный емейл";
        return mes;
    }
    if (fio.length()<2){
        String mes ="слишком короткое имя";
        return mes;
    }
        if (phone.length() != 15){   
        String mes ="введите номер по форме " +'\n'+"8-***-***-**-**";
        
        return mes;
    } else {
        String[] array = phone.split("-");
        if ((array[0].length() != 1)&&(array[1].length() != 3)&& 
                (array[2].length() != 3)&& (array[3].length() != 2)&& (array[4].length() != 2)){
        String mes ="введите номер по форме " +'\n'+"8-***-***-**-**";
        
        return mes;
        }
        }
    if (password.length() < 6 ){   
        String mes ="пароль должен быть длинее 6 символов";
        
        return mes;
    } else {
        if (password.matches(".*\\d.*")){
            
        } else {
            String mes ="пароль должен содержать хотя бы 1 цифру";
            return mes;
        }
    }
    return null;
    } }
    
    
    
    
    
    
