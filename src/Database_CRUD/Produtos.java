package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Produtos
{
    private int id_produto;
    private int id_categoria;
    private int id_armazem;
    private String nomeProduto;
    private String validade;
    private int quantidade_em_stock;
    private float precoVenda;
    private int quantidade_minima_stock;
    private short estadoAtividade;
    private short id_unidadeMedida;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getInd_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQuantidade_em_stock() {
        return quantidade_em_stock;
    }

    public void setQuantidade_em_stock(int quantidade_em_stock) {
        this.quantidade_em_stock = quantidade_em_stock;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade_minima_stock() {
        return quantidade_minima_stock;
    }

    public void setQuantidade_minima_stock(int quantidade_minima_stock) {
        quantidade_minima_stock = quantidade_minima_stock;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public short getId_unidadeMedida() {
        return id_unidadeMedida;
    }

    public void setId_unidadeMedida(short id_unidadeMedida) {
        this.id_unidadeMedida = id_unidadeMedida;
    }


    public void adicionarProdutos()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO PRODUTOS COLUMNS(ID_PRODUTO, ID_CATEGORIA, ID_ARMAZEM, NOME_PRODUTO, VALIDADE, QUANTIDADE_EM_STOCK, PRECOVENDA, QUANTIDADE_MINIMA_STOCK, ESTADOATIVIDADE, ID_UNIDADEMEDIDA)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_produto);
            st.setInt(2, this.id_categoria);
            st.setInt(3, this.id_armazem);
            st.setString(4, this.nomeProduto);
            st.setString(5, this.validade);
            st.setInt(6, this.quantidade_em_stock);
            st.setFloat(7, this.precoVenda);
            st.setInt(8, this.quantidade_minima_stock);
            st.setShort(9, this.estadoAtividade);
            st.setInt(10, this.id_unidadeMedida);


            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Produtos> listarProdutos()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_PRODUTO, ID_CATEGORIA, ID_ARMAZEM, NOME_PRODUTO, VALIDADE, QUANTIDADE_EM_STOCK, PRECOVENDA, QUANTIDADE_MINIMA_STOCK, ESTADOATIVIDADE, ID_UNIDADEMEDIDA  FROM PRODUTOS";

        List<Produtos> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Produtos produtos  = new Produtos();

                produtos.setId_produto(rs.getInt("ID_PRODUTO"));
                if (rs.getString("ID_CATEGORIA") != null) produtos.setId_categoria(rs.getInt("ID_CATEGORIA"));
                if (rs.getString("ID_ARMAZEM") != null) produtos.setId_armazem(rs.getInt("ID_ARMAZEM"));
                if (rs.getString("NOME_PRODUTO") != null) produtos.setNomeProduto(rs.getString("NOME_PRODUTO"));
                if (rs.getString("VALIDADE") != null) produtos.setValidade(rs.getString("VALIDADE"));
                if (rs.getString("QUANTIDADE_EM_STOCK") != null) produtos.setQuantidade_em_stock(rs.getShort("QUANTIDADE_EM_STOCK"));
                if (rs.getString("PRECOVENDA") != null) produtos.setPrecoVenda(rs.getShort("PRECOVENDA"));
                if (rs.getString("QUANTIDADE_MINIMA_STOCK") != null) produtos.setQuantidade_minima_stock(rs.getInt("QUANTIDADE_MINIMA_STOCK"));
                if (rs.getString("ESTADOATIVIDADE") != null) produtos.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));
                if (rs.getString("ID_UNIDADEMEDIDA") != null) produtos.setId_unidadeMedida(rs.getShort("ID_UNIDADEMEDIDA"));
                //

                lista.add(produtos);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarProdutos(String command)
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

    public void eliminarProdutos(String command)
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
