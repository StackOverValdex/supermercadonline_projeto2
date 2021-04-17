package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class FxMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        final ImageView anImage = new ImageView();
        Image image1 = new Image(StackedBarM.class.getResourceAsStream("a.png"));
        anImage.setImage(image1);
        anImage.setFitWidth(40);
        anImage.setPreserveRatio(true);
        anImage.setSmooth(true);
        anImage.setCache(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
