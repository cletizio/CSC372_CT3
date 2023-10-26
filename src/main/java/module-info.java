module com.example.ct3_opt1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ct3_opt1 to javafx.fxml;
    exports com.example.ct3_opt1;
}