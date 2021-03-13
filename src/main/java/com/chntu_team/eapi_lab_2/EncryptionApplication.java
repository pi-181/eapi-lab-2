package com.chntu_team.eapi_lab_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EncryptionApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("КТЗІ: ЛР №2");
        stage.setScene(scene);
        stage.show();
    }
}
