package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class FxMain extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        primaryStage.setTitle("MarketWorld");
        primaryStage.setScene(new Scene(root, 300, 275));


        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);


    }
}
    //Parent root = FXMLLoader.load(getClass().getResource("views/homePage.fxml"));


   /* final ImageView anImage = new ImageView();

    Image image1 = new Image(StackedBarM.class.getResourceAsStream("@../../../../../Desktop/pexels-karolina-grabowska-5650028.jpg\"));

        anImage.setImage(image1);

                anImage.setFitWidth(40);

                anImage.setPreserveRatio(true);

                anImage.setSmooth(true);

                anImage.setCache(true);*/