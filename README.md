CONNECTIONRODATABASE

public class ConnectToDataBase {
    public static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("conf");
            private static org.hibernate.SessionFactory sessionFactory;

    public ConnectToDataBase() {

    }
    public static org.hibernate.SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = emf.unwrap(SessionFactory.class);
            emf.createEntityManager().persist(new User());
        }
        return sessionFactory;
    }
   

}


INTERFACE
 public int getRole(String login, String password) {
        User u = new User();
        u = findUser(login);
        if (password.equals(u.getPassword())){
        if (u.getRolesidRoles() == 1){
         return 1;
        } else{
         return 2;
        }
        } else return 0;
       }
   
    public User findUser(String login){
        return (User) ConnectToDataBase.getSessionFactory().openSession().createQuery("FROM User U WHERE U.login = '" + login +"'").uniqueResult();
    }
    public void saveUser(User user) {
            Session session = ConnectToDataBase.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }
public List<Client> findClients(){
        return (List<Client>) ConnectToDataBase.getSessionFactory().openSession().createQuery("FROM Client").list();
    }



LOGIN

VAR1

private void Login() throws IOException {
Interface inter = new Interface();
if(loginText.getText().equals(inter.findUser(loginText.getText()).getLogin())&& passwordText.getText().equals(inter.findUser(loginText.getText()).getPassword())&& inter.findUser(loginText.getText()).getRolesidRoles()==1){
App.setRoot("menu_admin");
}else{
App.setRoot("Client_manager");
}
}


VAR2

  @FXML
   private void Login() throws IOException {
        Interface inter = new Interface();
        int role = inter.getRole(loginText.getText(), passwordText.getText());
        if (role != 0){
        if (role == 1){
        App.setRoot("menu_admin");
        } else {
        App.setRoot("Client_manager");
        }
    }
}

PEREXOD

  @FXML
     private void priceSwitch(ActionEvent actionEvent) throws IOException {
        App.setRoot("price");
        
    }
}


TABEL


     @FXML public TableView<Client> tableClients;
     @FXML public TableColumn<Client, String> surnameColumn, nameColumn, patronymicColumn, numberColumn, priceColumn, typeColumn;

     @FXML public Button exitBitton;
   @FXML
     private void primarySwitch(ActionEvent actionEvent) throws IOException {
        App.setRoot("primary");
        
    }
    
    @FXML
    public void loadClients(){
    Interface inter = new Interface();

    List<Client> allClients = inter.findClients();

    surnameColumn.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> cd) -> {
    return new SimpleStringProperty(String.valueOf(cd.getValue().getSurname()));
        });

    ObservableList<Client> clients = FXCollections.observableList(allClients);
    tableClients.setItems(clients);
    }
    
    
    
    REGISTER
    
    
    
     private void switchToPrimary() throws IOException {
        
        try {
            Interface crud = new Interface();
            User user = new User();

            user.setLogin(loginTextField.getText());
            user.setPassword(passwordTextField.getText());
            user.setRolesidRoles(Integer.parseInt(roleTextField.getText()));

            user.setSurname(surnameTextField.getText());
            user.setName(nameTextField.getText());
            user.setPatronymic(pathronimiсTextField.getText());

            crud.saveUser(user);
            App.setRoot("primary");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    
    
    TESTIROVANIE 
    
    
    Тест № 1 – Проверка входа

Открыть сайт: https://gitlab.nntc.nnov.ru/users/sign_in.
В поле ввода "Логин" ввести: "egorycheva01".
В поле ввода "Пароль" ввести: "Egorycheva01".
Нажать на кнопку "Sign in".
Ожидаемый результат – пользователь на странице url https://gitlab.nntc.nnov.ru/


Тест № 2 –  Проверка выхода

Открыть сайт: https://gitlab.nntc.nnov.ru/users/sign_in.
В поле ввода "Логин" ввести: "egorycheva01".
В поле ввода "Пароль" ввести: "Egorycheva01".
Нажать на кнопку "Sign in".
Открыть выпадающий список справа сверху.
Нажать на "Sign out".
Ожидаемый результат - пользователь на странице url https://gitlab.nntc.nnov.ru/users/sign_in


Тест № 3 – Проверка имени профиля

Открыть сайт: https://gitlab.nntc.nnov.ru/users/sign_in.
В поле ввода "Логин" ввести: "egorycheva01".
В поле ввода "Пароль" ввести: "Egorycheva01".
Нажимать на кнопку "Sign in".
Открыть выпадающий список справа сверху.
Ожидаемый результат – Имя профиля у выпадающего списка справа сверху «Анастасия Егорычева»

Тест № 4 – Нажатие на кнопку группы

Открыть сайт: https://gitlab.nntc.nnov.ru/users/sign_in.
В поле ввода "Логин" ввести: "egorycheva01".
В поле ввода "Пароль" ввести: "Egorycheva01".
Нажать на кнопку "Sign in".
Нажать на кнопку Groups в левом верхнем углу
В выпадающем списке нажать на Your Groups
Ожидаемый результат - пользователь на странице url https://gitlab.nntc.nnov.ru/dashboard/groups


 
Тест № 5 – Нажатие на кнопку проблемы

Открыть сайт: https://gitlab.nntc.nnov.ru/users/sign_in.
В поле ввода "Логин" ввести: "egorycheva01".
В поле ввода "Пароль" ввести: "Egorycheva01".
Нажимать на кнопку "Sign in".
Нажать на кнопку Issues в правом верхнем углу

Ожидаемый результат - пользователь на странице url https://gitlab.nntc.nnov.ru/dashboard/issues?assignee_username=egorycheva01

