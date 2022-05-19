module be.helha.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    requires common;

    opens be.helha.client to javafx.fxml;
    exports be.helha.client;
}