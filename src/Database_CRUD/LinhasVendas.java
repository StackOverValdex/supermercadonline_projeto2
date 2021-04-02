package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinhasVendas
{
    private int id_venda;
    private int id_produto;
    private int quantidade;
    private float precoUnitario;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }


    public void adicionarLinhasVendas()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO LINHASVENDAS COLUMNSA(ID_VENDA, ID_PRODUTO, QUANTIDADE, PRECOUNITARIO)" +
                " VALUES(?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_venda);
            st.setInt(2, this.id_produto);
            st.setInt(3, this.quantidade);
            st.setFloat(4, this.precoUnitario);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<LinhasVendas> listarLinhasVendas()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_VENDA, ID_PRODUTO, QUANTIDADE, PRECOUNITARIO  FROM LINHASVENDAS";

        List<LinhasVendas> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                LinhasVendas linhasVendas  = new LinhasVendas();

                linhasVendas.setId_venda(rs.getInt("ID_VENDA"));
                if (rs.getString("ID_PRODUTO") != null)linhasVendas.setId_produto(rs.getInt("ID_PRODUTO"));
                if (rs.getString("QUANTIDADE") != null)linhasVendas.setQuantidade(rs.getInt("QUANTIDADE"));
                if (rs.getString("PRECOUNITARIO") != null) linhasVendas.setPrecoUnitario(rs.getFloat("PRECOUNITARIO"));


                //

                lista.add(linhasVendas);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarLinhasVendas(String command)
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

    public void eliminarLinhasVendas(String command)
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

