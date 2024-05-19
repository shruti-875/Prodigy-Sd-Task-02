module org.example.guessinggame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.guessinggame to javafx.fxml;
    exports org.example.guessinggame;
}