module sio.devoir1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;

    opens sio.devoir1.models;
    opens sio.devoir1 to javafx.fxml;
    exports sio.devoir1;
}