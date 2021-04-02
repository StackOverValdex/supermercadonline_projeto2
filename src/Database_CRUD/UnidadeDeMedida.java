package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDeMedida
{
    private int id_unidadeMedida;
    private String nome_unidadeMedida;
    private String descricao;

    public int getId_unidadeMedid() {
        return id_unidadeMedida;
    }

    public void setId_unidadeMedid(int id_unidadeMedida) {
        this.id_unidadeMedida = id_unidadeMedida;
    }

    public String getNome_unidadeMedida() {
        return nome_unidadeMedida;
    }

    public void setNome_unidadeMedida(String nome_unidadeMedida) {
        this.nome_unidadeMedida = nome_unidadeMedida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarUnidadesDeMedida()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO UNIDADE_DE_MEDIDA COLUMNS(ID_UNIDADEMEDIDA,NOMEUNIDADEMEDIDA,DESCRICAO_UNIDADEMEDIDA)" +
                " VALUES(?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_unidadeMedida);
            st.setString(2, this.nome_unidadeMedida);
            st.setString(2, this.descricao);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<UnidadeDeMedida> listarUnidadesDeMedida()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_UNIDADEMEDIDA,NOMEUNIDADEMEDIDA,DESCRICAO_UNIDADEMEDIDA FROM UNIDADE_DE_MEDIDA";

        List<UnidadeDeMedida> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                UnidadeDeMedida unidademedida  = new UnidadeDeMedida();

                unidademedida.setId_unidadeMedid(rs.getInt("ID_UNIDADEMEDIDA"));
                if (rs.getString("NOMEUNIDADEMEDIDA") != null) unidademedida.setNome_unidadeMedida(rs.getString("NOMEUNIDADEMEDIDA"));
                if (rs.getString("DESCRICAO_UNIDADEMEDIDA") != null) unidademedida.setNome_unidadeMedida(rs.getString("DESCRICAO_UNIDADEMEDIDA"));
                //

                lista.add(unidademedida);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarUnidadesDeMedida(String command)
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

    public void eliminarUnidadesDeMedida(String command)
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
