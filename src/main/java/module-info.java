module com.example.demo10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.CRUD to javafx.fxml;
    exports com.example.CRUD;
}