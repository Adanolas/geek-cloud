module com.gb.cloud.april2022.geekcloudapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gb.cloud to javafx.fxml;
    exports com.gb.cloud;
}