package sample;

import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;

public class Controller extends Codigo_Postal
{

    public void pressButton(MouseEvent mouseEvent)
    {
        System.out.println("uwa");
        Codigo_Postal cp=new Codigo_Postal();
        cp.adicionarCodigoPostais("'4900-300'","'Viana'");
      cp.editarCodigoPostais("'SELECT *FROM CODIGOPOSTAL'");
    }
}
