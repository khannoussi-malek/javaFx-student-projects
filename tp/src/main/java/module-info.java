module com.malek.tp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.malek.tp to javafx.fxml;
    exports com.malek.tp;
}