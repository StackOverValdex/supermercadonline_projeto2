package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Codigo_Postal
{
    private String  caixapostal;
    private String localidade;

    public String getCaixapostal()
    {
        return caixapostal;
    }

    public void setCaixapostal(String caixapostal) {
        this.caixapostal = caixapostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    //
    public void adicionarCodigoPostais()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO CODIGOPOSTAL COLUMNS(CAIXAPOSTAL,LOCALIDADE) VALUES(?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setString(1, this.caixapostal);
            st.setString(2, this.localidade);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Codigo_Postal> listarCodigoPostais()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT CAIXAPOSTAL, LOCALIDADE FROM CODIGOPOSTAL";

        List<Codigo_Postal> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Codigo_Postal codigopostal  = new Codigo_Postal();

                codigopostal.setCaixapostal(rs.getString("CAIXAPOSTAL"));
                //
                if (rs.getString("LOCALIDADE") != null) codigopostal.setLocalidade(rs.getString("LOCALIDADE"));
                //

                lista.add(codigopostal);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarCodigoPostais()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "UPDATE CODIGOPOSTAL SET LOCALIDADE ='VIANA' WHERE LOCALIDADE LIKE 'V%'";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            System.out.println("Row updated successfully!");
        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public void eliminarCodigoPostais()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "DELETE FROM CODIGOPOSTAL  WHERE LOCALIDADE LIKE 'V%'";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            System.out.println("Row deleted successfully!");
        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }


}

