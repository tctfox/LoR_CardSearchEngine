package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Main_FX extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {


        //Parent root = FXMLLoader.load(getClass().getResource("/bigPicture.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/smallPicture.fxml"));

        primaryStage.sizeToScene();
        primaryStage.setTitle("LoR search Card engine");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Legends_Of_Runeterra_Monogram.png")));
        primaryStage.show();

    }

}
