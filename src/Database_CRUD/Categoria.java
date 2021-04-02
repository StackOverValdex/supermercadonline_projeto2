package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categoria
{
    private int id_categoria;
    private String nome_categoria;
    private String descricao;
    private short estadoAtividade;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public void adicionarCategoria()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO CATEGORIA COLUMNS(ID_CATEGORIA, NOME_CATEGORIA, DESCRICAO_CATEGORIA, ESTADOATIVIDADE)" +
                " VALUES(?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_categoria);
            st.setString(2, this.nome_categoria);
            st.setString(3, this.descricao);
            st.setShort(4, this.estadoAtividade);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Categoria> listarCategoria()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_CATEGORIA, NOME_CATEGORIA, DESCRICAO_CATEGORIA, ESTADOATIVIDADE  FROM CATEGORIA";

        List<Categoria> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Categoria categoria  = new Categoria();

                categoria.setId_categoria(rs.getInt("ID_DEPARTAMENTIO"));
                if (rs.getString("NOME_CATEGORIA") != null)categoria.setNome_categoria(rs.getString("NOME_CATEGORIA"));
                if (rs.getString("DESCRICAO_CATEGORIA") != null)categoria.setDescricao(rs.getString("DESCRICAO_CATEGORIA"));
                if (rs.getString("ESTADOATIVIDADE") != null) categoria.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));

                //

                lista.add(categoria);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarCategoria(String command)
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

    public void eliminarCategoria(String command)
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
