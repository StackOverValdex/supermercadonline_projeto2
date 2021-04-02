package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ferias
{
    private int id_ferias;
    private int id_funcionario;
    private String dataInicioFerias;
    private String dataFinalFerias;

    public int getId_ferias() {
        return id_ferias;
    }

    public void setId_ferias(int id_ferias) {
        this.id_ferias = id_ferias;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getDataInicioFerias() {
        return dataInicioFerias;
    }

    public void setDataInicioFerias(String dataInicioFerias) {
        this.dataInicioFerias = dataInicioFerias;
    }

    public String getDataFinalFerias() {
        return dataFinalFerias;
    }

    public void setDataFinalFerias(String dataFinalFerias) {
        this.dataFinalFerias = dataFinalFerias;
    }


    public void adicionarFerias()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO FERIAS COLUMNS(ID_FERIAS, ID_FUNCIONARIO, DATAINICIOFERIAS, DATAFINALFERIAS)" +
                " VALUES(?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_ferias);
            st.setInt(2, this.id_funcionario);
            st.setString(3, this.dataInicioFerias);
            st.setString(3, this.dataFinalFerias);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Ferias> listarFerias()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_Ferias,ID_ARMAZEM,CORREDOR  FROM Ferias";

        List<Ferias> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Ferias ferias  = new Ferias();

                ferias.setId_ferias(rs.getInt("ID_FERIAS"));
                if (rs.getString("ID_FUNCIONARIO") != null)ferias.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                if (rs.getString("DATAINICIOFERIAS") != null) ferias.setDataInicioFerias(rs.getString("DATAINICIOFERIAS"));
                if (rs.getString("DATAFINALFERIAS") != null) ferias.setDataFinalFerias(rs.getString("DATAFINALFERIAS"));

                //

                lista.add(ferias);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarFerias(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = command;

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

    public void eliminarFerias(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = command;

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
