package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Departamento
{
    private int id_departamento;
    private String nomeDepartamento;
    private short estadoAtividade;

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    
    public void adicionarDepartamento()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO DEPARTAMENTO COLUMNS(ID_DEPARTAMENTO, NOME_DEPARTAMENTO, ESTADOATIVIDADE)" +
                " VALUES(?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_departamento);
            st.setString(2, this.nomeDepartamento);
            st.setShort(3, this.estadoAtividade);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Departamento> listarDepartamento()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_DEPARTAMENTO, NOME_DEPARTAMENTO, ESTADOATIVIDADE  FROM DEPARTAMENTO";

        List<Departamento> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Departamento departamento  = new Departamento();

                departamento.setId_departamento(rs.getInt("ID_DEPARTAMENTIO"));
                if (rs.getString("NOME_DEPARTAMENTO") != null)departamento.setNomeDepartamento(rs.getString("NOME_DEPARTAMENTO"));
                if (rs.getString("ESTADOATIVIDADE") != null) departamento.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));

                //

                lista.add(departamento);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarDepartamento(String command)
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

    public void eliminarDepartamento(String command)
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
