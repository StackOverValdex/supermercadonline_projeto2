package com.company;

import Database_CRUD.Codigo_Postal;

public class Main
{
    public static void main(String[] args)
    {



        oracleDB_connection.createConnection();

       // Cloneable
        //  create
        /*
        var cp = new Codigo_Postal();
        cp.setCaixapostal("4900-300");
        cp.setLocalidade("Viana do Castelo");
        cp.create();
        */

        //read
        /*
         List<Codigo_Postal> postalCode_list = Codigo_Postal.readAll();
        for (Codigo_Postal postalCode : postalCode_list)
        {
            System.out.println("Codigo Postal: " + postalCode.getCaixapostal() + "\n"
                    + "Localidade: " + postalCode.getLocalidade());
        }*/

        //update
        /*
        Codigo_Postal cpp=new Codigo_Postal();
        cpp.update();
        */

        //delete
        var cppp=new Codigo_Postal();
       // cppp.delete();
    }
}