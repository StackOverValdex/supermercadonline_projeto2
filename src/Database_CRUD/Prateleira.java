package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prateleira
{
    private int id_prateleira;
    private int id_armazem;
    private int corredor;

    public int getId_prateleira() {
        return id_prateleira;
    }

    public void setId_prateleira(int id_prateleira) {
        this.id_prateleira = id_prateleira;
    }

    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    public int getCorredor() {
        return corredor;
    }

    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }


    public void adicionarPrateleira()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO PRATELEIRA COLUMNS(ID_PRATELEIRA,ID_ARMAZEM,CORREDOR)" +
                " VALUES(?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_prateleira);
            st.setInt(2, this.id_armazem);
            st.setInt(3, this.corredor);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Prateleira> listarPrateleira()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_PRATELEIRA,ID_ARMAZEM,CORREDOR  FROM PRATELEIRA";

        List<Prateleira> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Prateleira prateleira  = new Prateleira();

                prateleira.setId_prateleira(rs.getInt("ID_UNIDADEMEDIDA"));
                if (rs.getString("ID_ARMAZEM") != null) prateleira.setId_armazem(rs.getInt("ID_ARMAZEM"));
                if (rs.getString("CORREDOR") != null) prateleira.setCorredor(rs.getInt("CORREDOR"));
                //

                lista.add(prateleira);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarPrateleira(String command)
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

    public void eliminarPrateleira(String command)
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
