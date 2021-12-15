module com.mycompany.rex.torg.aa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.base;

    opens com.mycompany.rex.torg.aa to javafx.fxml;
   opens mycompany.database;
    exports com.mycompany.rex.torg.aa;
}
