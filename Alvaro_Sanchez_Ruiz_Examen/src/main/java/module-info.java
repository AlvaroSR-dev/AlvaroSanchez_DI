module com.example.alvaro_sanchez_ruiz_examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.alvaro_sanchez_ruiz_examen to javafx.fxml;
    requires org.json;
    requires com.google.gson;
    exports com.example.alvaro_sanchez_ruiz_examen;
}