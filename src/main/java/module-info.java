module com.example.projetofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projetofinal to javafx.fxml;
    exports com.example.projetofinal;
}