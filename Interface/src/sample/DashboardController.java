package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class DashboardController
{


    @FXML
    private void loadSideMenu(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample/sideMenu.fxml"));
       // Scene scene=button.getScene();
    }
}
